import java.util.ArrayList;
import java.util.Scanner;

abstract class Employee {
    String name;
    int empId;
    double baseSalary;

    Employee(String name, int empId, double baseSalary) {
        this.name = name;
        this.empId = empId;
        this.baseSalary = baseSalary;
    }

    abstract double calculateSalary(); // calculate specific salary

    void generatePayslip() {
        System.out.println("Payslip for " + name + " (ID: " + empId + ")");
        System.out.println("Base Salary: ₹" + baseSalary);
        System.out.println("Total Salary: ₹" + calculateSalary());
        System.out.println("-------------------------");
    }
}

class FullTimeEmployee extends Employee {
    static final double BONUS = 0.1; // 10% bonus

    FullTimeEmployee(String name, int empId, double baseSalary) {
        super(name, empId, baseSalary);
    }

    double calculateSalary() {
        return baseSalary + (baseSalary * BONUS);
    }
}

class PartTimeEmployee extends Employee {
    int hoursWorked;
    static final double HOURLY_RATE = 100; // hourly rate

    PartTimeEmployee(String name, int empId, double baseSalary, int hoursWorked) {
        super(name, empId, baseSalary);
        this.hoursWorked = hoursWorked;
    }

    double calculateSalary() {
        return hoursWorked * HOURLY_RATE;
    }
}

class ContractEmployee extends Employee {
    static final double FIXED_BONUS = 5000; // fixed bonus for contract

    ContractEmployee(String name, int empId, double baseSalary) {
        super(name, empId, baseSalary);
    }

    double calculateSalary() {
        return baseSalary + FIXED_BONUS;
    }
}

public class PayrollSystem {
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Add Contract Employee");
            System.out.println("4. Generate Payslips");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter name, empId, baseSalary: ");
                    employees.add(new FullTimeEmployee(sc.next(), sc.nextInt(), sc.nextDouble()));
                    break;
                case 2:
                    System.out.print("Enter name, empId, baseSalary, hoursWorked: ");
                    employees.add(new PartTimeEmployee(sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt()));
                    break;
                case 3:
                    System.out.print("Enter name, empId, baseSalary: ");
                    employees.add(new ContractEmployee(sc.next(), sc.nextInt(), sc.nextDouble()));
                    break;
                case 4:
                    for (Employee emp : employees) emp.generatePayslip();
                    break;
                case 0:
                    System.out.println("Exiting Payroll System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
        
        sc.close();
    }
}
