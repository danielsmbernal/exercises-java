package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        List <TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int numberOfTaxPayers = input.nextInt();

        for (int i = 1; i <= numberOfTaxPayers; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char answer = input.next().charAt(0);
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = input.nextDouble();

            if (answer == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpending = input.nextDouble();

                list.add(new Individual(name, annualIncome, healthExpending));
                
            } else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = input.nextInt();

                list.add(new Company(name, annualIncome, numberOfEmployees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID: ");
        double taxesSum = 0;
        for (TaxPayer taxPayer : list) {
            System.out.println(taxPayer.getName()
                               + ": $ "
                               + String.format("%.2f", taxPayer.taxes()));
            taxesSum += taxPayer.taxes();
        }

        System.out.println();
        System.out.print("TOTAL TAXES: $ " + String.format("%.2f", taxesSum));

        input.close();

    }
}
