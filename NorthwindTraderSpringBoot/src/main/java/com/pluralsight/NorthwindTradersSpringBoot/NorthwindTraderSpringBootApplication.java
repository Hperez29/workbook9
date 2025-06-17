package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class NorthwindTraderSpringBootApplication implements CommandLineRunner {

	@Autowired
	private ProductDao productDao;

	public static void main(String[] args) {
		SpringApplication.run(NorthwindTraderSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\n1. List Products\n2. Add Product\n0. Exit");
			String choice = scanner.nextLine();
			switch (choice) {
				case "1":
					List<Product> products = productDao.getAll();
					products.forEach(p -> System.out.printf(
							"%d: %s (%s) - $%.2f%n",
							p.getProductId(), p.getName(), p.getCategory(), p.getPrice()));
					break;

				case "2":
					try {
						System.out.print("ID: ");
						int id = Integer.parseInt(scanner.nextLine());
						System.out.print("Name: ");
						String name = scanner.nextLine();
						System.out.print("Category: ");
						String cat = scanner.nextLine();
						System.out.print("Price: ");
						double price = Double.parseDouble(scanner.nextLine());
						productDao.add(new Product(id, name, cat, price));
						System.out.println("Product added.");
					} catch (NumberFormatException e) {
						System.out.println("Invalid number input. Please try again.");
					}
					break;

				case "0":
					System.out.println("Bye!");
					return;

				default:
					System.out.println("Invalid option.");
			}
		}
	}
}