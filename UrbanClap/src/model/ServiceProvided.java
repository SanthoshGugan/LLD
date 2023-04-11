package model;

public class ServiceProvided {
    private String id;
    private String professionalId;
    private String serviceId;

    private double fee;

    public ServiceProvided(String id, String professionalId, String serviceId, double fee) {
        this.id = id;
        this.professionalId = professionalId;
        this.serviceId = serviceId;
        this.fee = fee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(String professionalId) {
        this.professionalId = professionalId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
