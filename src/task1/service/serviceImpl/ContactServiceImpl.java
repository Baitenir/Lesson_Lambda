package task1.service.serviceImpl;
import task1.dao.ContactDao;
import task1.dao.daoImpl.ContactDaoImpl;
import task1.models.Contact;
import task1.service.ContactService;
import java.util.List;

public class ContactServiceImpl implements ContactService {
    ContactDao contactDao = new ContactDaoImpl();

    @Override
    public String addContactToPhone(Long phoneId, Contact contact) {
        return contactDao.addContactToPhone(phoneId, contact);
    }

    @Override
    public Contact getContactByName(Long id, String contactName) {
        return contactDao.getContactByName(id, contactName);
    }

    @Override
    public Contact getContactByPhoneNumber(Long id, String phoneNumber) {
        return contactDao.getContactByPhoneNumber(id, phoneNumber);
    }

    @Override
    public List<Contact> sortContactsByName(Long id) {
        return contactDao.sortContactsByName(id);
    }

    @Override
    public void deleteContactByNameFromPhone(Long id, String contactName) {
        contactDao.deleteContactByNameFromPhone(id, contactName);
    }
}
