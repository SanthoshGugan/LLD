package dao;

import model.Appointment;

public class AppointmentDao extends Dao<Appointment, String> {

    private static AppointmentDao appointmentDao;
    private AppointmentDao() {
        super("id");
    }

    public static AppointmentDao getInstance() {
        if (appointmentDao == null) {
            appointmentDao = new AppointmentDao();
        }
        return appointmentDao;
    }
}
