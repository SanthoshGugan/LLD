package model;

import java.util.List;

public class Professional {
    private String id;
    private String name;
    private List<String> availablePinCode;

    public Professional(String id, String name, List<String> availablePinCode) {
        this.id = id;
        this.name = name;
        this.availablePinCode = availablePinCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAvailablePinCode() {
        return availablePinCode;
    }

    public void setAvailablePinCode(List<String> availablePinCode) {
        this.availablePinCode = availablePinCode;
    }
}
