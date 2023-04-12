package strategy;

import exception.SlotsNotAvailableException;
import model.Appointment;
import model.AvailableSlot;

import java.time.LocalDate;
import java.util.List;

public class SearchByTimeRangeSearchAndMatchStrategy
    implements SearchAndMatchAppointmentStrategy {

    @Override
    public AvailableSlot searchAndMatch(final Appointment appointment,
                                        final List<AvailableSlot> availableSlots) {
        final String appointmentServiceId = appointment.getServiceId();
        final String appointmentSlotId = appointment.getSlotId();
        final LocalDate appointmentDate = appointment.getDate();

        return availableSlots.stream()
                .filter(as -> as.getServiceId().equalsIgnoreCase(appointmentServiceId)
                    && as.getSlotId().equalsIgnoreCase(appointmentSlotId)
                    && as.getDate().isEqual(appointmentDate))
                .findFirst()
//                .orElseThrow(() -> new SlotsNotAvailableException("No matching slots available for the appointment"))
                .orElse(null);
    }

}
