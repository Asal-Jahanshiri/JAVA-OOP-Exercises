import java.util.ArrayList;
import java.util.List;

public class  Bank {
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("New customer added: " + customer);
    }

    public Customer find_customer(String name, String accountNumber){
        for(Customer customer : customers){
            if(customer.getName().equals(name) && customer.getAccountNumber().equals(accountNumber)){
                return customer;
            }
        }
        return null;
    }

}