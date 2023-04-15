package strategy;

import model.Appointment;
import model.AvailableSlot;

import java.util.List;

public interface SearchAndMatchAppointmentStrategy {

    AvailableSlot searchAndMatch(final Appointment appointment,
                                        final List<AvailableSlot> slots);
}
