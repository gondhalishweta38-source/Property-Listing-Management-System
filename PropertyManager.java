import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyManager {

    private List<Property> properties = new ArrayList<>();

    public void addProperty(Property property) {
        properties.add(property);
        System.out.println("Property Added Successfully!");
    }

    public void viewProperties() {
        if (properties.isEmpty()) {
            System.out.println("No Properties Available!");
            return;
        }

        properties.forEach(System.out::println);
    }

    public void searchByCity(String city) {
        List<Property> result = properties.stream()
                .filter(p -> p.city().equalsIgnoreCase(city))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No Properties Found!");
        } else {
            result.forEach(System.out::println);
        }
    }

    public void filterByPrice(double min, double max) {
        List<Property> result = properties.stream()
                .filter(p -> p.price() >= min && p.price() <= max)
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No Properties Found!");
        } else {
            result.forEach(System.out::println);
        }
    }

    public void sortByPrice() {
        properties.stream()
                .sorted(Comparator.comparingDouble(Property::price))
                .forEach(System.out::println);
    }

    public void deleteProperty(int id) {
        boolean removed = properties.removeIf(p -> p.id() == id);

        if (removed) {
            System.out.println("Property Deleted!");
        } else {
            System.out.println("Property Not Found!");
        }
    }
}