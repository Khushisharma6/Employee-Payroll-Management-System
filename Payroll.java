import java.io.FileWriter;
import java.io.IOException;

public class Payroll {

    private Employee employee;
    private double tax;
    private double pf;
    private double netSalary;

    public Payroll(Employee employee) {
        this.employee = employee;
        calculatePayroll();
    }

    private void calculatePayroll() {
        double salary = employee.getSalary();

        // Tax calculation
        tax = salary * 0.10;

        // PF calculation
        pf = salary * 0.12;

        // Net salary
        netSalary = salary - tax - pf;
    }

    public void displaySalarySlip() {

        System.out.println("\n======================================");
        System.out.println("           SALARY SLIP");
        System.out.println("======================================");
        System.out.println("Employee ID   : " + employee.getId());
        System.out.println("Employee Name : " + employee.getName());
        System.out.println("Department    : " + employee.getDepartment());
        System.out.println("--------------------------------------");
        System.out.printf("Basic Salary  : ₹%.2f%n", employee.getSalary());
        System.out.printf("Tax (10%%)     : ₹%.2f%n", tax);
        System.out.printf("PF (12%%)      : ₹%.2f%n", pf);
        System.out.println("--------------------------------------");
        System.out.printf("Net Salary    : ₹%.2f%n", netSalary);
        System.out.println("======================================");

        saveSalarySlip();
    }

    // Save Salary Slip to File
    private void saveSalarySlip() {

        String fileName = "data/salary_slip_" + employee.getId() + ".txt";

        try {

            FileWriter writer = new FileWriter(fileName);

            writer.write("======================================\n");
            writer.write("           SALARY SLIP\n");
            writer.write("======================================\n");
            writer.write("Employee ID   : " + employee.getId() + "\n");
            writer.write("Employee Name : " + employee.getName() + "\n");
            writer.write("Department    : " + employee.getDepartment() + "\n");
            writer.write("--------------------------------------\n");

            writer.write(
                String.format(
                    "Basic Salary  : ₹%.2f%n",
                    employee.getSalary()
                )
            );

            writer.write(
                String.format(
                    "Tax (10%%)     : ₹%.2f%n",
                    tax
                )
            );

            writer.write(
                String.format(
                    "PF (12%%)      : ₹%.2f%n",
                    pf
                )
            );

            writer.write("--------------------------------------\n");

            writer.write(
                String.format(
                    "Net Salary    : ₹%.2f%n",
                    netSalary
                )
            );

            writer.write("======================================\n");

            writer.close();

            System.out.println(
                "Salary slip saved to: " + fileName
            );

        } catch (IOException e) {

            System.out.println(
                "Error saving salary slip: " + e.getMessage()
            );
        }
    }

    public double getNetSalary() {
        return netSalary;
    }
}