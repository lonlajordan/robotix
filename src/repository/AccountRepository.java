package repository;

import enumeration.Profil;
import model.Account;
import model.Notification;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static service.Navigation.*;

public class AccountRepository {
    public static Account ACCOUNT_CONNECTED;

    public static List<Account> ACCOUNTS = new ArrayList<>(
        Arrays.asList(
            new Account(1L, Profil.USER, "DOE", "John", "alpha", "doe@gmail.com", "Alph@012", "695-463-868", "GOOGLE"),
            new Account(2L, Profil.USER,"REDINGTON", "Raymond", "beta", "raymond@yahoo.fr", "bEt@123", "654-762-824", "IBM"),
            new Account(3L, Profil.USER,"JET", "Li", "gamma", "jet@toyota.com", "288#N21", "655-218-746", "TOYOTA"),
            new Account(4L, Profil.USER,"JACKY", "Chan", "omega", "jacky@gmail.com", "0meG@2024", "677-078-633", "MERCEDES"),
            new Account(5L, Profil.USER,"SYLVESTER", "Stallone", "epsilon", "stallone@apple.com", "epsilon!2345", "677-432-413", "APPLE"),
            new Account(6L, Profil.USER,"ARNOLD", "Schwarzenegger", "sigma", "arnold@amazon.com", "freud!$", "657-035-157", "AMAZON"),
            new Account(7L, Profil.USER,"MICHEAL", "Jordan", "delta", "michael.jordan@suzuki.com", "jackson&123", "699-282-125", "SUZUKI"),
            new Account(8L, Profil.USER,"JACK", "Sparrow", "zeta", "jack.sparrow@airbus.com", "Zorro$123", "690-242-432", "AIRBUS"),
            new Account(9L, Profil.USER,"BRAD", "Pitt", "theta", "brad.pitt@boeing.com", "Titanic$1930", "691-747-119", "BOEING"),
            new Account(10L, Profil.USER,"HARVEY", "Specter", "lambda", "harvey.specter@microsoft.com", "Survivor$234", "695-427-691", "MICROSOFT"),

            new Account(11L, Profil.PROVIDER,"JACQUES Chirac", "chirac@gmail.com", "288#N21", "655-218-746", "France", "PEUGEOT", 1500),
            new Account(12L, Profil.PROVIDER,"DONNIE Yen", "donnie@yahoo.fr", "freud!$", "677-078-633", "Japan", "TOYOTA", 2000),
            new Account(13L, Profil.PROVIDER,"TONY Cross", "tony@yahoo.com", "Zorro$123", "695-463-868", "Germany", "MERCEDES", 2500),
            new Account(14L, Profil.PROVIDER,"ZINEDINE Zidane", "zidane@gmail.com", "Titanic$1930", "654-762-824", "Korea", "SUZUKI", 3000),
            new Account(15L, Profil.PROVIDER,"KEVIN Owen", "kevin@gmail.com", "Survivor$234", "677-432-413", "USA", "BOEING", 3500)
        )
    );

    public static void showAllUser(){
        System.out.println("+------------------------+");
        System.out.println("| Liste des utilisateurs |");
        System.out.println("+------------------------+");
        int n = 0;
        for (Account account : AccountRepository.ACCOUNTS.stream().filter(account -> Profil.USER.equals(account.getProfil())).collect(Collectors.toList())){
            System.out.println(String.format("%3d", ++n) + ") " + account.getName() + " " + account.getSurname() + " [id = " + account.getId() + "]");
        }
        nextStep();
    }

    public static void findUser(){
        System.out.print("Entrez le pseudo ou le nom d'un suiveur : ");
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.nextLine().toLowerCase();
        List<Account> accounts = AccountRepository.ACCOUNTS.stream().filter(account -> {
            boolean match = Profil.USER.equals(account.getProfil());
            match = match && (account.getPseudo().toLowerCase().contains(keyword) || account.getFollowers().stream().anyMatch(follower -> follower.getFullName().toLowerCase().contains(keyword)));
            return match;
        }).collect(Collectors.toList());
        if(accounts.isEmpty()){
            System.out.println("Aucun résultat");
        } else {
            System.out.println("+------------------------+");
            System.out.println("|   Liste des résultats  |");
            System.out.println("+------------------------+");
            int n = 0;
            for (Account account : accounts){
                System.out.println(String.format("%2d", ++n) + ") " + account.getFullName() + " [id = " + account.getId() + "]");
            }
        }
        nextStep();
    }

    public static void showAllProvider(){
        System.out.println("+------------------------+");
        System.out.println("| Liste des fournisseurs |");
        System.out.println("+------------------------+");
        int n = 0;
        for (Account account : AccountRepository.ACCOUNTS.stream().filter(account -> Profil.PROVIDER.equals(account.getProfil())).collect(Collectors.toList())){
            System.out.println(String.format("%3d", ++n) + ") " + account.getName() + " [id = " + account.getId() + "]");
        }
        nextStep();
    }

    public static void showAccountDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro d'identifiant : ");
        int id = getNumber(scanner);
        Account account = AccountRepository.ACCOUNTS.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if(account == null){
            System.out.println("Compte introuvable");
        } else {
            System.out.println("- id : " + account.getId());
            System.out.println("- Nom : " + account.getName());
            if(account.getProfil().equals(Profil.USER)){
                System.out.println("- Prénom : " + account.getSurname());
                System.out.println("- Pseudo : " + account.getSurname());
            } else {
                System.out.println("- Adresse : " + account.getAddress());
            }
            System.out.println("- Email : " + account.getEmail());
            System.out.println("- Téléphone : " + account.getPhone());
        }
        nextStep();
    }

    public static void login() {
        String email, password;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre adresse e-mail : ");
        email = scanner.nextLine();
        System.out.print("Entrez votre mot de passe : ");
        password = scanner.nextLine();
        ACCOUNT_CONNECTED = AccountRepository.ACCOUNTS.stream().filter(account -> account.getEmail().equals(email) && account.getPassword().equals(password)).findFirst().orElse(null);
        if(ACCOUNT_CONNECTED == null){
            System.out.println("Adresse e-mail ou mot de passe incorrect");
            nextStep();
        } else {
            System.out.println("Bienvenu sur Robotix, " + ACCOUNT_CONNECTED.getFullName());
            showMainMenu();
        }
    }

    public static void updateProfil(){
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

    public static void findProvider(){
        System.out.print("Entrez le nom, une adresse ou le type de composante : ");
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.nextLine().toLowerCase();
        List<Account> accounts = AccountRepository.ACCOUNTS.stream().filter(account -> {
            boolean match = Profil.PROVIDER.equals(account.getProfil());
            match = match && (account.getName().toLowerCase().contains(keyword) || account.getAddress().toLowerCase().contains(keyword) || account.getComponents().stream().anyMatch(component -> component.getType().toLowerCase().contains(keyword)));
            return match;
        }).collect(Collectors.toList());
        if(accounts.isEmpty()){
            System.out.println("Aucun résultat");
        } else {
            System.out.println("+------------------------+");
            System.out.println("|   Liste des résultats  |");
            System.out.println("+------------------------+");
            int n = 0;
            for (Account account : accounts){
                System.out.println(String.format("%2d", ++n) + ") " + account.getName() + " " + account.getSurname() + " [id = " + account.getId() + "]");
            }
        }
        nextStep();
    }

    public static void showAllMyFollowers(Account account){
        System.out.println("+---------------------------+");
        System.out.println("|   Liste de mes suiveurs   |");
        System.out.println("+---------------------------+");
        int n = 0;
        for (Account follower : account.getFollowers()){
            System.out.println(String.format("%3d", ++n) + ") " + follower.getFullName() + " [id = " + account.getId() + "]");
        }
        nextStep();
    }

    public static void showAllMyNotifications(Account account){
        System.out.println("+--------------------------------+");
        System.out.println("|   Liste de mes notifications   |");
        System.out.println("+--------------------------------+");
        int n = 0;
        for (Notification notification : account.getNotifications()){
            System.out.println(String.format("%3d", ++n) + ") " + notification.getMessage() + " [Date = " + new SimpleDateFormat("dd-MM-yyyy").format(notification.getDate()) + "]");
        }
        nextStep();
    }
}
