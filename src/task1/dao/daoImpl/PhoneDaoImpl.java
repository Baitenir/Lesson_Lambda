package task1.dao.daoImpl;
import task1.dao.PhoneDao;
import task1.db.Database;
import task1.models.Phone;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao {

    @Override
    public String addPhone(Phone phone) {
        boolean anyMatchPhone = Database.phones.stream()
                        .anyMatch( phone1 ->
                            phone1.getName().equals(phone.getName())
                        );
        Database.phones.add(phone);
        return anyMatchPhone ? "Phone by name '"+phone.getName()+"' is already saved" : "New phone successfully added";

    }

    @Override
    public Phone getPhoneByID(Long id) {
        return Database.phones.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Phone with id '" +id+ "' not founded!"));
    }

    @Override
    public Phone updatePhoneNameById(Long id, String newName) {
        return Database.phones.stream()
                .filter(phone -> phone.getId().equals(id))
                .findFirst()
                .map(phone -> {
                    phone.setName(newName);
                    System.out.println("Phone name successfully updated");
                    return phone;
                })
                .orElseThrow(() -> new RuntimeException("Phone with id '"+id+"' not founded!"));
    }

    @Override
    public List<Phone> getAllPhones() {
        return Database.phones;
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        return Database.phones.stream()
                .filter(p -> p.getBrand().equalsIgnoreCase(brand))
                .toList();
    }

    @Override
    public void deletePhoneById(Long phoneId) {
        boolean a = Database.phones.removeIf(p -> p.getId().equals(phoneId));
        if (a) System.out.println("Phone successfully deleted");
        else System.out.println("Phone with id '"+phoneId+"' not found!");
    }
}
