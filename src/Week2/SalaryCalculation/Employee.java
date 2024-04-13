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

    public double tax(){
        if (salary < 1000){
            return 0;
        }else {
            return salary * 0.03;
        }
    }

    public double bonus(){
        if (workHours > 40){
            return (workHours - 40) * 0.30;
        }else {
            return 0;
        }
    }

    public double raiseSalary(){
        int currentYear = 2021;
        int workingYear = currentYear - hireYear;
        if (workingYear < 10){
            return salary *0.05;
        } else if (workingYear < 20) {
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }

    public String toString() {
        double tax = tax();
        double bonus = bonus();
        double salaryIncrease = raiseSalary();
        double totalSalary = salary + salaryIncrease  - tax + bonus;

        return  "Name : " + name + "\n" +
                "Salary : " + salary + "\n" +
                "Work Hours : " + workHours + "\n" +
                "Start Year  : " + hireYear + "\n" +
                "Tax : " + tax + "\n" +
                "Bonus : " + bonus + "\n" +
                "Salary Increase : " + salaryIncrease  + "\n" +
                "Salary with Tax and Bonuses : " + (bonus - tax + salary) + "\n" +
                "Total Salary : " + totalSalary;
    }

}
