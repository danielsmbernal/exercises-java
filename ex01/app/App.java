package ex01.app;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import ex01.entities.Client;
import ex01.entities.Order;
import ex01.entities.OrderItem;
import ex01.entities.Product;
import ex01.enums.OrderStatus;

class App {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");

        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Email: ");
        String email = input.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf1.parse(input.next());

        Client client = new Client(name, email, birthDate);

        System.out.println("\nEnter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(input.next());

        Order order = new Order(new Date(), status, client);

        System.out.print("\nHow many items to this order? ");
        int numberItems = input.nextInt();

        for (int i=0; i<numberItems; i++) {
            System.out.println("\nEnter #" + (i + 1) + " item data: ");
            System.out.print("Product name: ");
            input.nextLine();
            String productName = input.nextLine();
            System.out.print("Product price: ");
            double productPrice = input.nextDouble();
            
            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            int quantity = input.nextInt();

            OrderItem orderItem = new OrderItem(quantity, productPrice, product);

            order.addItem(orderItem);
        }
        
        System.out.println();
        System.out.println("\nORDER SUMARRY: ");
        System.out.println(order);   

        input.close();
    }

}