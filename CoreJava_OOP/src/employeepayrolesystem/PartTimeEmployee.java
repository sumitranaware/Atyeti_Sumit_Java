package employeepayrolesystem;

public class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;


    public PartTimeEmployee(int id, String name, double baseSalary,int hoursWorked,double hourlyRate) {
        super(id, name, baseSalary);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override
    public double calculateSal() {
        return (hourlyRate*hourlyRate);
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "hoursWorked=" + hoursWorked +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}
