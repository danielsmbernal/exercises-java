package entities;

public class Individual extends TaxPayer {

    private Double healthExpending;

    public Individual(String name, Double annualIncome, Double healthExpending) {
        super(name, annualIncome);
        this.healthExpending = healthExpending;
    }

    public Double getHealthExpending() {
        return healthExpending;
    }

    public void setHealthExpending(Double healthExpending) {
        this.healthExpending = healthExpending;
    }

    @Override
    public Double taxes() {
        double result = 0;
        if (annualIncome < 20000.00) {
            result = annualIncome * 0.15 - healthExpending * 0.5;
        } else {
            result = annualIncome * 0.25 - healthExpending * 0.5;
        }
         return result;
    }
    
    
}
