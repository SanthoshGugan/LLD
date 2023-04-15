package dao;

import model.Customer;

public class CustomerDao extends Dao<Customer, String>{

    private static CustomerDao customerDao;
    private CustomerDao() {
        super("id");
    }

    public static CustomerDao getInstance() {
        if (customerDao == null) {
            customerDao = new CustomerDao();
        }
        return customerDao;
    }

    public Customer getByName(final String name) {
        return getAll().stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
