package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class FileInventoryService extends InventoryService {
    private static final String FILE_NAME = "inventory.txt";

    public FileInventoryService() {
        loadFromFile();
    }

    @Override
    public void addProduct(Product product) {
        super.addProduct(product);
        saveToFile();
    }

    @Override
    public void removeProduct(int productId) {
        super.removeProduct(productId);
        saveToFile();
    }

    @Override
    public void updateQuantity(int productId, int newQuantity) {
        super.updateQuantity(productId, newQuantity);
        saveToFile();
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Product p : getProductList()) {
                writer.write(p.getId() + "," + p.getName() + "," + p.getQuantity() + "," + p.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save inventory: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    int qty = Integer.parseInt(parts[2]);
                    double price = Double.parseDouble(parts[3]);
                    super.addProduct(new Product(id, name, qty, price));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Failed to load inventory: " + e.getMessage());
        }
    }

    private List<Product> getProductList() {
        return new ArrayList<>(super.getAllProducts());
    }
}
