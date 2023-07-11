package gr.aueb.cf.dao;

import gr.aueb.cf.model.Account;

public class AccountDAOImple extends AbstractDAO<Account> implements IAccountDAO {

    public AccountDAOImple() {
        this.setPersistentClass(Account.class);
    }
}
