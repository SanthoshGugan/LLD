import dao.*;
import model.Appointment;
import model.Service;
import model.Slot;
import service.AdminService;
import service.CustomerService;
import service.IdGenerationService;
import service.ProfessionalService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UrbanClapApplication {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //setup dao
        final var professionalDao = ProfessionalDao.getInstance();
        final var serviceDao = ServiceDao.getInstance();
        final var serviceProvidedDao = ServiceProvidedDao.getInstance();
        final var slotDao = SlotDao.getInstance();
        final var availableSlot = AvailableSlotDao.getInstance();
        final var customerDao = CustomerDao.getInstance();
        final var appointmentDao = AppointmentDao.getInstance();

        // setup services
        final var idGenerationService = new IdGenerationService();
        final var professionalService = new ProfessionalService(professionalDao, serviceDao, serviceProvidedDao,
                availableSlot, idGenerationService);
        final var customerService = new CustomerService(customerDao, serviceDao, appointmentDao, idGenerationService);
        final var adminService = new AdminService(slotDao, appointmentDao, customerDao,
                availableSlot, professionalDao, serviceDao, idGenerationService);

        // matching engine
        final var matchingEngine = new MatchingEngine(adminService);

        // Services Available
        final Service plumbingService = adminService.addService("Plumbing");
        final Service electricianService = adminService.addService("Electrician");
        final Service houseCleaningService = adminService.addService("House Cleaning");
        final Service automobileWashService = adminService.addService("Automobile Wash");
        final Service houseMaidService = adminService.addService("House Maid");
        final Service homeApplicancesRepairService = adminService.addService("Home Appliances Repair");

        // add slots
        final Slot morning1Slot = adminService.addSlot("Morning 1", LocalTime.of(8, 00, 00), LocalTime.of(9, 00, 00));
        final Slot morning2Slot = adminService.addSlot("Morning 2", LocalTime.of(9, 00, 00), LocalTime.of(10, 00, 00));
        final Slot morning3Slot = adminService.addSlot("Morning 3", LocalTime.of(10, 00, 00), LocalTime.of(11, 00, 00));
        final Slot morning4Slot = adminService.addSlot("Morning 4", LocalTime.of(11, 00, 00), LocalTime.of(12, 00, 00));
        final Slot noonSlot = adminService.addSlot("Noon", LocalTime.of(12, 00, 00), LocalTime.of(13, 00, 00));
        final Slot afternoon1Slot = adminService.addSlot("Afternoon 1", LocalTime.of(13, 00, 00), LocalTime.of(14, 00, 00));
        final Slot afternoon2Slot = adminService.addSlot("Afternoon 2", LocalTime.of(14, 00, 00), LocalTime.of(15, 00, 00));
        final Slot afternoon3Slot = adminService.addSlot("Afternoon 3", LocalTime.of(15, 00, 00), LocalTime.of(16, 00, 00));
        final Slot evening1Slot = adminService.addSlot("Evening 1", LocalTime.of(16, 00, 00), LocalTime.of(17, 00, 00));
        final Slot evening2Slot = adminService.addSlot("Evening 2", LocalTime.of(17, 00, 00), LocalTime.of(18, 00, 00));


        // professionals
        professionalService.upsertProfessional("Raj", List.of("600147", "600145", "600144", "600146"));
        professionalService.addServiceProvided("Electrician", "Raj", 50.00);
        professionalService.addSlotForServiceProvided("Electrician", "Raj", morning1Slot.getId(), LocalDate.of(2023, 04, 14));
        professionalService.addSlotForServiceProvided("Electrician", "Raj", morning2Slot.getId(), LocalDate.of(2023, 04, 14));
        professionalService.addSlotForServiceProvided("Electrician", "Raj", morning3Slot.getId(), LocalDate.of(2023, 04, 14));
        professionalService.addSlotForServiceProvided("Electrician", "Raj", morning4Slot.getId(), LocalDate.of(2023, 04, 14));
        professionalService.addSlotForServiceProvided("Electrician", "Raj", noonSlot.getId(), LocalDate.of(2023, 04, 14));


        professionalService.upsertProfessional("Kumar", List.of("600147", "600145", "600144"));
        professionalService.addServiceProvided("House Cleaning", "Kumar", 25.00);
        professionalService.addSlotForServiceProvided("House Cleaning", "Kumar", morning1Slot.getId(), LocalDate.of(2023, 04, 14));
        professionalService.addSlotForServiceProvided("House Cleaning", "Kumar", morning2Slot.getId(), LocalDate.of(2023, 04, 14));
        professionalService.addSlotForServiceProvided("House Cleaning", "Kumar", evening1Slot.getId(), LocalDate.of(2023, 04, 14));
        professionalService.addSlotForServiceProvided("House Cleaning", "Kumar", evening2Slot.getId(), LocalDate.of(2023, 04, 14));

        // Customer
        customerService.upsertCustomer("Rajesh");
        final Appointment appointment = customerService.createAppointmentRequest("Rajesh", morning1Slot.getId(), electricianService.getId(), LocalDate.of(2023, 4, 14));
        final Appointment updatedAppointment1 = matchingEngine.match(appointment);
        System.out.println(" Professional Selected : "+ professionalService.get(updatedAppointment1.getProfessionalId()).getName());

        customerService.upsertCustomer("Jayesh");
        final Appointment appointment_another = customerService.createAppointmentRequest("Jayesh", afternoon2Slot.getId(), electricianService.getId(), LocalDate.of(2023, 4, 14));
        final Appointment updatedAppointmentAnother = matchingEngine.match(appointment_another);
        System.out.println(" No professional found for the slot : "+updatedAppointmentAnother.getProfessionalId());


        // closes Engine
        matchingEngine.exit();
    }
}