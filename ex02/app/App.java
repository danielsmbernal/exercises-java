package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Register;

public class App {
    public static void main(String[] args) throws Exception {
        
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List <Register> list = new ArrayList<>();

        for (int i=0; i<5; i++) {
            System.out.println("Register #" + (i+1));
            System.out.print("Type the age: ");
            int age = input.nextInt();
            System.out.print("Type the height: ");
            double height = input.nextDouble();
            System.out.print("Type the weight: ");
            double weight = input.nextDouble();
            Register register = new Register(age, height, weight);
            list.add(register);
            System.out.println();
        }
                
        List <Register> listAbove50 = list.stream().filter(x -> x.getAge() > 50).collect(Collectors.toList());
        System.out.println("People above 50 years of age: " + listAbove50.size());

        List <Register> averageHeight = list.stream().filter(x -> x.getAge() >= 10 && x.getAge() <= 20).collect(Collectors.toList());
        double average = calcHeightAverage(averageHeight);
        System.out.println("\nThe average height from people with age between 10 and 20 years is: " + average / averageHeight.size());

        List <Register> lessThen40 = list.stream().filter(x -> x.getWeight() < 40).collect(Collectors.toList());
        int percentage = (lessThen40.size() * 100 / 5);
        System.out.print("\nThe percentage of people with less then 88 pounds is: " + percentage + "%");       

        input.close();
    }

    static double calcHeightAverage (List <Register> list) {
        double sum = 0;
        for (int i=0; i<list.size(); i++) {
        sum += list.get(i).getHeight(); 
        }
        return sum;
    }
}
