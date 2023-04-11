package dao;

import exception.EntityNotFoundException;
import model.ServiceProvided;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceProvidedDao extends Dao<ServiceProvided, String>{

    private static ServiceProvidedDao serviceProvidedDao;
    private ServiceProvidedDao() {
        super("id");
    }

    public static ServiceProvidedDao getInstance() {
        if (serviceProvidedDao == null) {
            serviceProvidedDao = new ServiceProvidedDao();
        }
        return serviceProvidedDao;
    }

    public List<ServiceProvided> getServiceProvided(final String professionalId) {
        return super.getAll().stream()
                .filter(s -> s.getProfessionalId().equalsIgnoreCase(professionalId))
                .collect(Collectors.toList());
    }

    public ServiceProvided getServiceProvided(final String professionalId,
                                              final String serviceId) {
        return getAll().stream()
                .filter(sp -> sp.getProfessionalId().equalsIgnoreCase(professionalId)
                && sp.getServiceId().equalsIgnoreCase(serviceId))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Service Provided not found"));

    }
}
