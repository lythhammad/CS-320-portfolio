package ProjectOne;

import java.util.ArrayList;
import java.util.List;

// The ContactService class manages a list of Contact objects.
public class ContactService {
    // This is the in-memory data structure to store contacts.
    private final List<Contact> contactList = new ArrayList<>();

    // This method adds a new contact to the list.
    public void addContact(Contact contact) {
        // Check if a contact with the same ID already exists.
        for (Contact existingContact : contactList) {
            if (existingContact.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact with this ID already exists.");
            } 
        }
        contactList.add(contact);
    }

    // This method deletes a contact by its ID.
    public void deleteContact(String contactId) {
        // Iterate through the list to find and remove the contact.
        contactList.removeIf(contact -> contact.getContactId().equals(contactId));
    }

    // This method updates contact fields based on the ID.
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        // Find the contact to update.
        for (Contact contact : contactList) {
            if (contact.getContactId().equals(contactId)) {
                // Update fields using the Contact class's setters, which handle validation.
                if (firstName != null) {
                    contact.setFirstName(firstName);
                }
                if (lastName != null) {
                    contact.setLastName(lastName);
                }
                if (phone != null) {
                    contact.setPhone(phone);
                }
                if (address != null) {
                    contact.setAddress(address);
                }
                return; // Exit after updating
            }
        }
        // If the loop finishes, the contact was not found.
        throw new IllegalArgumentException("Contact not found.");
    }

    // NEW METHOD: Add this public method to retrieve a contact by ID
    public Contact getContact(String contactId) {
        for (Contact contact : contactList) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null; // Return null if no contact with the ID is found
    }
}