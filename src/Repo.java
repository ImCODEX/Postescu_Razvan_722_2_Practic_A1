import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Repo {
    /**
     * Parses the file and creates and instance of Customer for each line of data.
     * @param fileName String with relative path of the file
     * @return List of read customers
     * @throws IOException: Thrown by BufferedReader
     */
    public List<Customer> readFromFile(String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();
        String[] attributes;
        Customer customer;
        List<Customer> customerList = new ArrayList<>();
        while (line != null) {
            attributes = line.split(",");
            customer = new Customer(Integer.parseInt(attributes[0]), attributes[1], CompanySize.valueOf(attributes[2]), Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]), attributes[5]);
            customerList.add(customer);
            line = bufferedReader.readLine();
        }
        return customerList;
    }

    /**
     * Iterates over the list and writes each customer to the file.
     * @param fileName String with relative path of the file
     * @param customerList List of customers to write
     * @throws IOException Thrown by BufferedWriter
     */
    public void writeToFile(String fileName, List<Customer> customerList) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Customer customer : customerList) {
            bufferedWriter.write(customer.toString());
        }
        bufferedWriter.close();
    }

    /**
     * Iterates over the list and writes each pair to the file.
     * @param fileName String with relative path of the file
     * @param placesWithIncomes List of Map entries containing each location and its income
     * @throws IOException Thrown by BufferedWriter
     */
    public void writeStats(String fileName, List<Map.Entry<String, Integer>> placesWithIncomes) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Map.Entry<String, Integer> placeWithIncome : placesWithIncomes) {
            bufferedWriter.write(placeWithIncome.getKey() + ": " + placeWithIncome.getValue() + '\n');
        }
        bufferedWriter.close();
    }
}
