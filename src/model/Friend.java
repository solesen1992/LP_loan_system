package model;

/**
 * This class stores the friend's information: name, address, city and phone.
 * There are get and set methods for all parameters.
 */

public class Friend {
	private String name;
	private String address;
	private String city;
	private String phone;
	
	/**
	 * Constructor to create friend objects
	 * */
	public Friend(String name, String address, String city, String phone) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.phone = phone;
	}
	
	/**
	 * Getters and setters
	 * */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
