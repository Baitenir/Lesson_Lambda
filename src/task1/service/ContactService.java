package task1.service;
import task1.models.Contact;
import java.util.List;

public interface ContactService {
    String addContactToPhone(Long phoneId, Contact contact);
    Contact getContactByName(Long id, String contactName);
    Contact getContactByPhoneNumber(Long id, String phoneNumber);
    List<Contact> sortContactsByName(Long id);
    void deleteContactByNameFromPhone(Long id, String contactName);
}
