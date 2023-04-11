package model;

import java.time.LocalDate;

public class AvailableSlot {
    private String slotId;
    private String professionalId;
    private String serviceId;
    private LocalDate date;

    public AvailableSlot(String slotId, String professionalId, String serviceId, LocalDate date) {
        this.slotId = slotId;
        this.professionalId = professionalId;
        this.serviceId = serviceId;
        this.date = date;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(String professionalId) {
        this.professionalId = professionalId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
