package service;

import model.Robot;
import model.User;

import java.util.Scanner;

public class RegistrationService {
    void addUser(){
        String response;
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name : ");
        response = scanner.nextLine();
        user.setName(response);
        System.out.println("Enter your surname : ");
        response = scanner.nextLine();
        user.setSurname(response);
        System.out.println("Enter your pseudo : ");
        response = scanner.nextLine();
        user.setPseudo(response);
        System.out.println("Enter your password : ");
        response = scanner.nextLine();
        user.setPassword(response);
        System.out.println("Enter your e-mail : ");
        response = scanner.nextLine();
        user.setEmail(response);
        System.out.println("Enter your phone number : ");
        response = scanner.nextLine();
        user.setPhone(response);
        System.out.println("Enter your company name (optional) : ");
        response = scanner.nextLine();
        user.setCompany(response);
    }

    void addRobot(){
        String response;
        Robot robot = new Robot();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name : ");
        response = scanner.nextLine();
        robot.setName(response);
        System.out.println("Enter the serial number : ");
        response = scanner.nextLine();
        robot.setSerialNumber(response);
        robot.setType(response);
    }
}
