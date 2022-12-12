package service.interfaces;

import classes.Passport;
import enums.Cities;

import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public interface PersonService{

    String  createPassport(Queue<Passport> passports);
    Passport getPassportByFirstName(Queue<Passport> passports, Scanner scanner);
    void getAllPassports(Queue<Passport> passports);
    List<Cities> getAllCities();
}
