package service;

import enumeration.Profil;
import repository.AccountRepository;
import repository.ActivityRepository;
import repository.ComponentRepository;

import java.util.Scanner;

import static repository.AccountRepository.ACCOUNT_CONNECTED;

public class Navigation {
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
        int choice = getNumber(scanner);
        switch (choice){
            case 1:
                AccountRepository.showAllUser();
                break;
            case 2:
                AccountRepository.findUser();
                break;
            case 3:
                AccountRepository.showUserDetails();
                break;
            case 4:
                ActivityRepository.showAllActivity();
                break;
            case 5:
                AccountRepository.showAllProvider();
                break;
            case 6:
                AccountRepository.findProvider();
                break;
            case 7:
                ComponentRepository.findComponent();
                break;
        }
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

    public static int getNumber(Scanner scanner){
        String value = scanner.nextLine();
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e){
            System.out.print("Nombre invalide. Veuillez réessayer : ");
            return getNumber(scanner);
        }
    }
}
