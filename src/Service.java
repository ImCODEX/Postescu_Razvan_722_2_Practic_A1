import java.util.*;

public class Service {
    /**
     * Sorts the given list of customers by their number of employees.
     * @param customerList: List of customers
     * @return Sorted list of customers
     */
    public List<Customer> sortCustomerListByEmployeesDesc(List<Customer> customerList) {
        return customerList.stream()
                .sorted(Comparator.comparingInt(Customer::getNrEmployees))
                .toList();
    }

    /**
     * Creates a top of the locations and their respective incomes.
     * @param customerList: List of customers
     * @return List of Map Entries with pairs of Location and Income
     */
    public List<Map.Entry<String, Integer>> getPlacesWithHighestIncome(List<Customer> customerList) {
        Map<String, Integer> placesWithIncomes = new HashMap<>();
        for (Customer customer : customerList) {
            if (placesWithIncomes.containsKey(customer.getLocation()))
                placesWithIncomes.replace(customer.getLocation(), placesWithIncomes.get(customer.getLocation()) + customer.getIncome());
            else placesWithIncomes.put(customer.getLocation(), customer.getIncome());
        }
        return placesWithIncomes.entrySet().stream().
                sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).toList();
    }
}