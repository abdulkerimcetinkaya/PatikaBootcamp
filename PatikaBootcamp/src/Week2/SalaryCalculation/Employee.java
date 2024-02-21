package Week2.SalaryCalculation;

public class Employee {

    String name;
    int salary;
    int workHours;
    int hireYear;

    Employee(String name, int salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public static double tax(int salary){
        if (salary < 1000){
            return 0;
        }else {
            return salary * 0.03;
        }
    }
}
