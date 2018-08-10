package entities;
public class Address {
		private int id;
		private String streetNumber;
		private String city;
		private String zipCode;
		
		public Address(){}
		public Address(String streetNumber, String city, String zipCode) { 
			this.streetNumber = streetNumber;
			this.city = city;
			this.zipCode = zipCode;
		}
		public int getId() {
			return id;
		 }
		 
		public void setId(int id) {
			this.id=id;
		 }
		 
		public String getStreetNumber() {
			return streetNumber;
		 }	
		 
		public void setStreetNumber(String streetNumber) {
			this.streetNumber = streetNumber;
		 }
		 
		public String getCity() { 
			return city;
		 }
		 
		public void setCity(String city) {
			this.city = city;
		 }
		 
		public String getZipCode() {
			return zipCode;
		 }
		 
		public void setZipCode(String zipCode) {
			this.zipCode = zipCode;
		 }
	}	
