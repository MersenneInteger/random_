import java.util.Scanner;

public class FA2016LAB4_Johnson_RestrictedStructureWithEmployee{

    public static void main(String[] args){
        
        //create Scanner object
        Scanner kb = new Scanner(System.in);
        int choice, id;
        //boolean value to decide whether or not to continue loop
        boolean cont = true;
        String lastName, firstName, department;
        double salary;
        //declare employee object
        Employee_Johnson employee;
        
        //menu loop, while choice != 3
        do{ 
            
            
            System.out.println("\nChoose one of the following: " +
                           "\n1. Stack\n2. Queue\n3.Exit");
            choice = kb.nextInt();
            
            //check whether choice is within range
            if(choice > 3 || choice < 1){
                System.out.println("Enter a number between 1 and 3.");
                continue;
            }

            if(choice == 1){ //if stack is chosen

                Employee_Stack empStack = new Employee_Stack();

                System.out.println("Enter 5 employees information: ");;
                for(int i = 0; i <5; i++){
                    
                    System.out.println("Enter id: ");
                    id = kb.nextInt();
                    kb.nextLine();
                    
                    System.out.println("Enter last name: ");
                    lastName = kb.nextLine();
                    System.out.println("Enter first name: ");
                    firstName = kb.nextLine();

                    System.out.println("Enter department: ");
                    department = kb.nextLine();

                    System.out.println("Enter salary: ");
                    salary = kb.nextDouble();

                    employee = new Employee_Johnson(id, lastName, firstName, 
                                                    department, salary);
                    empStack.push(employee);
                }//end of for loop
                
                //show all employees
                empStack.showAll();
                
                //display top of stack
                System.out.println("\nTop of Stack: " + empStack.peek());

                //dispaly top after popping two Employees
                empStack.pop();
                empStack.pop();

                System.out.println("\nTop of Stack after popping two employees: " +
                                    empStack.peek());

            }
            else if (choice == 2){ //if Queue is chosen
                
                Employee_Queue empQueue = new Employee_Queue();

                System.out.println("Enter 5 employees information: ");;
                for(int i = 0; i <5; i++){
                         
                    System.out.println("Enter id: ");
                    id = kb.nextInt();
                    kb.nextLine();
                    
                    System.out.println("Enter last name: ");
                    lastName = kb.nextLine();
                    System.out.println("Enter first name: ");
                    firstName = kb.nextLine();

                    System.out.println("Enter department: ");
                    department = kb.nextLine();

                    System.out.println("Enter salary: ");
                    salary = kb.nextDouble();

                    employee = new Employee_Johnson(id, lastName, firstName, 
                                                    department, salary);
                    empQueue.enqueue(employee);    
                }//end of for loop
                
                //show all employees
                empQueue.showAll();

                //display front of queue
                System.out.println("\nFront of Queue: " + empQueue.peek());

                //display front of queue after dequeuing two Employees
                empQueue.dequeue();
                empQueue.dequeue();

                System.out.println("\nFront of Queue after dequeuing two Employees: " +
                                    empQueue.peek());
            }

            else {
                System.out.println("Terminating application...");
                cont = false;
                break;
            }
        }while(cont);

    }// end of main    
}//end of class
