package service;

import dao.AvailableSlotDao;
import dao.ProfessionalDao;
import dao.ServiceDao;
import dao.ServiceProvidedDao;
import model.AvailableSlot;
import model.Professional;
import model.Service;
import model.ServiceProvided;

import java.time.LocalDate;
import java.util.List;

public class ProfessionalService {

    private ProfessionalDao professionalDao;
    private ServiceDao serviceDao;
    private ServiceProvidedDao serviceProvidedDao;
    private AvailableSlotDao availableSlotDao;

    private IdGenerationService idGenerationService;

	public ProfessionalService(final ProfessionalDao professionalDao,
                               final ServiceDao serviceDao,
                               final ServiceProvidedDao serviceProvidedDao,
                               final AvailableSlotDao availableSlotDao,
                               final IdGenerationService idGenerationService
                               ) {
        this.serviceProvidedDao = serviceProvidedDao;
        this.professionalDao = professionalDao;
        this.serviceDao = serviceDao;
        this.availableSlotDao = availableSlotDao;
        this.idGenerationService = idGenerationService;
    }

    public Professional get(final String professionalId) {
        return professionalDao.get(professionalId);
    }
    public Professional getByName(final String name) {
        return professionalDao.getByName(name);
    }

    public void upsertProfessional(final String name,
                                   final List<String> availablePinCode) {
        final Professional existingProfessional = professionalDao.getByName(name);
        final String id = existingProfessional != null ? existingProfessional.getId() :
                idGenerationService.generateId("PR");
        final Professional professional = new Professional(
                id,
                name,
                availablePinCode
        );
        professionalDao.upsert(professional, id);
    }

    public Professional delete(final String id) {
        return professionalDao.delete(id);
    }

    public List<ServiceProvided> getServiceProvided(final String professionalName) {
        final Professional professional = professionalDao.getByName(professionalName);
        return serviceProvidedDao.getServiceProvided(professional.getId());
    }

    public void addServiceProvided(final String serviceName,
                                   final String professionalName,
                                   final double fee) {
        final Service service = serviceDao.getByName(serviceName);
        final Professional professional = professionalDao.getByName(professionalName);

        final String id = idGenerationService.generateId("SP");
        serviceProvidedDao.upsert(new ServiceProvided(id,
                professional.getId(),
                service.getId(),
                fee), id);
    }

    public void deleteServiceProvided(final String serviceName,
                                      final String professionalName) {
        final Service service = serviceDao.getByName(serviceName);
        final Professional professional = professionalDao.getByName(professionalName);

        final ServiceProvided serviceProvided = serviceProvidedDao.getServiceProvided(professional.getId(),
                service.getId());
        serviceProvidedDao.delete(serviceProvided.getId());
    }

    public AvailableSlot addSlotForServiceProvided(final String serviceName,
                                                   final String professionalName,
                                                   final String slotId,
                                                   final LocalDate date) {
        final Professional professional = professionalDao.getByName(professionalName);
        final Service service = serviceDao.getByName(serviceName);
        final AvailableSlot availableSlot = new AvailableSlot(slotId,
                professional.getId(),
                service.getId(),
                date
        );
        final String id = idGenerationService.generateId("AS");
        availableSlotDao.upsert(availableSlot, id);
        return availableSlot;
    }

}
