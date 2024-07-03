package repository;

import model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    public static List<User> USERS = new ArrayList<>(
        Arrays.asList(
            new User("DOE", "John", "alpha", "doe@gmail.com", "Alph@012", "695-463-868", "GOOGLE"),
            new User("REDINGTON", "Raymond", "beta", "raymond@yahoo.fr", "bEt@123", "654-762-824", "IBM"),
            new User("JET", "Li", "gamma", "jet@toyota.com", "288#N21", "655-218-746", "TOYOTA"),
            new User("JACKY", "Chan", "omega", "jacky@gmail.com", "0meG@2024", "677-078-633", "MERCEDES"),
            new User("SYLVESTER", "Stallone", "epsilon", "stallone@apple.com", "epsilon!2345", "677-432-413", "APPLE"),
            new User("ARNOLD", "Schwarzenegger", "sigma", "arnold@amazon.com", "freud!$", "657-035-157", "AMAZON"),
            new User("MICHEAL", "Jordan", "delta", "michael.jordan@suzuki.com", "jackson&123", "699-282-125", "SUZUKI"),
            new User("JACK", "Sparrow", "zeta", "jack.sparrow@airbus.com", "Zorro$123", "690-242-432", "AIRBUS"),
            new User("BRAD", "Pitt", "theta", "brad.pitt@boeing.com", "Titanic$1930", "691-747-119", "BOEING"),
            new User("HARVEY", "Specter", "lambda", "harvey.specter@microsoft.com", "Survivor$234", "695-427-691", "MICROSOFT")
        )
    );
}
