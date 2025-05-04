package task1.db;

public class GenId {
    private static Long idForPhone = 0L;
    private static Long idForContact = 0L;

    public static Long genIdForPhone(){
        return ++idForPhone;
    }

    public static Long genIdForContact(){
        return ++idForContact;
    }
}
