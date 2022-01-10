import java.io.IOException;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Repo repo = new Repo();
        Service service = new Service();
        try {
            List<Customer> customerList = repo.readFromFile("C:\\Users\\razva\\OneDrive\\Documents\\UBBIG\\Semester3\\MAP\\Labor\\Postescu_Razvan_722_2_Practic_A2\\kundendaten.txt");
            repo.writeToFile("C:\\Users\\razva\\OneDrive\\Documents\\UBBIG\\Semester3\\MAP\\Labor\\Postescu_Razvan_722_2_Practic_A2\\kundensortiert.txt", service.sortCustomerListByEmployeesDesc(customerList));
            repo.writeStats("C:\\Users\\razva\\OneDrive\\Documents\\UBBIG\\Semester3\\MAP\\Labor\\Postescu_Razvan_722_2_Practic_A2\\statistik.txt", service.getPlacesWithHighestIncome(customerList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
