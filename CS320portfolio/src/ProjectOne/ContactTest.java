package ProjectOne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// This class contains unit tests for the Contact class.
class ContactTest {

    // Test a valid contact creation.
    @Test
    void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(contact);
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress()); 
    }
    
    @Test
    void testSettersEdgeCases() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        // Edge case: exactly 10-char first/last name, 30-char address
        contact.setFirstName("MaxTenChar");
        contact.setLastName("TenCharMax");
        contact.setPhone("1112223333");
        contact.setAddress("123456789012345678901234567890");

        assertEquals("MaxTenChar", contact.getFirstName());
        assertEquals("TenCharMax", contact.getLastName());
        assertEquals("1112223333", contact.getPhone());
        assertEquals("123456789012345678901234567890", contact.getAddress());
    }

    
    @Test
    void testSettersWithValidInput() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        contact.setFirstName("Alice");
        assertEquals("Alice", contact.getFirstName());

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());

        contact.setAddress("456 Elm St, Apt 2B");
        assertEquals("456 Elm St, Apt 2B", contact.getAddress());
    }
    
 // Test setters with invalid inputs.
    @Test
    void testSettersWithInvalidInputs() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");

        // Test invalid first name
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("TooLongFirstName");
        });

        // Test invalid last name
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("WayTooLongLastName");
        });

        // Test invalid phone
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("1234567890123");
        });

        // Test invalid address
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This is a ridiculously long address that should fail validation");
        });
    }

}

