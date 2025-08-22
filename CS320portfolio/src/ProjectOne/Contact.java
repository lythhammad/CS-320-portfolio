package ProjectOne;

//This is the Contact class, representing a single contact with required fields and validation.
public class Contact {
private final String contactId;
private String firstName;
private String lastName;
private String phone;
private String address;

// The constructor validates and initializes a new Contact object.
public Contact(String contactId, String firstName, String lastName, String phone, String address) {
   // Validation checks to ensure inputs meet requirements
   if (contactId == null || contactId.length() > 10) {
       throw new IllegalArgumentException("Invalid contact ID.");
   }
   
   if (firstName == null || firstName.length() > 10) {
       throw new IllegalArgumentException("Invalid first name.");
   }
   
   if (lastName == null || lastName.length() > 10) {
       throw new IllegalArgumentException("Invalid last name.");
   }
   
   if (phone == null || phone.length() != 10) {
       throw new IllegalArgumentException("Invalid phone number.");
   }
   
   if (address == null || address.length() > 30) {
       throw new IllegalArgumentException("Invalid address.");
   }

   // Assign valid parameters to the class fields
   this.contactId = contactId;
   this.firstName = firstName;
   this.lastName = lastName;
   this.phone = phone;
   this.address = address;
}

// Getter methods to access the private fields
public String getContactId() {
   return contactId;
}

public String getFirstName() {
   return firstName;
}

public String getLastName() {
   return lastName;
}

public String getPhone() {
   return phone;
}

public String getAddress() {
   return address;
}

// Setter methods to update specific fields with validation
public void setFirstName(String firstName) {
   if (firstName == null || firstName.length() > 10) {
       throw new IllegalArgumentException("Invalid first name.");
   }
   this.firstName = firstName;
}

public void setLastName(String lastName) {
   if (lastName == null || lastName.length() > 10) {
       throw new IllegalArgumentException("Invalid last name.");
   }
   this.lastName = lastName;
}

public void setPhone(String phone) {
   if (phone == null || phone.length() != 10) {
       throw new IllegalArgumentException("Invalid phone number.");
   }
   this.phone = phone;
}

public void setAddress(String address) {
   if (address == null || address.length() > 30) {
       throw new IllegalArgumentException("Invalid address.");
   }
   this.address = address;
}
}