package exception_handling.que5.dao;

import exception_handling.que5.custom_exception.DatabaseException;

public class UserDao {
    public void saveUser(String name)throws DatabaseException {
        throw new DatabaseException("DB Connection failed while saving user "  +name);

    }
}
