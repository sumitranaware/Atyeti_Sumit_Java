package exception_handling.que5.service;

import exception_handling.que5.custom_exception.DatabaseException;
import exception_handling.que5.custom_exception.ServiceException;
import exception_handling.que5.custom_exception.ValidationException;
import exception_handling.que5.dao.UserDao;

public class UserService {
    UserDao userDao=new UserDao();
    public void registerUser(String name) throws ServiceException , ValidationException{
        if(name==null||name.isEmpty()){
            throw  new ValidationException("User name cannot be empty");
        }
        try{
            userDao.saveUser(name);
        }catch (DatabaseException e){
            throw new ServiceException("Service failed while registering user "+name+" due to "+e.getMessage());
        }
    }
}
