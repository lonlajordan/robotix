package repository;

import enumeration.Profil;
import model.Account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountRepository {
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
}
