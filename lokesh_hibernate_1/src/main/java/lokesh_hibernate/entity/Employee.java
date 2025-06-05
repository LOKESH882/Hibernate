package lokesh_hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
public class Employee {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int ID;
	    private String Name;
	    private String Department;
	    private float salary;
	    private String City;

	    public Employee() {
	    }

	    public Employee(String name, String department, float salary, String city) {
	        Name = name;
	        Department = department;
	        this.salary = salary;
	        City = city;
	    }

    // Getters and Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        this.Department = department;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + ID + ", Name=" + Name + ", Department=" + Department + ", salary=" + salary + ", City=" + City + "]";
    }
}
