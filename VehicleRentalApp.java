import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Parent class: Vehicle
abstract class Vehicle {      
	private String vehicleId;
	private String brand;
	private String model;
	private double basePricePerDay;
	private boolean isAvailable;
	
	// Constructor to initialize vehicle details
	public Vehicle(String vehicleId, String brand, String model, double basePricePerDay) {
		this.vehicleId = vehicleId;
		this.brand = brand;
		this.model = model;
		this.basePricePerDay = basePricePerDay;
		this.isAvailable = true;   // Vehicles are available by default

	}
    
    // Getters for vehicle details
	public String getVehicleId() {
		return vehicleId;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getBasePricePerDay() {
		return basePricePerDay;
	}
	
    // Calculate rental cost based on rental days
	public double calculatePrice(int rentalDays) {
		return basePricePerDay * rentalDays;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
    
    // Methods to rent or return a vehicle
	public void rent() {
		isAvailable = false;
	}
    public void returnVehicle() {
		isAvailable = true;
	}

	public abstract String getType(); // Each vehicle has a type (Car, Bike, Scooty)

}

// Child classes inheriting Vehicle
class Car extends Vehicle {
	public Car(String vehicleId, String brand, String model, double basePricePerDay) {
		super(vehicleId, brand, model, basePricePerDay);
	}

	@Override
	public String getType() {
		return "Car";
	}
}

class Bike extends Vehicle {
	public Bike(String vehicleId, String brand, String model, double basePricePerDay) {
		super(vehicleId, brand, model, basePricePerDay);
	}

	@Override
	public String getType() {
		return "Bike";
	}
}

class Scooty extends Vehicle {
	public Scooty(String vehicleId, String brand, String model, double basePricePerDay) {
		super(vehicleId, brand, model, basePricePerDay);
	}

	@Override
	public String getType() {
		return "Scooty";
	}
}

// Customer class to store customer information
class Customer {
	private String customerId;
	private String name;

	public Customer(String customerId, String name) {
		this.customerId = customerId;
		this.name = name;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}
}

// Rental class for managing vehicle rentals
class Rental {
	private Vehicle vehicle;
	private Customer customer;
	private int days;

	public Rental(Vehicle vehicle, Customer customer, int days) {
		this.vehicle = vehicle;
		this.customer = customer;
		this.days = days;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getDays() {
		return days;
	}

	public void generateReceipt() {
		System.out.println("\n===== Rental Receipt =====");
		System.out.println("Customer Name: " + customer.getName());
		System.out.println("Customer ID: " + customer.getCustomerId());
		System.out.println("Vehicle Model: " + vehicle.getBrand() + " " + vehicle.getModel());
		System.out.println("Vehicle Type: " + vehicle.getType());
		System.out.println("Rental Days: " + days);
		System.out.println("Total Price: $" + vehicle.calculatePrice(days));
		System.out.println("=========================\n");
	}
}

// Return class to process vehicle returns
class Return {
	private Rental rental;

	public Return(Rental rental) {
		this.rental = rental;
	}

	public void processReturn() { 
		if (rental != null && rental.getVehicle() != null) {
			rental.getVehicle().returnVehicle();// Mark vehicle as available
			System.out.println("\nVehicle returned successfully by " + rental.getCustomer().getName());
			generateReturnReceipt(); // Generate return receipt
		} else {
			System.out.println("\nInvalid vehicle ID or vehicle was not rented."); // Correct error handling
		}
	}

	public void generateReturnReceipt() {
		System.out.println("\n===== Return Receipt =====");
		System.out.println("Customer Name: " + rental.getCustomer().getName());
		System.out.println("Customer ID: " + rental.getCustomer().getCustomerId());
		System.out.println("Vehicle Model: " + rental.getVehicle().getBrand() + " " + rental.getVehicle().getModel());
		System.out.println("Vehicle Type: " + rental.getVehicle().getType());
		System.out.println("Rental Days: " + rental.getDays());
		System.out.println("Total Price Paid: $" + rental.getVehicle().calculatePrice(rental.getDays()));
		System.out.println("=========================\n");
	}
}

// Vehicle Rental System class managing rental operations
class VehicleRentalSystem {
	private List<Vehicle> vehicles;
	private List<Customer> customers;
	private List<Rental> rentals;

	public VehicleRentalSystem() {
		vehicles = new ArrayList<>();
		customers = new ArrayList<>();
		rentals = new ArrayList<>();
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public void rentVehicle(Vehicle vehicle, Customer customer, int days) {
		if (vehicle.isAvailable()) {
			vehicle.rent();
			Rental newRental = new Rental(vehicle, customer, days);
			rentals.add(newRental);
			System.out.println("\nVehicle rented successfully.");
			newRental.generateReceipt(); // Generate receipt after rental
		} else {
			System.out.println("\nVehicle is not available for rent.");
		}
	}

	public void returnVehicle(String vehicleId) {
		Rental rentalToRemove = null;
		for (Rental rental : rentals) {
			if (rental.getVehicle().getVehicleId().equals(vehicleId)) {
				rentalToRemove = rental;
				break;
			}
		}

		if (rentalToRemove != null) {
			new Return(rentalToRemove).processReturn();
			rentals.remove(rentalToRemove);
		} else {
			System.out.println("\nInvalid vehicle ID or vehicle was not rented.");
		}
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in); // Declare once

		while (true) { // Loop to keep the menu running
			System.out.println("\n===== Vehicle Rental System =====");
			System.out.println("1. Rent a Vehicle");
			System.out.println("2. Return a Vehicle");
			System.out.println("3. Exit");
			System.out.println("=================================");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1: // Initiating Rental system
				System.out.print("\nEnter your name: ");
				String customerName = scanner.nextLine();

				System.out.println("\nAvailable Vehicles:");
				for (Vehicle vehicle : vehicles) {
					if (vehicle.isAvailable()) {
						System.out.println(vehicle.getVehicleId() + " - " + vehicle.getType() + " : " +
						                   vehicle.getBrand() + " : " + vehicle.getModel() + " : " + vehicle.getBasePricePerDay());
					}
				}

				System.out.print("\nEnter the vehicle ID you want to rent: ");
				String vehicleId = scanner.nextLine();

				System.out.print("Enter the number of days for rental: ");
				int rentalDays = scanner.nextInt();
				scanner.nextLine();

				Customer newCustomer = new Customer("CUS" + System.currentTimeMillis(), customerName); // Unique ID
				addCustomer(newCustomer);

				boolean rentalSuccessful = false;
				for (Vehicle vehicle : vehicles) {
					if (vehicle.getVehicleId().equals(vehicleId) && vehicle.isAvailable()) {
						rentVehicle(vehicle, newCustomer, rentalDays);
						rentalSuccessful = true;
						break;
					}
				}

				if (!rentalSuccessful) {
					System.out.println("\nInvalid vehicle selection or vehicle not available.");
				}
				break;

			case 2: //Initiating return system
				System.out.print("\nEnter the vehicle ID you want to return: ");
				vehicleId = scanner.nextLine();
				returnVehicle(vehicleId);
				break;

			case 3: //Exits the code
				System.out.println("\nThank you for using the Vehicle Rental System!");
				scanner.close(); // Close scanner properly
				return;

			default:
				System.out.println("\nInvalid choice. Please enter a valid option.");
			}
		}
	}
}
// Main Class
public class VehicleRentalApp{
	public static void main(String[] args) {
		VehicleRentalSystem rentalSystem = new VehicleRentalSystem();

		// Adding some vehicles to the system
		rentalSystem.addVehicle(new Car("V001", "Mahindra", "Thar", 60.0));
		rentalSystem.addVehicle(new Bike("V002", "Yamaha", "R15", 50.0));
		rentalSystem.addVehicle(new Scooty("V003", "Honda", "Activa", 40.0));
		
		// Launching the menu system
		rentalSystem.menu();
	}
}