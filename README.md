# Vehicle Rental System - Workflow Documentation  

This document outlines the workflow for renting and returning vehicles in the Vehicle Rental System.

## 1 Vehicle Addition Process  
Purpose: Register vehicles into the system for rental availability.  

Workflow:  
1. Administrator adds new vehicles using addVehicle().  
2. Each vehicle is assigned a unique ID, brand, model, and base rental price.  
3. The vehicle is marked as available by default.  
4. The vehicle list is updated in vehicles (ArrayList).  

## 2 Customer Registration and Rental Process  
Purpose: Allow customers to rent available vehicles.  

Workflow:  
1. Customer provides their name to register.  
2. The system generates a unique Customer ID.  
3. Available vehicles are displayed.  
4. Customer selects a vehicle using its Vehicle ID.  
5. System checks availability and processes rental via rentVehicle().  
6. The vehicle status updates to unavailable.  
7. A rental record is stored in the system.  
8. A rental receipt is generated.  

## 3 Returning a Vehicle Process  
Purpose: Enable customers to return rented vehicles.  

Workflow:  
1. Customer provides the Vehicle ID of the rented vehicle.  
2. The system verifies if the vehicle is currently rented.  
3. Vehicle status updates to available via returnVehicle().  
4. The rental record is removed from the system.  
5. A return receipt is generated.  

## 4 Menu Navigation Workflow  
Purpose: Allow users to interact with the system.  

Workflow:  
1. System displays main menu:  
   - 1 Rent a Vehicle  
   - 2 Return a Vehicle  
   - 3 Exit  
2. User selects an option.  
3. The system guides the user through the chosen process.  
4. If the user selects Exit, the program closes.  

## 5 Error Handling Process  
Purpose: Handle invalid inputs and system errors gracefully.  

Workflow:  
- If the user enters an invalid Vehicle ID, the system displays an error.  
- If the vehicle is not available, the system prevents rental.  
- If the user tries to return a non-rented vehicle, an error message appears.  

## Conclusion  
This workflow ensures a smooth vehicle rental process, maintaining availability status, accurate billing, and customer satisfaction.

Let me know if you need any adjustments.  