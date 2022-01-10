public class Customer {
    private int id;
    private String companyName;
    private CompanySize companySize;
    private int nrEmployees, income;
    private String location;

    public Customer(int id, String companyName, CompanySize companySize, int nrEmployees, int income, String location) {
        this.id = id;
        this.companyName = companyName;
        this.companySize = companySize;
        this.nrEmployees = nrEmployees;
        this.income = income;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public CompanySize getCompanySize() {
        return companySize;
    }

    public int getNrEmployees() {
        return nrEmployees;
    }

    public int getIncome() {
        return income;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return id +
                "," + companyName +
                "," + companySize +
                "," + nrEmployees +
                "," + income +
                "," + location +
                '\n';
    }
}
