package lokesh_hibernate_6.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String Name;
	
	@OneToMany
	private List<Employee_2> emp_list=new ArrayList<Employee_2>();
	
	

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Employee_2> getEmp_list() {
		return emp_list;
	}

	public void setEmp_list(List<Employee_2> emp_list) {
		this.emp_list = emp_list;
	}

	
	public Project() {
		super();
	}
	public Project(String name) {
		super();
		Name = name;
		
	}
	
	public Project(int iD, String name) {
		super();
		ID = iD;
		Name = name;
		
	}
	
	
	
	
	
}
