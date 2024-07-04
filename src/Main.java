import enumeration.Profil;
import model.Account;
import model.Robot;
import repository.AccountRepository;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static Account ACCOUNT_CONNECTED;

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------- MENU PRINCIPAL ---------");
        System.out.println("1- Liste des utilisateurs");
        System.out.println("2- Rechercher un utilisateur");
        System.out.println("3- Voir le profil d'un utilisateur");
        System.out.println("3- Liste des activités");
        System.out.println("4- Gestion des fournisseurs");
        System.out.println("5- Rechercher une composante");
        System.out.println("6- Créer un compte");
        System.out.println("7- Se connecter");
        if(ACCOUNT_CONNECTED != null){
            if(Profil.USER.equals(ACCOUNT_CONNECTED.getProfil())){
                System.out.println("6- Modifier mon profil");
                System.out.println("7- Gérer ma flotte (robots et composantes)");
                System.out.println("8- Gérer mes suiveurs");
                System.out.println("9- Gérer mes activités");
                System.out.println("10- Gérer mes intérêts");
                System.out.println("11- Suivre un utilisateur");
                System.out.println("12- S'inscrire à une activité");
                System.out.println("13- Souscrire à un intérêt");
                System.out.println("14- Voir l'état de mes robots");
                System.out.println("15- Voir les métriques");
                System.out.println("16- Voir ses notifications");
            } else {
                System.out.println("7- Gérer mes composantes");
                System.out.println("8- Enregistrer une composante");
            }
        }

        System.out.print("Entrez le numéro de l'action : ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                showAllUser();
                break;
            case 2:
                findUser();
                break;
            case 3:
                showUserDetails();
                break;
            case 4:
                showAllActivity();
                break;
            case 5:
                showAllProvider();
                break;
            case 6:
                findProvider();
                break;
            case 7:
                findComponent();
                break;
        }
    }

    static void showAllUser(){
        System.out.println("+------------------------+");
        System.out.println("| Liste des utilisateurs |");
        System.out.println("+------------------------+");
        int n = 0;
        for (Account account : AccountRepository.ACCOUNTS.stream().filter(account -> Profil.USER.equals(account.getProfil())).collect(Collectors.toList())){
            System.out.println(String.format("%3d", ++n) + ") " + account.getName() + " " + account.getSurname());
        }
        nextStep();
    }

    void login() {
        String email, password;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre adresse e-mail : ");
        email = scanner.nextLine();
        System.out.print("Entrez votre mot de passe : ");
        password = scanner.nextLine();
        ACCOUNT_CONNECTED = AccountRepository.ACCOUNTS.stream().filter(account -> account.getEmail().equals(email) && account.getPassword().equals(password)).findFirst().orElse(null);
        if(ACCOUNT_CONNECTED == null){
            System.out.println("Adresse e-mail ou mot de passe incorrect");
        } else {
            showMainMenu();
        }
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

    public static void showUserDetails(){
        nextStep();
    }

    public static void showAllProvider(){
        System.out.println("+------------------------+");
        System.out.println("| Liste des fournisseurs |");
        System.out.println("+------------------------+");
        int n = 0;
        for (Account account : AccountRepository.ACCOUNTS.stream().filter(account -> Profil.PROVIDER.equals(account.getProfil())).collect(Collectors.toList())){
            System.out.println(String.format("%3d", ++n) + ") " + account.getName());
        }
        nextStep();
    }

    public static void showAllActivity(){
        nextStep();
    }

    public static void findUser(){
        System.out.print("Entrez le pseudo de l'utilisateur : ");
        Scanner scanner = new Scanner(System.in);
        String pseudo = scanner.nextLine().toLowerCase();
        List<Account> accounts = AccountRepository.ACCOUNTS.stream().filter(account -> Profil.USER.equals(account.getProfil()) && account.getPseudo().toLowerCase().contains(pseudo)).collect(Collectors.toList());
        if(accounts.isEmpty()){
            System.out.println("Aucun résultat");
        } else {
            System.out.println("+------------------------+");
            System.out.println("|   Liste des résultats  |");
            System.out.println("+------------------------+");
            int n = 0;
            for (Account account : accounts){
                System.out.println(String.format("%2d", ++n) + ") " + account.getName() + " " + account.getSurname());
            }
        }
        nextStep();
    }

    public static void findProvider(){
        nextStep();
    }

    public static void findComponent(){
        nextStep();
    }

    public static void nextStep(){
        System.out.print("Voulez-vous continuer [O] Oui | [N] Non ? ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.toUpperCase().contains("O")){
            showMainMenu();
        } else {
            System.exit(0);
        }
    }
}