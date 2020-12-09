package serviceLayer;

import businessLayer.Customer;
import dataAccessLayer.CustomerDao;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {

    public void addCustomer(String filePath, Customer customer) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        CustomerDao dao = new CustomerDao(filePath);
        dao.addCustomer(customer);
    }

    public Customer getCustomerByName(String filePath, String name) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        CustomerDao dao = new CustomerDao(filePath);
        return  dao.getCustomerByName(name);
    }
}
