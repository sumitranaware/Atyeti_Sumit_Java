package org.example;

import org.example.controller.ApplicationController;
import org.example.controller.ApplicationControllerImpl;

public class Main {
    public static void main(String[] args) {
        ApplicationController applicationController=new ApplicationControllerImpl();
        applicationController.startApplication();
    }
}