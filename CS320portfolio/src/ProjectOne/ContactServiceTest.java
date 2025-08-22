package ProjectOne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

// This class contains unit tests for the ContactService class.
class ContactServiceTest {
    private ContactService service;

    // This runs before each test to create a fresh ContactService instance.
    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    // Test adding a contact successfully.
    @Test
    void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        // Verify the contact was added by checking if a contact with the same ID exists
        assertNotNull(findContactById("1"));
    }

    // Test adding a contact with a duplicate ID.
    @Test
    void testAddDuplicateContact() {
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1", "Jane", "Smith", "9876543210", "456 Side St");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    // Test deleting a contact.
    @Test
    void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertNotNull(findContactById("1")); // Verify it's there before deleting
        service.deleteContact("1");
        assertNull(findContactById("1")); // Verify it's gone after deleting
    }

    // Test updating a contact's first name.
    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("1", "Jane", null, null, null);
        assertEquals("Jane", findContactById("1").getFirstName());
    }

    // Test updating a contact's phone number.
    @Test
    void testUpdatePhone() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("1", null, null, "0987654321", null);
        assertEquals("0987654321", findContactById("1").getPhone());
    }

    // Helper method to find a contact in the service, used for testing.
    private Contact findContactById(String id) {
        return service.getContact(id);
    }
}