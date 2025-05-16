package employeepayrolesystem;

public class ContractEmployee extends  Employee{
    private int contractDuration;


    public ContractEmployee(int id, String name, double baseSalary,int contractDuration) {
        super(id, name, baseSalary);
        this.contractDuration=contractDuration;

    }

    @Override
    public double calculateSal() {
        return (getBaseSalary()/12)*contractDuration;
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "contractDuration=" + contractDuration +
                '}';
    }
}
