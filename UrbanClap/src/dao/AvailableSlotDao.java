package dao;

import model.AvailableSlot;

import java.util.List;
import java.util.stream.Collectors;

public class AvailableSlotDao extends Dao<AvailableSlot, String>{

    private static AvailableSlotDao availableSlotDao;
    private AvailableSlotDao() {
        super("id");
    }

    public static AvailableSlotDao getInstance() {
        if (availableSlotDao == null) {
            availableSlotDao = new AvailableSlotDao();
        }
        return availableSlotDao;
    }

    public List<AvailableSlot> getAvailableSlots(final String professionalId,
                                                final String serviceId) {
        return getAll().stream()
                .filter(s -> s.getProfessionalId().equalsIgnoreCase(professionalId)
                    && s.getServiceId().equalsIgnoreCase(serviceId))
                .collect(Collectors.toList());
    }

    public List<AvailableSlot> getAvailableSlots(final String serviceId) {
        return getAll().stream()
                .filter(s -> s.getServiceId().equalsIgnoreCase(serviceId))
                .collect(Collectors.toList());
    }


}
