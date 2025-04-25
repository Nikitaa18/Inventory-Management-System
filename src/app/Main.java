package app;

import model.Product;
import service.FileInventoryService;
import util.ValidationUtil;

public class Main {
    public static void main(String[] args) {
        FileInventoryService inventoryService = new FileInventoryService();

        while (true) {
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. List Products");
            System.out.println("4. Update Quantity");
            System.out.println("5. Exit");

            int choice = ValidationUtil.getInt("Choose an option: ");

            switch (choice) {
                case 1:
                    int id = ValidationUtil.getInt("Enter Product ID: ");
                    String name = ValidationUtil.getString("Enter Product Name: ");
                    int qty = ValidationUtil.getInt("Enter Quantity: ");
                    double price = ValidationUtil.getDouble("Enter Price: ");
                    Product newProduct = new Product(id, name, qty, price);
                    inventoryService.addProduct(newProduct);
                    break;

                case 2:
                    int removeId = ValidationUtil.getInt("Enter Product ID to remove: ");
                    inventoryService.removeProduct(removeId);
                    break;

                case 3:
                    inventoryService.listProducts();
                    break;

                case 4:
                    int updateId = ValidationUtil.getInt("Enter Product ID to update: ");
                    int newQty = ValidationUtil.getInt("Enter new quantity: ");
                    inventoryService.updateQuantity(updateId, newQty);
                    break;

                case 5:
                    System.out.println("Exiting system.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
