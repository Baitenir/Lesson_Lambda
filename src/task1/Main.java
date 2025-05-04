package task1;
import task1.db.AcceptUserInfo;
import task1.db.GenId;
import task1.models.Contact;
import task1.models.Phone;
import task1.service.ContactService;
import task1.service.PhoneService;
import task1.service.serviceImpl.ContactServiceImpl;
import task1.service.serviceImpl.PhoneServiceImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactService contactService = new ContactServiceImpl();
        PhoneService phoneService = new PhoneServiceImpl();

            while (true) {
                System.out.println("""
                        
                        MAIN MENU
                        1. About phone
                        2. About contact
                        3. OFF
                        """);
                try {
                switch (AcceptUserInfo.getUserChoiceInInt()) {
                    case 1:
                        boolean isTrue = true;
                        while (isTrue) {
                            System.out.println("""
                                    
                                       PHONE MENU
                                    1. Add phone
                                    2. Find phone by id
                                    3. Update phone name by id
                                    4. Show all phones
                                    5. Show all phones by brand
                                    6. Delete phone by id
                                    7. EXIT
                                    """);
                            switch (AcceptUserInfo.getUserChoiceInInt()) {
                                case 1:
                                    Phone phone = new Phone();
                                    phone.setId(GenId.genIdForPhone());
                                    System.out.println("Write name: ");
                                    phone.setName(scanner.nextLine());
                                    System.out.println("Write brand: ");
                                    phone.setBrand(scanner.nextLine());
                                    System.out.println(phoneService.addPhone(phone));
                                    break;
                                case 2:
                                    System.out.println("Write phone id: ");
                                    System.out.println(phoneService.getPhoneByID(AcceptUserInfo.getUserChoiceInLong()));
                                    break;
                                case 3:
                                    System.out.println("Write new name: ");
                                    String n = scanner.nextLine();
                                    System.out.println("Write phone id: ");
                                    System.out.println(phoneService.updatePhoneNameById(AcceptUserInfo.getUserChoiceInLong(), n));
                                    break;
                                case 4:
                                    System.out.println(phoneService.getAllPhones());
                                    break;
                                case 5:
                                    System.out.println("Write brand: ");
                                    System.out.println(phoneService.getAllPhonesByBrand(scanner.nextLine()));
                                    break;
                                case 6:
                                    System.out.println("Write phone id: ");
                                    phoneService.deletePhoneById(AcceptUserInfo.getUserChoiceInLong());
                                    break;
                                case 7:
                                    isTrue = false;
                                    break;
                                default:
                                    System.out.println("Incorrect choice, try again!");
                                    break;
                            }
                        }
                        break;
                    case 2:
                        boolean isTrue2 = true;
                        while (isTrue2) {
                            System.out.println("""
                                    
                                       CONTACT MENU
                                    1. Add contact
                                    2. Find contact by name
                                    3. Find contact by phone number
                                    4. Sort contact by name
                                    5. Delete contact by name from phone
                                    6. EXIT
                                    """);
                            switch (AcceptUserInfo.getUserChoiceInInt()) {
                                case 1:
                                    Contact contact = new Contact();
                                    System.out.println("Write name: ");
                                    contact.setName(scanner.nextLine());
                                    System.out.println("Write phone number: ");
                                    contact.setPhoneNumber(scanner.nextLine());
                                    contact.setId(GenId.genIdForContact());
                                    System.out.println("Write phone id: ");
                                    System.out.println(contactService.addContactToPhone(AcceptUserInfo.getUserChoiceInLong(), contact));
                                    break;
                                case 2:
                                    System.out.println("Write contact name: ");
                                    String n = scanner.nextLine();
                                    System.out.println("Write phone id: ");
                                    System.out.println(contactService.getContactByName(AcceptUserInfo.getUserChoiceInLong(), n));
                                    break;
                                case 3:
                                    System.out.println("Write phone number: ");
                                    String p = scanner.nextLine();
                                    System.out.println("Write phone id: ");
                                    System.out.println(contactService.getContactByPhoneNumber(AcceptUserInfo.getUserChoiceInLong(), p));
                                    break;
                                case 4:
                                    System.out.println("Write phone id: ");
                                    System.out.println(contactService.sortContactsByName(AcceptUserInfo.getUserChoiceInLong()));
                                    break;
                                case 5:
                                    System.out.println("Write contact name: ");
                                    String s = scanner.nextLine();
                                    System.out.println("Write phone id: ");
                                    contactService.deleteContactByNameFromPhone(AcceptUserInfo.getUserChoiceInLong(), s);
                                    break;
                                case 6:
                                    isTrue2 = false;
                                    break;
                                default:
                                    System.out.println("Incorrect choice, try again!");
                                    break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Bye bye ");
                        return;
                    default:
                        System.out.println("Incorrect choice, try again!");
                        break;
                }
            }  catch (RuntimeException e){
                    System.err.println(e.getMessage());
                }
        }
    }
}
//    Жаны проект тузунуз.
//    3 пакет тузунуз model, db, service.
//    model пакеттин ичине Phone жана Contact деген класс тузунуз.
//    Phone (id, name, brand, contacts(List)) полелери болуш керек.
//    Contact (name, phoneNumber).
//    db пакеттин ичинде DataBase класс бар, свойствасы катары телефондордун листин алат, бул класс бизге база данных болот.
//    service пакет ичинде PhoneService жана ContactService interface тер болот.
//    Ушул 2 interface ти implements кылган 2 класс тузунуз(PhoneServiceImpl жана ContactServiceImpl)
//    ушул 2 класстын ичине свойства катары биздин DataBase класс келсин жана маалыматтарды ошол жактан алып,
//    сактап, очуруп жана башка манипуляция кылсак болот
//
//
//    PhoneService methods :
//            - String addPhone(Phone phone);
//
//    // with stream
//
//           - Phone getPhoneById(int phoneId);
//
//    // with stream
//
//          - Phone updatePhoneNameById(int phoneId, String newName);
//
//    // with stream
//
//          - List<Phone> getAllPhones();
//
//    // with stream
//
//          - List<Phone> getAllPhonesByBrand(String brand);
//
//         - void deletePhoneById(int phoneId);
//
//
//
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