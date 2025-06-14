package lokesh_hibernate_6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee_2 {
	
		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		
		public Employee_2() {
			
		}
		
		public Employee_2(String name) {
			super();
			this.name = name;
			
		}
		
		public Employee_2(int id, String name) {
			super();
			this.id = id;
			this.name = name;
			
		}
		@Override
		public String toString() {
			return "Employee_2 [id=" + id + ", name=" + name + "]";
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
		
		
	
}
