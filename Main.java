import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        loadEmployeesFromFile();

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("     EMPLOYEE PAYROLL MANAGEMENT");
            System.out.println("======================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Generate Salary Slip");
            System.out.println("4. Search Employee by ID");
           System.out.println("5. Update Employee");
System.out.println("6. Delete Employee");
System.out.println("7. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            choice = getValidInteger("Enter your choice: ");
            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewAllEmployees();
                    break;

                case 3:
                    generateSalarySlip();
                    break;

                case 4:
                    searchEmployee();
                    break;

                case 5:
                    updateEmployee();
                    break;

              case 6:
    deleteEmployee();
    break;

case 7:
    System.out.println(
        "\nThank you for using Employee Payroll Management System!"
    );
    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        }  while (choice != 7);
        scanner.close();
    }

    // Add Employee
    public static void addEmployee() {

        System.out.println("\n--- Add Employee ---");

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (findEmployeeById(id) != null) {
            System.out.println("\nEmployee ID already exists!");
            return;
        }

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        Employee employee = new Employee(id, name, department, salary);

        employees.add(employee);

        saveEmployeeToFile(employee);

        System.out.println("\nEmployee added successfully!");
    }

    // View All Employees
    public static void viewAllEmployees() {

        System.out.println("\n--- All Employees ---");

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println("--------------------------------------");
            employee.displayEmployee();
        }
    }

    // Generate Salary Slip
    public static void generateSalarySlip() {

        System.out.print("\nEnter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee employee = findEmployeeById(id);

        if (employee != null) {
            Payroll payroll = new Payroll(employee);
            payroll.displaySalarySlip();
        } else {
            System.out.println("\nEmployee not found.");
        }
    }

    // Search Employee
    public static void searchEmployee() {

        System.out.print("\nEnter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Employee employee = findEmployeeById(id);

        if (employee != null) {
            System.out.println("\nEmployee Found:");
            System.out.println("--------------------------------------");
            employee.displayEmployee();
        } else {
            System.out.println("\nEmployee not found.");
        }
    }

    // Find Employee by ID
    public static Employee findEmployeeById(int id) {

        for (Employee employee : employees) {

            if (employee.getId() == id) {
                return employee;
            }
        }

        return null;
    }

    // Save Employee to File
    public static void saveEmployeeToFile(Employee employee) {

        try {
            FileWriter writer = new FileWriter("data/employees.csv", true);

            writer.write(
                employee.getId() + "," +
                employee.getName() + "," +
                employee.getDepartment() + "," +
                employee.getSalary() + "\n"
            );

            writer.close();

            System.out.println("Employee record saved to file.");

        } catch (IOException e) {
            System.out.println(
                "Error saving employee: " + e.getMessage()
            );
        }
    }

    // Load Employees from File
    public static void loadEmployeesFromFile() {

        try {
            BufferedReader reader = new BufferedReader(
                new FileReader("data/employees.csv")
            );

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String department = data[2];
                double salary = Double.parseDouble(data[3]);

                Employee employee = new Employee(
                    id, name, department, salary
                );

                employees.add(employee);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println(
                "Error loading employees: " + e.getMessage()
            );

        } catch (NumberFormatException e) {
            System.out.println(
                "Invalid data found in employees.csv"
            );
        }
    }

    // Update Employee
public static void updateEmployee() {

    System.out.print("\nEnter Employee ID to update: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Employee employee = findEmployeeById(id);

    if (employee == null) {
        System.out.println("\nEmployee not found.");
        return;
    }

    System.out.print("Enter new name: ");
    String name = scanner.nextLine();

    System.out.print("Enter new department: ");
    String department = scanner.nextLine();
double salary = getValidSalary();
    employee.setName(name);
    employee.setDepartment(department);
    employee.setSalary(salary);

    saveAllEmployeesToFile();

    System.out.println("\nEmployee updated successfully!");
}
// Delete Employee
public static void deleteEmployee() {

    System.out.print("\nEnter Employee ID to delete: ");
    int id = getValidInteger("Enter Employee ID: ");
    Employee employee = findEmployeeById(id);

    if (employee == null) {
        System.out.println("\nEmployee not found.");
        return;
    }

    System.out.println("\nEmployee Found:");
    employee.displayEmployee();

    System.out.print("\nAre you sure you want to delete this employee? (yes/no): ");
    String confirmation = scanner.nextLine();

    if (confirmation.equalsIgnoreCase("yes")) {

        employees.remove(employee);

        saveAllEmployeesToFile();

        System.out.println("\nEmployee deleted successfully!");

    } else {

        System.out.println("\nDelete operation cancelled.");
    }
}
    // Save all employees to file
public static void saveAllEmployeesToFile() {

    try {
        FileWriter writer = new FileWriter("data/employees.csv");

        for (Employee employee : employees) {

            writer.write(
                employee.getId() + "," +
                employee.getName() + "," +
                employee.getDepartment() + "," +
                employee.getSalary() + "\n"
            );
        }

        writer.close();

        System.out.println("Employee records saved successfully.");

    } catch (IOException e) {

        System.out.println(
            "Error saving employee records: " + e.getMessage()
        );
    }
}
// Get valid integer input
public static int getValidInteger(String message) {

    while (true) {

        System.out.print(message);

        if (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            scanner.nextLine();
            return value;
        }

        System.out.println("Invalid input! Please enter a number.");
        scanner.nextLine();
    }
}
// Get valid salary
public static double getValidSalary() {

    while (true) {

        System.out.print("Enter Salary: ");

        if (scanner.hasNextDouble()) {

            double salary = scanner.nextDouble();
            scanner.nextLine();

            if (salary >= 0) {
                return salary;
            }

            System.out.println("Salary cannot be negative.");

        } else {

            System.out.println("Invalid salary! Please enter a number.");
            scanner.nextLine();
        }
    }
}
}