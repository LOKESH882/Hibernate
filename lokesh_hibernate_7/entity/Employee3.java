package lokesh_hibernate.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee3 {
	@Id
	@Column
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToMany
	@JoinTable(name="emp_lang", joinColumns = {
			@JoinColumn(referencedColumnName = "id" , name="emp_id")
	},inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "id",name="lang_id")
	})
	private List<Languages> language_list;
	
	
	public Employee3( String name) {
		super();
		
		this.name = name;
	}
	
	public Employee3(int id, String name) {
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
	
	
	public List<Languages> getLanguage_list() {
		return language_list;
	}

	public void setLanguage_list(List<Languages> language_list) {
		this.language_list = language_list;
	}

	@Override
	public String toString() {
		return "Employee3 [id=" + id + ", name=" + name + "]";
	}
	
	
}
