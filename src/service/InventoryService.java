package service;

import java.util.ArrayList;
import java.util.List;
import model.Product;

public class InventoryService {
    private List<Product> inventory;

    public InventoryService() {
        inventory = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (findProductById(product.getId()) != null) {
            System.out.println("Product with ID " + product.getId() + " already exists.");
        } else {
            inventory.add(product);
            System.out.println("Product added: " + product.getName());
        }
    }

    public void removeProduct(int id) {
        boolean removed = inventory.removeIf(product -> product.getId() == id);
        if (removed) {
            System.out.println("Product with ID " + id + " removed.");
        } else {
            System.out.println("Product with ID " + id + " not found.");
        }
    }

    public void listProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : inventory) {
                System.out.println(product);
            }
        }
    }

    public Product findProductById(int id) {
        for (Product product : inventory) {
            if (product.getId() == id) return product;
        }
        return null;
    }

    public void updateQuantity(int id, int newQuantity) {
        Product product = findProductById(id);
        if (product != null) {
            product.setQuantity(newQuantity);
            System.out.println("Updated quantity for product: " + product.getName());
        } else {
            System.out.println("Product not found.");
        }
    }

    // Add this method
    public List<Product> getAllProducts() {
        return inventory;
    }
}
