package service;

import dao.AppointmentDao;
import dao.CustomerDao;
import dao.ServiceDao;
import exception.EntityNotFoundException;
import model.Appointment;
import model.Customer;
import model.Service;

import java.util.List;

public class CustomerService {
    private final CustomerDao customerDao;
    private final ServiceDao serviceDao;
    private final AppointmentDao appointmentDao;

    private final IdGenerationService idGenerationService;

    public CustomerService(final CustomerDao customerDao,
                           final ServiceDao serviceDao,
                           final AppointmentDao appointmentDao,
                           final IdGenerationService idGenerationService) {
        this.customerDao = customerDao;
        this.serviceDao = serviceDao;
        this.appointmentDao = appointmentDao;
        this.idGenerationService = idGenerationService;
    }

    public Customer getCustomer(final String name) {
        return customerDao.getByName(name);
    }

    public Customer upsertCustomer(final String name) {
        final Customer existingCustomer = customerDao.getByName(name);
        final String id = existingCustomer == null ? idGenerationService.generateId("CS") :
                existingCustomer.getId();
        final Customer customer = new Customer(id, name);
        customerDao.upsert(customer, id);
        return customer;
    }

    public void deleteCustomer(final String name) {
        final Customer existingCustomer = customerDao.getByName(name);
        if (existingCustomer == null) {
            throw new EntityNotFoundException("Customer with name "+name+" not found");
        }
        customerDao.delete(existingCustomer.getId());
    }

    public List<Service> searchServiceByName(final String serviceName) {
        return serviceDao.getAllServiceContaining(serviceName);
    }

    public Appointment createAppointmentRequest(final String customerName,
                                                final String slotId) {
        final String id = idGenerationService.generateId("AP");
        final Customer customer = customerDao.getByName(customerName);
        return new Appointment(id, customer.getId(), slotId);
    }
}
