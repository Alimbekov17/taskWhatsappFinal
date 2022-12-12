import classes.Passport;
import classes.Profile;
import classes.Whatsapp;
import service.impl.PersonImpl;
import service.impl.WhatsappImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        PersonImpl personImpl = new PersonImpl();
        WhatsappImpl whatsappImpl = new WhatsappImpl();
        Queue<Passport> passports = new LinkedList<>();
        Map<String, Profile> whatsappProfiles = new HashMap<>();

        while (true) {
            commands();
            System.out.print("Press: ");
            String press = new Scanner(System.in).next();
            switch (press) {
                case "1" -> System.out.println(personImpl.createPassport(passports));
                case "2" -> System.out.println(personImpl.getPassportByFirstName(passports, new Scanner(System.in)));
                case "3" -> personImpl.getAllPassports(passports);
                case "4" -> System.out.println(whatsappImpl.createWhatsappProfile(whatsappProfiles, passports));
                case "5" -> System.out.println(whatsappImpl.goToWhatsappProfile(whatsappProfiles));
                case "6" -> whatsappImpl.getAllWhatsappProfiles(whatsappProfiles);
                case "7" -> System.out.println(whatsappImpl.getStatus(whatsappProfiles));
                case "8" -> System.out.println(whatsappImpl.changeStatus(whatsappProfiles));
                case "9" -> System.out.println(whatsappImpl.addContact(whatsappProfiles));
                case "10" -> System.out.println(whatsappImpl.sendMessage(whatsappProfiles));
                case "11"-> whatsappImpl.getAllStatus().forEach(System.out::println);
                case "12" -> {
                    System.out.println("\n     All available Cities");
                    personImpl.getAllCities().forEach(System.out::println);
                }

            }
        }

    }
    public static void commands() {
        System.out.println("""
                ~~~~~~~~~~~~~~ << Commands >> ~~~~~~~~~~~~~~
                1-  Create passport
                2-  Get passport by first name
                3-  Get all passports
                4-  Create Whatsapp Profile
                5-  Go to Whatsapp profile
                6-  Get all profiles
                7-  Get profile Status
                8-  Change profile Status
                9-  Add contact
                10- Send a message
                11- Get all available statuses
                12- Get all available cities
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~""");
    }
}