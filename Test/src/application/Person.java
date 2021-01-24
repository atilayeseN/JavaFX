package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Person {
	private int id;
	private String name;
	private String street;
	private String city;
	private String gender;
	private int zip;
	public Person(int id, String name, String street, String city, String gender, int zip) {
		super();
		this.id = id;
		if(name.length()>32) {
			Alert alertName=new Alert(AlertType.ERROR);
			alertName.setTitle("Error");
			alertName.setHeaderText("You have to enter a name shoter than 32");
			alertName.show();
		}
		else {
			this.name = name;
		}
		if(street.length()>32) {
			Alert alertStreet=new Alert(AlertType.ERROR);
			alertStreet.setTitle("Error");
			alertStreet.setHeaderText("You have to enter a street name shoter than 32");
			alertStreet.show();
		}
		else {
			this.street = street;
		}
		if(city.length()>20) {
			Alert alertCity=new Alert(AlertType.ERROR);
			alertCity.setTitle("Error");
			alertCity.setHeaderText("You have to enter a city name shoter than 20");
			alertCity.show();
		}
		else {
			this.city = city;
		}
		
		
		
		if(gender.equals("F") !=false || gender.equals("M") !=false || gender.length()>1 ) {
			
			this.gender = gender;
		}
		else {
			
			Alert alertGender=new Alert(AlertType.ERROR);
			alertGender.setTitle("Error");
			alertGender.setHeaderText("You have to enter correct gender");
			alertGender.show();
			
		}
		
		if(zip >9999 || zip<1000) {
			Alert alertZip=new Alert(AlertType.ERROR);
			alertZip.setTitle("Error");
			alertZip.setHeaderText("You have to enter correct zip number");
			alertZip.show();
		}
		else {
			this.zip=zip;
		}
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
		if(name.length()>32) {
			Alert alertName=new Alert(AlertType.ERROR);
			alertName.setTitle("Error");
			alertName.setHeaderText("You have to enter a name shoter than 32");
			alertName.show();
		}
		else {
			this.name = name;
		}
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		if(street.length()>32) {
			Alert alertStreet=new Alert(AlertType.ERROR);
			alertStreet.setTitle("Error");
			alertStreet.setHeaderText("You have to enter a street name shoter than 32");
			alertStreet.show();
		}
		else {
			this.street = street;
		}
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		if(city.length()>20) {
			Alert alertCity=new Alert(AlertType.ERROR);
			alertCity.setTitle("Error");
			alertCity.setHeaderText("You have to enter a city name shoter than 20");
			alertCity.show();
		}
		else {
			this.city = city;
		}
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {

		if(gender.equals("F") !=false || gender.equals("M") !=false || gender.length()>1 ) {
			
			this.gender = gender;
		}
		else {
			
			Alert alertGender=new Alert(AlertType.ERROR);
			alertGender.setTitle("Error");
			alertGender.setHeaderText("You have to enter correct gender");
			alertGender.show();
			
		}
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		if(zip >9999 || zip<1000) {
			Alert alertZip=new Alert(AlertType.ERROR);
			alertZip.setTitle("Error");
			alertZip.setHeaderText("You have to enter correct zip number");
			alertZip.show();
		}
		else {
			this.zip=zip;
		}
	}

}
