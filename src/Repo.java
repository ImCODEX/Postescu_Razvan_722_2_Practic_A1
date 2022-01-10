import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Repo {
    public List<Customer> readFromFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();
        String[] attributes;
        Customer customer;
        List<Customer> customerList = new ArrayList<>();
        while (line != null) {
            attributes = line.split(",");
            customer = new Customer(Integer.parseInt(attributes[0]), attributes[1], attributes[2], Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]), attributes[5]);
            customerList.add(customer);
            line = bufferedReader.readLine();
        }
        return customerList;
    }

    public void writeToFile(String fileName, List<Customer> customerList) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Customer customer : customerList) {
            bufferedWriter.write(customer.toString());
        }
        bufferedWriter.close();
    }

    public void writeStats(String fileName, List<Map.Entry<String, Integer>> placesWithIncomes) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Map.Entry<String, Integer> placeWithIncome : placesWithIncomes) {
            bufferedWriter.write(placeWithIncome.getKey() + ": " + placeWithIncome.getValue() + '\n');
        }
        bufferedWriter.close();
    }
}
