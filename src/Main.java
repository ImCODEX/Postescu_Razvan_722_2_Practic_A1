import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Repo repo = new Repo();
        Service service = new Service();
        try {
            List<Customer> customerList = repo.readFromFile("kundendaten.txt");
            repo.writeToFile("kundensortiert.txt", service.sortCustomerListByEmployeesDesc(customerList));
            repo.writeStats("statistik.txt", service.getPlacesWithHighestIncome(customerList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
