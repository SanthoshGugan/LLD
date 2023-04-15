package dao;

import exception.EntityNotFoundException;
import model.Service;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceDao extends Dao<Service, String>{

    private static ServiceDao serviceDao;

    private ServiceDao() {
        super("id");
    }

    public static ServiceDao getInstance() {
        if (serviceDao == null) {
            serviceDao = new ServiceDao();
        }
        return serviceDao;
    }

    public Service getByName(final String name) {
        return getAll().stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Service not found "+name));

    }

    public List<Service> getAllServiceContaining(final String name) {
        return getAll().stream()
                .filter(s -> s.getName().contains(name))
                .collect(Collectors.toList());
    }
}
