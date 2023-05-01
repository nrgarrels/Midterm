package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cars")
public class ListCar {
	@Id
	@GeneratedValue
	private int id;
	private String make;
	private String model;
	private LocalDate year;
	private String color;
	
	//Default No Arg Constructor
	public ListCar() {
		super();
		this.id = 0;
		this.make = "";
		this.model = "";
		this.year = null;
		this.color = "";
	}
	
	//Cars Constructor
	public ListCar(int id, String make, String model, LocalDate year, String color) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
	}
	
	public ListCar(String make, String model, LocalDate year, String color) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LocalDate getYear() {
		return year;
	}
	public void setYear(LocalDate year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}


	@Override
	public String toString() {
		return "List Cars [ID=" + id + ", make=" + make + ", model=" + model + ", year=" + year
				+ ", color=" + color + "]";
	}

	public String returnCarDetails() {
		return this.id + ": " + this.make + ": " + this.model + ": " + this.year + ": " + this.color;
	}
}
