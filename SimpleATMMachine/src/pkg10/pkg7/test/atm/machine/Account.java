
package pkg10.pkg7.test.atm.machine;

public class Account{
                        private int ID ;
                        private double Balance ;
                        private double AnnualInterestRate ;
                        private java.util.Date DateCreated;
                        Account(){
                            ID = 0;
                            Balance  = 0;
                            AnnualInterestRate = 0;
                        }
                        Account(int id , double balance){
                            this.ID = id;
                            this.Balance = balance;
                            DateCreated = new java.util.Date();
                        }
                        public double getBalance(){
                            return Balance;
                        }
                        public void setBalance(double b){
                            this.Balance = b;
                        }
                        public int getID(){
                            return ID;
                        }
                        public void setID(int id){
                            this.ID = id;
                        }
                        public double getAnnualInterestRate(){
                            return AnnualInterestRate;
                        }
                        public void setAnnualInterestRate(double AIR){
                            this.AnnualInterestRate = AIR/100;
                        }
                        public double getMonthlyInterestRate(){
                            double MIR = AnnualInterestRate/12;
                            return MIR;
                        }
                        public double getMonthlyInterest(){
                            double Monthly_Interest = getBalance()*getMonthlyInterestRate();
                            return Monthly_Interest;
                        }
                        public void Withdraw(double wd){
                            Balance = Balance-wd;
                        }
                        public void Deposit(double dp){
                            Balance = Balance+dp;
                        }
                        public java.util.Date getDateCreated(){
                            return DateCreated;
                        }

}
