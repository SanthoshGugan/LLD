package dao;

import exception.EntityNotFoundException;
import model.Professional;

public class ProfessionalDao extends Dao<Professional, String>{

    private static ProfessionalDao professionalDao;

    private ProfessionalDao() {
        super("id");
    }

    public static ProfessionalDao getInstance() {
        if (professionalDao == null) {
            professionalDao = new ProfessionalDao();
        }
        return professionalDao;
    }

    public Professional getByName(final String name) {
        return super.getAll().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Professional not found"));
    }
}
