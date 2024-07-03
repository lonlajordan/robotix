import model.Provider;
import model.User;
import repository.ProviderRepository;
import repository.UserRepository;

import java.util.Scanner;

public class Main {
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
        System.out.println("5- Liste des fournisseurs");
        System.out.println("6- Rechercher un fournisseur");
        System.out.println("7- Rechercher une composante\n");
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
        for (User user : UserRepository.USERS){
            System.out.println(String.format("%2d", ++n) + ") " + user.getName() + " " + user.getSurname());
        }
        nextStep();
    }

    public static void showUserDetails(){
        nextStep();
    }

    public static void showAllProvider(){
        nextStep();
    }

    public static void showAllActivity(){
        nextStep();
    }

    public static void findUser(){
        nextStep();
    }

    public static void findProvider(){
        System.out.println("+------------------------+");
        System.out.println("| Liste des fournisseurs |");
        System.out.println("+------------------------+");
        int n = 0;
        for (Provider provider : ProviderRepository.PROVIDERS){
            System.out.println(String.format("%2d", ++n) + ") " + provider.getName());
        }
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