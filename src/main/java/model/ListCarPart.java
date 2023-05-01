package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="id", referencedColumnName="id")
public class ListCarPart {

	//Private Variables
	@Id
	@GeneratedValue
	private int id;
	private String partName;
	private String partNumber;
	
	
	//Default No arg constructor
	public ListCarPart() {
		super();
		this.id = 0;
		this.partName = "";
		this.partNumber = "";
	}
	
	//CarParts Constructor
	public ListCarPart(int id, String partName, String partNumber) {
		super();
		this.id = id;
		this.partName = partName;
		this.partNumber = partNumber;
	}
	
	public ListCarPart(String partName, String partNumber) {
		super();
		this.id = id;
		this.partName = partName;
		this.partNumber = partNumber;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	//To String
	@Override
	public String toString() {
		return "CarParts [ID=" + id + ", partName=" + partName + ", partNumber=" + partNumber
				+ "]";
	}
	
	public String returnCarDetails() {
		return this.id + ": " + this.partName + ": " + this.partNumber;
	}
	
}