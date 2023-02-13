
package pkg10.pkg7.test.atm.machine;
import java.util.Scanner;

public class ATM_Machine {
           static Scanner input = new Scanner(System.in);
           int userInput;
           Account account;
           
           public ATM_Machine(){
               
           }

           public ATM_Machine(Account acc){
                      this.account = acc;
           }
           
            public int checkAccountID(Account [] acc){
                       int accountID = input.nextInt();
                       outerloop:
                       while(true){
                                  for(int i  = 0 ; i< acc.length ; i++){
                                             if(i == accountID){
                                                         break outerloop;
                                             }
                                  }
                                  accountID = requestID();
                       }
                       return accountID;
            }
            
            public int requestID(){
                      System.out.println("id is incorrect , enter id again : ");
                      return input.nextInt();
            }
    
            public void creatInitialBalance(Account [] acc , int balance ){
                       for(int i = 0 ; i < acc.length ; i++){
                                  acc[i] = new Account(i , balance);
                      }
           }

            public void DisplayMainMenu(){
                       System.out.print("Main manu "
                                + "\n1 : Check Balance"
                                + "\n2 : Withdraw"
                                + "\n3 : Deposite"
                                + "\n4 : Exit \n");
                       userInput = input.nextInt();
                       checkInput(userInput);
            }
            
            public void checkInput(int userInput){
                      if(userInput == 1){
                                 checkBalance();
                                 DisplayMainMenu();
                      }
                      else if(userInput == 2){
                                 withdraw();
                                 DisplayMainMenu();
                      }
                      else if(userInput == 3){
                                 deposite();
                                 DisplayMainMenu();
                      }
                      else if(userInput == 4){
                                 System.out.println("Exiting ATM Machine .");
                      }
                      else{
                                  System.out.println("incorrect input , try again :");
                                  checkInput(input.nextInt());
                      }
            }
            
            public void checkBalance(){
                System.out.println(account.getBalance());
            }
            public void withdraw(){
                System.out.println("How Much do you want to withdraw :");
                double wd = input.nextDouble();
                if(account.getBalance() < wd){
                    System.out.println("The Requested amount is more than your Balance \n Enter another amount .");
                    DisplayMainMenu();
                }
                else{
                account.Withdraw(wd);
                }
            }
            public void deposite(){
                System.out.println("How Much do you want to deposite :");
                account.Deposit(input.nextDouble());
            }
}
