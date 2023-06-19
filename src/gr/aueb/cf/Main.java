package gr.aueb.cf;

import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;
import gr.aueb.cf.model.Account;
import gr.aueb.cf.model.OverdraftAccount;
import gr.aueb.cf.model.OverdraftJointAccount;
import gr.aueb.cf.model.User;

public class Main {
    public static void main(String[] args) {
        User stavros = new User("Stavros", "N.", "12345");
        Account account = new Account(stavros, "GR12345", 100);
        Account overStavros = new OverdraftAccount(stavros, "GR12345", 50);
        User vagelis = new User("Vagelis", "N.", "56789");
        Account overJointAccount = new OverdraftJointAccount(stavros, "GR256789", 200.50, vagelis);

        try {
            System.out.println("Account: \n" + account);
            System.out.println("Overdraft: \n" + overStavros);

            overJointAccount.deposit(100);
            overJointAccount.withdraw(50, "56789");

            System.out.println(overJointAccount);
        } catch (NegativeAmountException | InsufficientBalanceException | SsnNotValidException e) {
            System.out.println(e.getMessage());
        }
    }
}
