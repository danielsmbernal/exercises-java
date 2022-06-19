package entities;

public class Company extends TaxPayer {

    private Integer numberOfEmployees;

    public Company(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double taxes () {
        double result = 0;
        if (numberOfEmployees < 10) {
            result = annualIncome * 0.16;
        } else {
            result = annualIncome * 0.14;
        }

        return result;
    }
}
