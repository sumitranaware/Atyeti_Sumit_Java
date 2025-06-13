package exception_handling.que5.controller;

import exception_handling.que5.custom_exception.ServiceException;
import exception_handling.que5.custom_exception.ValidationException;
import exception_handling.que5.service.UserService;

public class UserController {
    UserService userService=new UserService();
    public void handleRequest(String name){
        try{
            userService.registerUser(name);
        }catch (ValidationException e){
            System.out.println("Validation error "+e.getMessage());
        }catch (ServiceException e){
            System.out.println("Service error "+e.getMessage());
        }
    }
}
