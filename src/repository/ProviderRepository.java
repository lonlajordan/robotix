package repository;

import model.Provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProviderRepository {
    public static List<Provider> PROVIDERS = new ArrayList<>(
        Arrays.asList(
           new Provider("", "", "", "655-218-746", "France", "PEUGEOT", 1500),
           new Provider("", "", "", "677-078-633", "Japan", "TOYOTA", 2000),
           new Provider("", "", "", "695-463-868", "Germany", "MERCEDES", 2500),
           new Provider("", "", "", "654-762-824", "Korea", "SUZUKI", 3000),
           new Provider("", "", "", "677-432-413", "USA", "BOEING", 3500)
        )
    );
}
