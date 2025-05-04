package task1.dao;
import task1.models.Contact;
import java.util.List;

public interface ContactDao {
    String addContactToPhone(Long phoneId, Contact contact);
    Contact getContactByName(Long id, String contactName);
    Contact getContactByPhoneNumber(Long id, String phoneNumber);
    List<Contact> sortContactsByName(Long id);
    void deleteContactByNameFromPhone(Long id, String contactName);
}
//    10. ContactService methods :
//
//            - String addContactToPhone(int phoneId, Contact contact);
//
//    // with stream (телефонду phoneId мн табып, ичинен контантактардын  арасынан contactName мн табып кайтарып берсин)
//
//       - Contact findContactByName(int phoneId, String contactName);
//
//    // with stream
//
//    -  Contact findContactByPhoneNumber(int phoneId, String phoneNumber);
//
//    // with stream (телефонду phoneId мн табып, ичинен контантактарды аттарын осуу тартибинде чыгарып берсин)
//
//    -List<Contact>sortContactsByName(int phoneId);
//
//      -  void deleteContactByNameFromPhone(int phoneId, String contactName);