
package pkg10.pkg7.test.atm.machine;
import java.util.Scanner;
public class TestATMMachine {
            static Scanner input = new Scanner(System.in);
            public static void main(String[] args) {
           
                       Account [] accounts = new Account[10];
                       ATM_Machine atm = new ATM_Machine() ;
                      atm.creatInitialBalance(accounts , 100);
                       while(true){
                                  System.out.println("Enter yor account ID : ");
                                  int accountID = atm.checkAccountID(accounts);
                                  atm = new ATM_Machine(accounts[accountID]);
                                  atm.DisplayMainMenu();
                       }    
            }
}
