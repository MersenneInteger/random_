import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FA2016LAB3_VehicleDealerShop_Johnson{
        
    public static void main(String[] args){
        
        //create Scanner object
        Scanner kb = new Scanner(System.in);
        String vin, model, make, color;
        int choice, counter = 0, year, vehicleChoice, numberOfPassengers, numberOfDoors;
        
        FA2016LAB3_VehicleUnsortedOptimizedArray_Johnson vehicleList;
        vehicleList = new FA2016LAB3_VehicleUnsortedOptimizedArray_Johnson();
        FA2016LAB3_Vehicle_Johnson test;
        
        //menu loop while choice != 6
        do{
             //menu display
             System.out.println("\n--------------------" +
                                "\nChoose an operation: " +
                                "\n1. Insert a car or a motorcycle" + 
                                "\n2. Test for encapsulation" +
                                "\n3. Remove a car or a motorcycle" +
                                "\n4. Update information of car or motorcycle" +
                                "\n5. Show All Vehicles" +
                                "\n6. Exit");
             choice = kb.nextInt(); //store user choice
             kb.nextLine(); //clear buffer

             if(choice < 1 || choice > 6){ //verify choice is in range
                System.out.println("Choose a number between 1 and 6.");
                continue;
            }
            if(counter == 0 && (choice != 1 && choice != 6)){ //verify vehicle is inserted before
                System.out.println("You must insert a vehicle before performing" + //other ops performed
                                    " that operation.");
                continue;
            }
            
            switch(choice){
                
                case 1: {
                            System.out.println("***TASK: Insert and Fetch a Car or " +
                                               "motorcycle***");
                            
                            //prompt user to choose to create car or motorcycle
                            System.out.println("Choose to insert:\n1)Car\n2)Motorcycle");
                            vehicleChoice = kb.nextInt();
                            kb.nextLine();

                            System.out.println("\n\nEnter the vin number: ");
                            vin = kb.nextLine();

                            System.out.println("Enter the color: ");
                            color = kb.nextLine();
                            
                            System.out.println("Enter the make: ");
                            make = kb.nextLine();

                            System.out.println("Enter the model: ");
                            model = kb.nextLine();

                            System.out.println("Enter the year: ");
                            year = kb.nextInt();

                            if(vehicleChoice == 1){ //create car obj using polymorphism
                                
                                System.out.println("Enter the number of passengers: ");
                                numberOfPassengers = kb.nextInt();
                                System.out.println("Enter the number of doors: ");
                                numberOfDoors = kb.nextInt();

                                FA2016LAB3_Vehicle_Johnson car = new FA2016LAB3_Car_Johnson(
                                                                vin, color, make, model, year,
                                                                numberOfPassengers, numberOfDoors);
                                test = vehicleList.fetch(vin); //copy car object
                                vehicleList.insert(car); //insert car into optimized array

                            }
                            else{ //create motorcycle
                                    kb.nextLine();//clear buffer
                                    System.out.println("Does the motorcycle have a side car?(y/n)");
                                    String ch = kb.nextLine(); 
                                    boolean sidecar = false;
                                    if(ch == "y")
                                        sidecar = true;

                                    FA2016LAB3_Vehicle_Johnson moto;
                                    moto = new FA2016LAB3_Motorcycle_Johnson(vin, color, make, model,
                                                                            year, sidecar);
                                    
                                    test = vehicleList.fetch(vin);//copy moto obj
                                    vehicleList.insert(moto);//insert moto into optimized array
                                    }

                            kb.nextLine(); 
                            System.out.println("Enter the vin number of the vehicle to be fetched: ");
                            vin = kb.nextLine();
                            
                            System.out.println(vehicleList.fetch(vin));//fetch object using vin as key
                                                                        //field
                            break;
                        }

                case 2: {
                            System.out.println("***TASK: Test for Encapsulation***");
                            
                            //prompt user for vehicle details
                            System.out.println("Enter color, model and make of car: ");
                            color = kb.nextLine();
                            model = kb.nextLine();
                            make = kb.nextLine();

                            System.out.println("Enter the year, number of passengers and doors: ");
                            year = kb.nextInt();
                            numberOfPassengers = kb.nextInt();
                            numberOfDoors = kb.nextInt();
                            kb.nextLine();

                            test = new FA2016LAB3_Car_Johnson("FA15222",color, make, model, year,
                                                                numberOfPassengers, numberOfDoors);
                            vehicleList.insert(test); //insert test into optimized array

                            System.out.println("Enter the new color: ");
                            color = kb.nextLine();
                            test.setColor(color);

                            FA2016LAB3_Vehicle_Johnson copy = vehicleList.fetch("FA15222");//copy test 
                            System.out.println(copy.toString());//print copy's details

                            String testStr, copyStr;
                            testStr = test.getColor();
                            copyStr = copy.getColor();
                            
                            //test for encapsulation
                            if(testStr.equals(copyStr)){
                                System.out.println("\nThe unsorted optimized array does not " +
                                                    "have encapsulation.");
                            }
                            else
                                System.out.println("\nThe unsorted optimized array has encapsulation.");

                            break;
                        }

                case 3: {
                            System.out.println("***TASK: Delete Car or Motorcycle***");
                            
                            System.out.println(vehicleList.delete("FA2016"));
                            System.out.println(vehicleList.delete("FA15222"));
                            System.out.println(vehicleList.fetch("FA15222"));

                            break;
                        }

                case 4: {
                            System.out.println("***TASK: Update Information on Car or Motorcycle***");
                            
                            test = new FA2016LAB3_Car_Johnson("FA15222", "Blue", "Honda", "Accord", 1999,
                                                                8, 4);

                            vehicleList.insert(test);//insert test obj into optimized array
                            FA2016LAB3_Vehicle_Johnson newNode;

                            newNode = vehicleList.fetch("FA15222");//copy test into newNode
                            newNode.setColor("purple");//change color of newNode
                            vehicleList.update("15222", newNode);//update newNode

                            System.out.println(vehicleList.fetch("FA15222"));

                            String testStr, newNodeStr;
                            testStr = test.getColor();
                            newNodeStr = newNode.getColor();
                            
                            //the colors should be different
                            if(testStr.equals(newNodeStr))
                                System.out.println("Update test car failed.");        
                            else
                                System.out.println("Update test car successfully");

                            break;
                        }

                case 5: {
                            vehicleList.showAll(); //print all nodes in optimized array
                            break;
                        }

                case 6: {
                            System.out.println("Application terminating..."); //exit menu loop
                            break;
                        }
            }//end of switch statement
            counter++; //verify operation 1 or 6 is performed before 2-5
        }while(choice != 6);

        //***PART 2***//
        
        
        ArrayList<Object> list = new ArrayList<Object>(20); //create ArrayList

        System.out.println("\n\nEnter the information for three motorcycles.");
        //prompt user to enter information for three vehicles
        for(int i = 0; i < 3; i++){
            System.out.println("Enter the vin number: ");
            vin = kb.nextLine();

            System.out.println("Enter the color: ");
            color = kb.nextLine();
                    
            System.out.println("Enter the make: ");
            make = kb.nextLine();

            System.out.println("Enter the model: ");
            model = kb.nextLine();

            System.out.println("Enter the year: ");
            year = kb.nextInt();
        
            kb.nextLine();
            System.out.println("Does it have a side door?(y/n)");
            String side = kb.nextLine();
            boolean sideCar = false;
            if(side == "y")
                sideCar = true;

            FA2016LAB3_Vehicle_Johnson moto;
            moto = new FA2016LAB3_Motorcycle_Johnson(vin, color, make, model, year, sideCar);

            list.add(moto);//add vehicle object
        }

        for(int i = 0; i < 3; i++)
            System.out.println(list.get(i)); //print ArrayList
        
        for(int i = 1; i < 101; i++)
            list.add(i); //add numbers 1-100

        System.out.println("Size of array list: " + list.size());

        list.remove(1);//remove vehicle object

        System.out.println("Size of array list: " + list.size());
        System.out.println("Node 52: " + list.get(52));
        list.set(52, 2016);
        System.out.println("Node 52 updated: " + list.get(52));
        JOptionPane.showMessageDialog(null, "Congratulations! You are successful on ArrayList" +
                                        " with four operations: add, get, remove, and set.");
                

    }//end of main        
        
}//end of class
