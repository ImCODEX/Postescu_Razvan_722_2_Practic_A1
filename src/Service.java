import java.util.*;
import java.util.stream.Collectors;

public class Service {

    public List<Customer> sortCustomerListByEmployeesDesc(List<Customer> customerList) {
        return customerList.stream()
                .sorted(Comparator.comparingInt(Customer::getNrEmployees))
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Integer>> getPlacesWithHighestIncome(List<Customer> customerList) {
        Map<String, Integer> placesWithIncomes = new HashMap<>();
        for (Customer customer : customerList) {
            if (placesWithIncomes.containsKey(customer.getLocation()))
                placesWithIncomes.replace(customer.getLocation(), placesWithIncomes.get(customer.getLocation()) + customer.getIncome());
            else placesWithIncomes.put(customer.getLocation(), customer.getIncome());
        }
        return placesWithIncomes.entrySet().stream().
                sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                collect(Collectors.toList());
    }
}