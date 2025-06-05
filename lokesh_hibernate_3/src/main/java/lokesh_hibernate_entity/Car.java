package lokesh_hibernate_entity;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="car_info")

public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="carname")
	private String name;
	@Column(name="FuelType")
	private String fuel;
	private double price;
	private String color;
	
	public Car() {
		super();
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", fuel=" + fuel + ", price=" + price + ", color=" + color + "]";
	}
	
	public Car(String name, String fuel, double price, String color) {
		super();
		this.name = name;
		this.fuel = fuel;
		this.price = price;
		this.color = color;
	}
	

	public Car(int id, String name, String fuel, double price, String color) {
		super();
		this.id = id;
		this.name = name;
		this.fuel = fuel;
		this.price = price;
		this.color = color;
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

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public static void printCar(List<Car> list) {
		list.stream().forEach(s-> System.out.println(s));
	}
}

