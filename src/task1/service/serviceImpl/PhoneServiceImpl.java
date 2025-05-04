package task1.service.serviceImpl;
import task1.dao.PhoneDao;
import task1.dao.daoImpl.PhoneDaoImpl;
import task1.models.Phone;
import task1.service.PhoneService;
import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    PhoneDao phoneDao = new PhoneDaoImpl();
    @Override
    public String addPhone(Phone phone) {
        return phoneDao.addPhone(phone);
    }

    @Override
    public Phone getPhoneByID(Long id) {
        return phoneDao.getPhoneByID(id);
    }

    @Override
    public Phone updatePhoneNameById(Long id, String newName) {
        return phoneDao.updatePhoneNameById(id, newName);
    }

    @Override
    public List<Phone> getAllPhones() {
        return phoneDao.getAllPhones();
    }

    @Override
    public List<Phone> getAllPhonesByBrand(String brand) {
        return phoneDao.getAllPhonesByBrand(brand);
    }

    @Override
    public void deletePhoneById(Long phoneId) {
        phoneDao.deletePhoneById(phoneId);
    }
}
