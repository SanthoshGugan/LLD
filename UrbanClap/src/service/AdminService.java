package service;

import dao.*;
import model.Appointment;
import model.AvailableSlot;
import model.Slot;
import strategy.SearchAndMatchAppointmentStrategy;
import strategy.SearchByTimeRangeSearchAndMatchStrategy;

import java.time.LocalTime;
import java.util.List;

public class AdminService {
    private final SlotDao slotDao;
    private final AppointmentDao appointmentDao;
    private final CustomerDao customerDao;
    private final AvailableSlotDao availableSlotDao;
    private final ProfessionalDao professionalDao;
    private final IdGenerationService idGenerationService;
    private SearchAndMatchAppointmentStrategy searchAndMatchAppointment;

    public AdminService(SlotDao slotDao,
                        AppointmentDao appointmentDao,
                        CustomerDao customerDao,
                        AvailableSlotDao availableSlotDao,
                        ProfessionalDao professionalDao,
                        IdGenerationService idGenerationService) {
        this.slotDao = slotDao;
        this.appointmentDao = appointmentDao;
        this.customerDao = customerDao;
        this.availableSlotDao = availableSlotDao;
        this.professionalDao = professionalDao;
        this.idGenerationService = idGenerationService;
        this.searchAndMatchAppointment = new SearchByTimeRangeSearchAndMatchStrategy();
    }

    public void setSearchAndMatchAppointment(final SearchAndMatchAppointmentStrategy searchAndMatchAppointmentStrategy) {
        this.searchAndMatchAppointment = searchAndMatchAppointmentStrategy;
    }

    public Slot addSlot(final String name,
                        final LocalTime startsAt,
                        final LocalTime endsAt) {
        // should add validation to check if slot in range already exists
        final String id = idGenerationService.generateId("SL");
        final Slot slot = new Slot(id, startsAt, endsAt, name);
        slotDao.upsert(slot, id);
        return slot;
    }

    public Appointment searchAndMatchAppointment(final Appointment appointment) {
        final List<AvailableSlot> slotsByService = availableSlotDao.getAvailableSlots(appointment.getServiceId());
        final AvailableSlot allottedAvailableSlot = searchAndMatchAppointment.searchAndMatch(
                appointment,
                slotsByService
        );
        final Appointment updatedAppointment = appointmentDao.get(appointment.getId());
        updatedAppointment.setSlotId(allottedAvailableSlot.getSlotId());
        updatedAppointment.setProfessionalId(allottedAvailableSlot.getProfessionalId());
        appointmentDao.upsert(updatedAppointment, updatedAppointment.getId());
        return updatedAppointment;
    }
}
