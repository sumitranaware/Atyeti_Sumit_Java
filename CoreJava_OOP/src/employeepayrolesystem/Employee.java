package employeepayrolesystem;

public class Employee {
    private int id;
    private String name;
    private double baseSalary;

    private Employee(){
        id=101;
        name="Sumit";
        baseSalary=344656;
    }

    public Employee(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public double calculateSal(){
        return baseSalary;
    }
    public void displayInfo(){
        System.out.println(" id "+id+" Name : "+name+" base salary "+baseSalary);

    }
}
