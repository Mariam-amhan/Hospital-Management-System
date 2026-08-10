package models;

public class Doctor extends Person {
    protected String specialization;
    protected double salary;
    protected int yearsOfExperience;

    public Doctor(int id, String name, int age, String gender, String specialization, double salary,
            int yearsOfExperience) {
        super(id, name, age, gender);
        this.specialization = specialization;
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
        System.out.println("Salary: " + salary);
        System.out.println("Years of Experience: " + yearsOfExperience);

    }

}
