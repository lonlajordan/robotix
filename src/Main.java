import enumeration.Profil;
import model.*;
import repository.AccountRepository;
import repository.ActivityRepository;
import repository.ComponentRepository;
import repository.InterestRepository;

import java.util.List;
import java.util.Objects;
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
        System.out.println("4- Liste des activités");
        System.out.println("5- Gestion des fournisseurs");
        System.out.println("6- Rechercher une composante");
        System.out.println("7- Se connecter");
        if(ACCOUNT_CONNECTED != null){
            System.out.println("8- Modifier mon profil");
            if(Profil.USER.equals(ACCOUNT_CONNECTED.getProfil())){
                System.out.println("9- Gérer ma flotte (robots et composantes)");
                System.out.println("10- Gérer mes suiveurs");
                System.out.println("11- Gérer mes activités");
                System.out.println("12- Gérer mes intérêts");
                System.out.println("13- Suivre un utilisateur");
                System.out.println("14- S'inscrire à une activité");
                System.out.println("15- Souscrire à un intérêt");
                System.out.println("16- Voir l'état de mes robots");
                System.out.println("17- Voir les métriques");
                System.out.println("18- Voir ses notifications");
            } else {
                System.out.println("9- Gérer mes composantes");
                System.out.println("10- Enregistrer une composante");
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
            System.out.println(String.format("%3d", ++n) + ") " + account.getName() + " " + account.getSurname() + " [id = " + account.getId() + "]");
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

    void updateProfil(){
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro d'identifiant de l'utilisateur : ");
        int id = scanner.nextInt();
        Account account = AccountRepository.ACCOUNTS.stream().filter(a -> a.getId() == id && a.getProfil().equals(Profil.USER)).findFirst().orElse(null);
        if(account == null){
            System.out.println("Utilisateur introuvable");
        } else {
            System.out.println("- id : " + account.getId());
            System.out.println("- Nom : " + account.getName());
            System.out.println("- Prénom : " + account.getSurname());
            System.out.println("- pseudo : " + account.getSurname());
            System.out.println("- Email : " + account.getEmail());
            System.out.println("- Téléphone : " + account.getPhone());
        }
        nextStep();
    }

    public static void showProviderDetails(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro d'identifiant du fournisseur : ");
        int id = scanner.nextInt();
        Account account = AccountRepository.ACCOUNTS.stream().filter(a -> a.getId() == id && a.getProfil().equals(Profil.PROVIDER)).findFirst().orElse(null);
        if(account == null){
            System.out.println("Fournisseur introuvable");
        } else {
            System.out.println("- id : " + account.getId());
            System.out.println("- Nom : " + account.getName());
            System.out.println("- Adresse : " + account.getAddress());
            System.out.println("- Email : " + account.getEmail());
            System.out.println("- Téléphone : " + account.getPhone());
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

    public static void showAllMyFollowers(){
        System.out.println("+---------------------------+");
        System.out.println("|   Liste de mes suiveurs   |");
        System.out.println("+---------------------------+");
        int n = 0;
        for (Account account : ACCOUNT_CONNECTED.getFollowers()){
            System.out.println(String.format("%3d", ++n) + ") " + account.getName() + " [id = " + account.getId() + "]");
        }
        nextStep();
    }

    public static void showAllMyActivities(){
        System.out.println("+----------------------------+");
        System.out.println("|   Liste de mes activités   |");
        System.out.println("+----------------------------+");
        int n = 0;
        for (Activity activity : ACCOUNT_CONNECTED.getActivities()){
            System.out.println(String.format("%3d", ++n) + ") " + activity.getName() + " [id = " + activity.getId() + "]");
        }
        nextStep();
    }

    public static void showAllActivity(){
        System.out.println("+---------------------+");
        System.out.println("| Liste des activités |");
        System.out.println("+---------------------+");
        int n = 0;
        for (Activity activity : ActivityRepository.ACTIVITIES){
            System.out.println(String.format("%3d", ++n) + ") " + activity.getName());
        }
        nextStep();
    }

    public static void showAllMyInterests(){
        System.out.println("+-----------------------+");
        System.out.println("| Liste de mes intérêts |");
        System.out.println("+-----------------------+");
        int n = 0;
        for (Activity activity : ActivityRepository.ACTIVITIES){
            for(Interest interest: activity.getInterests()){
                System.out.println(String.format("%3d", ++n) + ") " + interest.getName());
            }
        }
        nextStep();
    }

    public static void showAllInterest(){
        System.out.println("+----------------------+");
        System.out.println("|  Liste des intérêts  |");
        System.out.println("+----------------------+");
        int n = 0;
        for (Interest interest : InterestRepository.INTERESTS){
            System.out.println(String.format("%3d", ++n) + ") " + interest.getName());
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
                System.out.println(String.format("%2d", ++n) + ") " + account.getName() + " " + account.getSurname() + " [id = " + account.getId() + "]");
            }
        }
        nextStep();
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

    public static void showAllComponent(){
        System.out.println("+--------------------------+");
        System.out.println("| Liste de mes composantes |");
        System.out.println("+--------------------------+");
        int n = 0;
        for (Component component : ComponentRepository.COMPONENTS.stream().filter(component -> Objects.equals(ACCOUNT_CONNECTED.getId(), component.getProvider().getId())).collect(Collectors.toList())){
            System.out.println(String.format("%3d", ++n) + ") " + component.getName());
        }
        nextStep();
    }

    public static void findComponent(){
        System.out.print("Entrez le nom, le type ou le nom du fournisseur : ");
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.nextLine().toLowerCase();
        List<Component> components = ComponentRepository.COMPONENTS.stream().filter(component -> {
            boolean match = component.getName().toLowerCase().contains(keyword);
            match = match || component.getType().toLowerCase().contains(keyword);
            match = match || component.getProvider().getFullName().toLowerCase().contains(keyword);
            return match;
        }).collect(Collectors.toList());
        if(components.isEmpty()){
            System.out.println("Aucun résultat");
        } else {
            System.out.println("+------------------------+");
            System.out.println("|   Liste des résultats  |");
            System.out.println("+------------------------+");
            int n = 0;
            for (Component component : components){
                System.out.println(String.format("%2d", ++n) + ") " + component.getName());
            }
        }
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