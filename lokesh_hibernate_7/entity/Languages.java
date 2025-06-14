package lokesh_hibernate.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Languages {
	@Id
	@Column
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToMany(mappedBy = "language_list")
	private List<Employee3> emp_list;
	public Languages() {
		super();
	}
	
	public Languages( String name) {
		super();
		
		this.name = name;
	}
	
	public Languages(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
	public List<Employee3> getEmp_list() {
		return emp_list;
	}

	public void setEmp_list(List<Employee3> emp_list) {
		this.emp_list = emp_list;
	}

	@Override
	public String toString() {
		return "Languages [id=" + id + ", name=" + name + "]";
	}
}
