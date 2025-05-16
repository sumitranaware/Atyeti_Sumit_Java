package employeepayrolesystem;

public class FullTimeEmployee  extends Employee{
    private int bonus;

    public FullTimeEmployee(int id , String name,double baseSalary,int bonus){
        super(id ,name,baseSalary);
        this.bonus=bonus;
    }

    @Override
    public double calculateSal() {
        return getBaseSalary()+bonus;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "bonus=" + bonus +
                '}';
    }
}
