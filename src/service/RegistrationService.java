package service;

import model.Account;
import model.Robot;

import java.util.Scanner;

public class RegistrationService {
    void login() {
        String response;
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre adresse e-mail : ");
        response = scanner.nextLine();
        account.setEmail(response);
        System.out.print("Entrez votre mot de passe : ");
        response = scanner.nextLine();
        account.setPassword(response);
    }
    void createAccount(){
        String response;
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre nom : ");
        response = scanner.nextLine();
        account.setName(response);
        System.out.println("Entrez votre prénom : ");
        response = scanner.nextLine();
        account.setSurname(response);
        System.out.println("Entrez votre pseudo : ");
        response = scanner.nextLine();
        account.setPseudo(response);
        System.out.println("Entrez votre mot de passe : ");
        response = scanner.nextLine();
        account.setPassword(response);
        System.out.println("Entrez votre adresse e-mail : ");
        response = scanner.nextLine();
        account.setEmail(response);
        System.out.println("Entrez votre numéro de téléphone : ");
        response = scanner.nextLine();
        account.setPhone(response);
        System.out.println("Entrez le nom de votre entreprise (optionnel) : ");
        response = scanner.nextLine();
        account.setCompany(response);
    }

    void createRobot(){
        String response;
        Robot robot = new Robot();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom : ");
        response = scanner.nextLine();
        robot.setName(response);
        System.out.println("Entrez le numéro de série : ");
        response = scanner.nextLine();
        robot.setSerialNumber(response);
        robot.setType(response);
    }
}
