package exception_handling.que5;

import exception_handling.que5.controller.UserController;

public class Main1 {
    public static void main(String[] args) {
        UserController userController=new UserController();
        userController.handleRequest("");
        userController.handleRequest("Sumit");
    }
}
