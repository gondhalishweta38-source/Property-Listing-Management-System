import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PropertyManager manager = new PropertyManager();

        while (true) {

            System.out.println("\n===== Property Listing Management System =====");
            System.out.println("1. Add Property");
            System.out.println("2. View All Properties");
            System.out.println("3. Search By City");
            System.out.println("4. Filter By Price Range");
            System.out.println("5. Sort By Price");
            System.out.println("6. Delete Property");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Property ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter City: ");
                    String city = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Property Type: ");
                    String type = sc.nextLine();

                    manager.addProperty(
                            new Property(id, city, price, type));

                    break;

                case 2:
                    manager.viewProperties();
                    break;

                case 3:

                    sc.nextLine();

                    System.out.print("Enter City: ");
                    String searchCity = sc.nextLine();

                    manager.searchByCity(searchCity);
                    break;

                case 4:

                    System.out.print("Minimum Price: ");
                    double min = sc.nextDouble();

                    System.out.print("Maximum Price: ");
                    double max = sc.nextDouble();

                    manager.filterByPrice(min, max);
                    break;

                case 5:
                    manager.sortByPrice();
                    break;

                case 6:

                    System.out.print("Enter Property ID To Delete: ");
                    int deleteId = sc.nextInt();

                    manager.deleteProperty(deleteId);
                    break;

                case 7:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}