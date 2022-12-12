package service.impl;

import classes.Passport;
import enums.Cities;
import enums.Gender;
import service.interfaces.PersonService;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class PersonImpl implements PersonService {
    @Override
    public String createPassport(Queue<Passport> passports) {
        boolean isCreated = false;
        try {
            System.out.println("\nFill out the form\n");
            System.out.print("Set ID: ");
            String id = new Scanner(System.in).next();
            if (id.matches("[a-zA-Z]")) throw new Exception("ID must be number!");
            if (Integer.parseInt(id) < 0) throw new Exception("ID must be positive number!");
            for (Passport passport : passports) {
                if (passport.getId().equals(id)) throw new Exception("This ID already exists!");
            }
            System.out.print("First Name: ");
            String firstName = new Scanner(System.in).next();
            System.out.print("Last Name: ");
            String lastName = new Scanner(System.in).next();
            if (firstName.matches("[0-9]*+") || lastName.matches("[0-9]*+"))
                throw new Exception("Name or Lastname can not contain number!");
            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String[] date = new Scanner(System.in).next().trim().split("-");
            LocalDate birthday = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            System.out.println("Choose Place of Birth: \n");
            List<Cities> cities = List.of(Cities.values());
            cities.forEach(System.out::println);
            System.out.print("\nSet: ");
            String city = new Scanner(System.in).next().toUpperCase();
            Cities placeOfBirth = Cities.valueOf(city);
            System.out.println("Choose your gender");
            Gender gender;
            while (true) {
                System.out.print("""
                    1 - Male
                    2 - Female
                    
                    Choose:""");
                String choice1 = new Scanner(System.in).next();
                if (choice1.equals("1")) {
                    gender = Gender.MALE;
                    break;
                } else if (choice1.equals("2")) {
                    gender = Gender.FEMALE;
                    break;
                } else {
                    System.out.println("Wrong command!");
                }
            }
            isCreated = passports.add(new Passport(id, firstName, lastName, birthday, placeOfBirth, gender));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isCreated ? "Passport created successfully!\n":"Passport creation failed!";
    }
    @Override
    public Passport getPassportByFirstName(Queue<Passport> passports, Scanner scanner) {
        if (passports.size() > 0) {
            try {
                System.out.print("Enter a name: ");
                String name = scanner.next();
                if (name.matches("[0-9]*")) throw new Exception("Name cannot contain number");
                for (Passport passport : passports) {
                    if (passport.getFirstName().equals(name)){
                        return passport;
                    }
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("No passport created yet!");
        }
        return null;
    }

    @Override
    public void getAllPassports(Queue<Passport> passports) {
        if (passports.size() > 0) {
            passports.forEach(System.out::println);
        } else {
            System.out.println("No passport found!");
        }
    }

    @Override
    public List<Cities> getAllCities() {
        return List.of(Cities.values());
    }
}
