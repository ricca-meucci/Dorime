package dorime;

import java.util.Scanner;

public class Dorime
{
    static Scanner keyboard = new Scanner(System.in);
    
    private static int nInt()
    {
        return Integer.parseInt(keyboard.nextLine());
    }
    
    private static String inputEmployee()
    {
        String json = "{";
        System.out.println("Input ID");
        json += "\"employeeId\" : " + nInt() +",";
        System.out.println("Input First Name");
        json += "\"firstName\" : \"" + keyboard.nextLine() +"\",";
        System.out.println("Input Last Name");
        json += "\"lastName\" : \"" + keyboard.nextLine() +"\",";
        System.out.println("Input Email");
        json += "\"email\" : \"" + keyboard.nextLine() +"\",";
        System.out.println("Input Phone");
        json += "\"phone\" : \"" + keyboard.nextLine() +"\"}";
        System.out.println(json);
        return json;
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome to the Disappointing but Only Rest clIent for MyEployees (a MySQL DB for employees)");
        do
        {
            System.out.println("1. Show all employees");
            System.out.println("2. Show one employee");
            System.out.println("3. Create an employee");
            System.out.println("4. Delete an eployee");
            System.out.println("5. Patch an employee");
            System.out.println("6. Update an employee");
            System.out.print("Select operation:\n>");
            switch (nInt())
            {
                case 1:
                {
                    System.out.println(Latire.getAllEmployees());
                }break;
                case 2:
                {
                    System.out.println("Input the ID:");
                    System.out.println(Latire.getEmployee(nInt()));
                }break;
                case 3:
                {
                    if(Latire.doRequest(inputEmployee(), "http://localhost:8080/api/tutorial/1.0/employees", "POST"))
                        System.out.println("OK");
                    else
                        System.out.println("KO");
                }break;
                case 4:
                {
                    if(Latire.doRequest("", "http://localhost:8080/api/tutorial/1.0/employees/" + nInt(), "DELETE"))
                        System.out.println("OK");
                    else
                        System.out.println("KO");
                    
                }break;
                case 5:
                {
                    /*if(Latire.doRequest(inputEmployee(), "http://localhost:8080/api/tutorial/1.0/employees/" + nInt(), "PATCH"))
                        System.out.println("OK");
                    else
                        System.out.println("KO");*/
                    System.out.println("REDACTED");
                    
                }break;
                case 6:
                {
                    if(Latire.doRequest(inputEmployee(), "http://localhost:8080/api/tutorial/1.0/employees/" + nInt(), "PUT"))
                        System.out.println("OK");
                    else
                        System.out.println("KO");
                    
                }break;
                default:
                    System.out.println("Not valid!");
            }
        }while(true);
    }
}