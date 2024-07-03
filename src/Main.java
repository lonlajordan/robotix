import enumeration.Profil;
import model.Account;
import repository.AccountRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showMainMenu("U");
    }

    public static void showMainMenu(String profil){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------- MENU PRINCIPAL ---------");
        System.out.println("1- Gestion des utilisateurs");
        System.out.println("2- Voir le profil d'un utilisateur");
        System.out.println("3- Liste des activités");
        System.out.println("4- Gestion des fournisseurs");
        System.out.println("5- Rechercher une composante");
        System.out.println("6- Créer un compte");
        System.out.println("7- Se connecter");
        if("U".equals(profil)){
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

    public static void showAllUser(){
        System.out.println("+------------------------+");
        System.out.println("| Liste des utilisateurs |");
        System.out.println("+------------------------+");
        int n = 0;
        for (Account account : AccountRepository.ACCOUNTS){
            if(Profil.USER.equals(account.getProfil())) System.out.println(String.format("%2d", ++n) + ") " + account.getName() + " " + account.getSurname());
        }
        nextStep();
    }

    public static void showUserDetails(){
        nextStep();
    }

    public static void showAllProvider(){
        System.out.println("+------------------------+");
        System.out.println("| Liste des fournisseurs |");
        System.out.println("+------------------------+");
        int n = 0;
        for (Account account : AccountRepository.ACCOUNTS){
            if(Profil.PROVIDER.equals(account.getProfil())) System.out.println(String.format("%2d", ++n) + ") " + account.getName() + " " + account.getSurname());
        }
        nextStep();
    }

    public static void showAllActivity(){
        nextStep();
    }

    public static void findUser(){
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
            showMainMenu("U");
        } else {
            System.exit(0);
        }
    }
}