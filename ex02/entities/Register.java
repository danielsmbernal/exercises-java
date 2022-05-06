package entities;

public class Register {

    public static int listAbove50;
    private int age;
    private double height;
    private double weight;

    public Register() {
    }

    public Register(int age, double height, double weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString () {
        return "\nAGE: " 
               + age 
               +"\nHEIGHT: "
               +String.format("%.2f m", height)
               +"\nWEIGHT: "
               +String.format("%.2f kg", weight);   
    }
}