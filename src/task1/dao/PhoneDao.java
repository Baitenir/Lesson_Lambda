package task1.dao;
import task1.models.Phone;
import java.util.List;

public interface PhoneDao {
    String addPhone(Phone phone);
    Phone getPhoneByID(Long id);
    Phone updatePhoneNameById(Long id, String newName);
    List<Phone> getAllPhones();
    List<Phone> getAllPhonesByBrand(String brand);
    void deletePhoneById(Long phoneId);
}
