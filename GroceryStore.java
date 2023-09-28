// Step 1: Define the interfaces
interface GroceryProduct {
    String getName();
    double getPrice();
    void setName(String name);
    void setPrice(double price);
}

interface GroceryProductFactory {
    GroceryProduct createProduct();
}

// Step 2: Implement the concrete classes
class Banana implements GroceryProduct {
    private String name;
    private double price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}

class BananaFactory implements GroceryProductFactory {
    @Override
    public GroceryProduct createProduct() {
        Banana banana = new Banana();
        // Read price from the database (file) and set it for Banana
        // Replace this logic with your file reading implementation
        double priceFromDatabase = readPriceFromDatabase("Banana");
        banana.setPrice(priceFromDatabase);
        banana.setName("Banana");
        return banana;
    }

    // Simulate reading price from the database (file)
    private double readPriceFromDatabase(String productName) {
        // Replace this with actual file reading logic
        // For simplicity, we'll just return some fixed prices here.
        if (productName.equals("Banana")) {
            return 0.99;
        }
        return 0.0; // Default price
    }
}

// Similar implementation for Apple and AppleFactory

class Apple implements GroceryProduct {
    // Implementation for Apple
}

class AppleFactory implements GroceryProductFactory {
    // Implementation for AppleFactory
}

public class GroceryStore {
    public static void main(String[] args) {
        // Test driver
        GroceryProductFactory bananaFactory = new BananaFactory();
        GroceryProduct banana = bananaFactory.createProduct();

        System.out.println("Product: " + banana.getName());
        System.out.println("Price: $" + banana.getPrice());

        // Create and test an Apple
        GroceryProductFactory appleFactory = new AppleFactory();
        GroceryProduct apple = appleFactory.createProduct();

        System.out.println("Product: " + apple.getName());
        System.out.println("Price: $" + apple.getPrice());
    }
}
