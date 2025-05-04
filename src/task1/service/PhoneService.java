package task1.service;
import task1.models.Phone;
import java.util.List;

public interface PhoneService {
    String addPhone(Phone phone);
    Phone getPhoneByID(Long id);
    Phone updatePhoneNameById(Long id, String newName);
    List<Phone> getAllPhones();
    List<Phone> getAllPhonesByBrand(String brand);
    void deletePhoneById(Long phoneId);
}
