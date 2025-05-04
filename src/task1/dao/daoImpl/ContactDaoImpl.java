package task1.dao.daoImpl;
import task1.dao.ContactDao;
import task1.db.Database;
import task1.models.Contact;
import java.util.Comparator;
import java.util.List;

public class ContactDaoImpl implements ContactDao {
    @Override
    public String addContactToPhone(Long phoneId, Contact contact) {
        return Database.phones.stream()
                .filter(p -> p.getId().equals(phoneId))
                .findFirst()
                .map(phone -> {
                    phone.getContacts().add(contact);
                    return "New contact successfully added!";
                })
                .orElseThrow(() -> new RuntimeException("Phone by id '"+phoneId+"' not found!"));
    }

    @Override
    public Contact getContactByName(Long id, String contactName) {
        return Database.phones.stream()
                .filter(phone -> phone.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Phone with id '"+id+"' not found!"))
                .getContacts().stream()
                .filter(name -> name.getName().equalsIgnoreCase(contactName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Contact name '"+contactName + "' not saved in phone by id: "+ id));
    }

    @Override
    public Contact getContactByPhoneNumber(Long id, String phoneNumber) {
        return Database.phones.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Phone with id '"+id+"' not found!" ))
                .getContacts().stream()
                .filter(c -> c.getPhoneNumber().equals(phoneNumber))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Phone number '"+phoneNumber + "' not saved in phone by id: "+id ));
    }

    @Override
    public List<Contact> sortContactsByName(Long id) {
        return Database.phones.stream()
                .filter(phone -> phone.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Phone with id'"+id+"' not found!"))
                .getContacts().stream()
                .sorted(Comparator.comparing(Contact::getName, String.CASE_INSENSITIVE_ORDER))
                .toList();
    }

    @Override
    public void deleteContactByNameFromPhone(Long id, String contactName) {
        boolean isDeleted = Database.phones.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Phone with id'" + id +"' not found!"))
                .getContacts().removeIf(c -> c.getName().equals(contactName));
        if (isDeleted) System.out.println("Contact by name '" + contactName + "' successfully deleted");
        else System.out.println("error bro");
    }
}
