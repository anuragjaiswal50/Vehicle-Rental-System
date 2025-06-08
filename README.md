# **🚘 Vehicle Rental System**
##  **📜 Introduction**
The Vehicle Rental System is a Java-based application designed to provide efficient vehicle rentals and returns. Customers can rent cars, bikes, and scooters for a specified duration, process returns, and generate receipts for their transactions.
This system follows object-oriented programming principles such as inheritance, abstraction, encapsulation, and polymorphism, making it scalable, maintainable, and modular. Using a menu-driven interface, users can interact with rental services seamlessly while maintaining accurate vehicle availability records.

## **✨ Features**
✅ Vehicle Rental and Return Management – Customers can rent available vehicles and return them after use.
📜 Automatic Receipt Generation – Rental and return receipts provide clear transaction details.
🚦 Real-time Availability Tracking – Vehicles are dynamically marked as rented or available.
👤 Customer Information Management – Each customer is uniquely identified and linked to their rental records.
🛠️ Error Handling & Validation – Prevents invalid transactions, ensuring smooth system operation.
🧩 Modular & Scalable Architecture – Designed for easy extension, supporting new vehicle types and enhancements.

# **🛠️ Project Structure**
## **🚗 Vehicle (Abstract Class)**
Defines common attributes and functionalities shared by all vehicles.

**🏷️ Attributes:**
- Unique identifier distinguishing each vehicle.
- Brand name indicating the manufacturer.
- Model name specifying the type.
- Base rental price per day defining cost.
- Boolean flag tracking availability status.

**⚙️ Methods:**
- calculatePrice(int rentalDays) – Computes total rental cost based on rental duration.
- rent() – Marks vehicle as unavailable upon renting.
- returnVehicle() – Restores availability when returned.
- getType() – Abstract method for subclasses to define vehicle type.
- Getter methods – Retrieve brand, model, rental price, and availability status.
🚘 Car, 🏍️ Bike, 🛵 Scooty (Subclasses of Vehicle)
Each subclass inherits from Vehicle and implements getType() to return its specific type.

## **🚘 Car Class**
Represents four-wheeled vehicles designed for comfortable passenger transport.
- Large size, supporting multiple passengers.
- Higher rental cost, ideal for long-distance travel.
- getType() returns "Car".

## **🏍️ Bike Class**
Represents two-wheeled motorized vehicles, often used by individual riders.
- Compact and lightweight, designed for speed.
- Moderate rental price, positioned between cars and scooters.
- getType() returns "Bike".

## **🛵 Scooty Class**
Represents lightweight, easy-to-ride vehicles, perfect for urban commuting.
- Budget-friendly rental cost.
- Ideal for short-distance travel.
- getType() returns "Scooty".

## **👤 Customer Class**
Stores customer details and maintains accurate rental records.
🏷️ Attributes:
- Unique identifier assigned to each customer.
- Customer name linked to rental records.

**⚙️ Methods:**
- getCustomerId() – Retrieves customer ID.
- getName() – Retrieves customer name.

## **📜 Rental Class**
Handles vehicle rental transactions, linking customers to their rented vehicles.
**🏷️ Attributes:**
- Vehicle object referring to the rented vehicle.
- Customer object associated with the rental.
- Rental duration specifying the number of days.

**⚙️ Methods:**
- generateReceipt() – Generates a detailed rental receipt with transaction details.
- Getter methods – Retrieve vehicle, customer, and rental period.

## 🔄 Return Class
Manages the vehicle return process, updating availability and generating confirmation receipts.
**🏷️ Attributes:**
- Rental object referring to the returning transaction.

**⚙️ Methods:**
- processReturn() – Marks vehicle as available after verification.
- generateReturnReceipt() – Generates return confirmation, listing payment details.

## **⚙️ VehicleRentalSystem Class**
Acts as the central manager for rental transactions and system operations.
**🏷️ Attributes:**
- List of available vehicles in inventory.
- List of registered customers stored in the system.
- List of active rentals maintaining transaction records.

**⚙️ Methods:**
- addVehicle(Vehicle vehicle) – Registers new vehicles in the system.
- addCustomer(Customer customer) – Adds customers during rental transactions.
- rentVehicle(Vehicle vehicle, Customer customer, int days) –
- Verifies availability before renting.
- Marks vehicle as rented and generates a receipt.
- returnVehicle(String vehicleId) –
- Searches rental records for vehicle identifier.
- Processes the return, restoring availability.
- Generates a return receipt confirming transaction.
- menu() – Offers an interactive menu-driven system for user transactions.

## **🚀 VehicleRentalApp Class**
The entry point of the system.

**⚙️ Methods:**
- main() – Initializes the VehicleRentalSystem and registers predefined vehicles.
- Launches menu-driven system, allowing user interaction.

# **🔎 Core Implementation Details**
## **🛠️ Error Handling & Robustness**
- Validates input to prevent incorrect selections.
- Ensures unavailable vehicles cannot be rented.
- Displays clear error messages for invalid transactions.
- Implements exception handling for stability.
- Closes resources properly to avoid memory leaks.

## **🔗 Integration of Components**
- Maintains smooth interaction between Vehicle, Customer, Rental, Return, and System Modules.
- Updates availability instantly after rentals and returns.
- Modular system architecture allows easy enhancements.

## **🔄 Event Handling & Processing**
- Menu-driven interface ensures smooth user interactions.
- Real-time updates prevent rental conflicts.

## **✅ Data Validation**
- Verifies valid input before processing transactions.
- Checks vehicle availability before rental approval.
- Confirms rental duration is a positive integer.

## **🎯 Code Quality & Innovation**
- Object-oriented principles ensure scalability.
- Automatic unique customer ID generation.
- Detailed documentation for maintenance and debugging.

## **📌 Setup & Usage Guide**
🔧 Prerequisites
- Java JDK (Version 8 or later).
- VS Code (Recommended IDEs), Github.

## **🚀 Installation & Execution**
1️⃣ Clone or download the project files.
2️⃣ Open the project in an IDE.
3️⃣ Compile and run the main application file.
4️⃣ Follow the menu-driven system to rent or return vehicles.

## **🔮 Future Enhancements**
- Database integration for storing rental history and customer records.
- Graphical User Interface (GUI) for an improved user experience.
- Online booking system for reserving vehicles in advance.

---

## **🔄 Workflow Documentation**  

### **1️⃣ Vehicle Addition Process**  
✔ **Purpose:** Register vehicles into the system for rental availability.  

**Workflow:**  
1. **Administrator adds a new vehicle** using `addVehicle()`.  
2. Each vehicle is assigned **a unique ID, brand, model, and base rental price**.  
3. The vehicle is **marked as available by default**.  
4. The **vehicle list updates in the system inventory**, making it accessible for rentals.  

---

### **2️⃣ Customer Registration & Rental Process**  
✔ **Purpose:** Allow customers to rent available vehicles.  

**Workflow:**  
1. **Customer provides their name** for registration.  
2. The system **generates a unique Customer ID**.  
3. The system **displays available vehicles** for selection.  
4. **Customer selects a vehicle** using its unique ID.  
5. The system **checks availability** and processes rental via `rentVehicle()`.  
6. The vehicle status **updates to unavailable**.  
7. The rental **record is stored** in the system for tracking.  
8. A **rental receipt** is generated, detailing the transaction.  

---

### **3️⃣ Returning a Vehicle Process**  
✔ **Purpose:** Enable customers to return rented vehicles.  

**Workflow:**  
1. **Customer provides the Vehicle ID** of the rented vehicle.  
2. The system **verifies if the vehicle is currently rented**.  
3. Vehicle status **updates to available via returnVehicle()**.  
4. The **rental record is removed** from the system, ensuring accurate inventory tracking.  
5. A **return receipt** is generated, confirming the return process.  

---

### **4️⃣ Menu Navigation Workflow**  
✔ **Purpose:** Allow users to interact with the system.  

**Workflow:**  
1. The system **displays a main menu** with the following options:  
   - **Rent a Vehicle**  
   - **Return a Vehicle**  
   - **Exit**  
2. The user **chooses an action** based on their requirement.  
3. The system **executes the selected process** (Rental or Return).  
4. If the user selects **Exit**, the program terminates.  

---

### **5️⃣ Error Handling Process**  
✔ **Purpose:** Handle **invalid inputs and prevent system errors**.  

**Workflow:**  
- If the user enters an **invalid Vehicle ID**, the system **displays an error message**.  
- If the **vehicle is already rented**, the system **prevents duplicate rentals**.  
- If the user **tries to return a non-rented vehicle**, an error message appears.  
- Proper **exception handling prevents crashes and ensures smooth operations**.  


## **📌 Conclusion**

The **Vehicle Rental System** successfully streamlines the process of renting and returning vehicles while maintaining **real-time availability tracking, automatic receipt generation, and error handling**. The system is built using **object-oriented programming principles**, ensuring **modularity, scalability, and maintainability**.

Through its **menu-driven interface**, customers can **easily interact** with the system, renting vehicles for a specified duration and processing returns efficiently. The integration of **workflow documentation** ensures a **clear transaction flow**, providing a structured approach for managing vehicle rentals.

This project lays a **strong foundation** for future enhancements, such as **database integration for persistent storage, a graphical user interface for improved user experience, and an online booking system for reservations**. With a **robust design and well-documented workflow**, the Vehicle Rental System is a reliable and extensible solution for vehicle rental management.

🚀 **The system provides a practical, efficient, and scalable approach to rental operations, ensuring a seamless experience for customers.** 
