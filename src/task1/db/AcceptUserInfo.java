package task1.db;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AcceptUserInfo {

    public static int getUserChoiceInInt(){
        Scanner sc = new Scanner(System.in);
        while (true){
            try{
                int n = sc.nextInt();
                return n;
            } catch (InputMismatchException e) {
                System.err.println("Incorrect input format! Use number!");
                sc.nextLine();
            }
        }
    }
    public static Long getUserChoiceInLong (){
        Scanner sc = new Scanner(System.in);
        while (true){
            try{
                Long n = sc.nextLong();
                return n;
            } catch (InputMismatchException e) {
                System.err.println("Incorrect input format! Use number!");
                sc.nextLine();
            }
        }
    }
}
