package service.impl;

import classes.Passport;
import classes.Person;
import classes.Profile;
import classes.Whatsapp;
import enums.Status;
import service.interfaces.WhatsappService;

import java.util.*;

public class WhatsappImpl implements WhatsappService {
    @Override
    public String createWhatsappProfile(Map<String, Profile> whatsappProfiles, Queue<Passport> passports) {
        boolean isCreated = false;
        if (passports.size() > 0) {
            try {
                System.out.print("Enter ID: ");
                String id = new Scanner(System.in).next();
                if (id.matches("[a-zA-Z]")) throw new Exception("ID must be number!");
                if (Integer.parseInt(id) < 0) throw new Exception("ID must be positive number!");
                for (Map.Entry<String, Profile> profileEntry : whatsappProfiles.entrySet()) {
                    if (profileEntry.getKey().equals(id)) {
                        throw new Exception("Whatsapp profile is already created for this ID!");
                    }
                }
                for (Passport passport : passports) {
                    if (passport.getId().equals(id)){
                        System.out.print("Set user name: ");
                        String username = new Scanner(System.in).next();
                        for (Map.Entry<String, Profile> profileEntry : whatsappProfiles.entrySet()) {
                            if (profileEntry.getValue().getPerson().getUserName().equals(username)){
                                throw new Exception("This username is already taken!");
                            }
                        }
                        System.out.print("Enter phone number: ");
                        String phoneNumber = new Scanner(System.in).next();
                        if (phoneNumber.matches("[a-zA-Z]") || phoneNumber.length() < 9) throw new Exception("Invalid phone number!");
                        System.out.print("Set password: ");
                        String password = new Scanner(System.in).next();
                        if (password.length() < 3) throw new Exception("Password is too short, must be at least 3 symbols!");
                        List<Person> contacts = new LinkedList<>();
                        Map<String, Stack<String>> messages = new TreeMap<>();
                        whatsappProfiles.put(passport.getId(), new Profile(new Person(username, phoneNumber),
                                password, """
                                 /﹋\\
                                (҂`_´)
                                <,︻╦╤─ ҉ - -
                                /﹋\\
                                """, Status.HEY_THERE_I_AM_USING_WHATSAPP, new Whatsapp(contacts, messages)));
                        isCreated = true;
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return isCreated ? "Whatsapp profile created successfully!" : "Whatsapp profile creation failed!";
    }

    @Override
    public void getAllWhatsappProfiles(Map<String, Profile> whatsappProfiles) {
        if (whatsappProfiles.size() > 0) {
            for (Map.Entry<String, Profile> profileEntry : whatsappProfiles.entrySet()) {
                System.out.println(profileEntry.getValue());
            }
        } else {
            System.out.println("No whatsapp profile found!");
        }
    }

    @Override
    public String goToWhatsappProfile(Map<String, Profile> whatsappProfiles) {
        boolean isFound = false;
        if (whatsappProfiles.size() > 0) {
            try {
                System.out.print("Enter username: ");
                String userName = new Scanner(System.in).next();
                System.out.print("Enter password: ");
                String password = new Scanner(System.in).next();
                if (password.length() < 3) throw new Exception("Password is too short, must be at least 3 symbols!");

                for (Map.Entry<String, Profile> profileEntry : whatsappProfiles.entrySet()) {
                    if (profileEntry.getValue().getPerson().getUserName().equals(userName)
                                                            && profileEntry.getValue().getPassword().equals(password)){
                        System.out.println(profileEntry.getValue());
                        isFound = true;
                    }
                }
                if (!isFound) {
                    throw new Exception("Username or password is incorrect!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("No whatsapp profile created!");
        }
        return "";
    }

    @Override
    public String getStatus(Map<String, Profile> whatsappProfiles) {
        if (whatsappProfiles.size() > 0) {
            boolean isCorrect = false;
            try {
                System.out.print("Enter username: ");
                String userName = new Scanner(System.in).next();
                System.out.print("Enter password: ");
                String password = new Scanner(System.in).next();
                if (password.length() < 3) throw new Exception("Password is too short, must be at least 3 symbols!");
                for (Map.Entry<String, Profile> profileEntry : whatsappProfiles.entrySet()) {
                    if (profileEntry.getValue().getPerson().getUserName().equals(userName)
                            && profileEntry.getValue().getPassword().equals(password)){
                        isCorrect = true;
                        System.out.println("Username      : " + profileEntry.getValue().getPerson().getUserName());
                        System.out.println("Current status: " + profileEntry.getValue().getStatus());
                    }
                }
                if (!isCorrect){
                    throw new Exception("Username or password is incorrect!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            System.out.println("No whatsapp profile created!");
        }
        return "";
    }

    @Override
    public String changeStatus(Map<String, Profile> whatsappProfiles) {
        if (whatsappProfiles.size() > 0) {
            boolean isCorrect = false;
            try {
                System.out.print("Enter username: ");
                String userName = new Scanner(System.in).next();
                System.out.print("Enter password: ");
                String password = new Scanner(System.in).next();
                if (password.length() < 3) throw new Exception("Password is too short, must be at least 3 symbols!");
                for (Map.Entry<String, Profile> profileEntry : whatsappProfiles.entrySet()) {
                    if (profileEntry.getValue().getPerson().getUserName().equals(userName)
                            && profileEntry.getValue().getPassword().equals(password)){
                        System.out.println("Current status: " + profileEntry.getValue().getStatus());
                        System.out.print("Set new Status: ");
                        String status = new Scanner(System.in).next().toUpperCase();
                        profileEntry.getValue().setStatus(Status.valueOf(status));
                        isCorrect = true;
                    }
                }
                if (!isCorrect){
                    throw new Exception("Username or password is incorrect!");
                } else {
                    System.out.println("Status change successful!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("No whatsapp profile created yet!");
        }
        return "";
    }

    @Override
    public List<Status> getAllStatus() {
        return List.of(Status.values());
    }

    @Override
    public String addContact(Map<String, Profile> whatsappProfiles) {
        if (whatsappProfiles.size() > 0){
            List<Person> contact = new LinkedList<>();
            boolean isCorrect = false;
            try {
                System.out.print("Enter username: ");
                String userName = new Scanner(System.in).next();
                System.out.print("Enter password: ");
                String password = new Scanner(System.in).next();
                if (password.length() < 3) throw new Exception("Password is too short, must be at least 3 symbols!");
                for (Map.Entry<String, Profile> profileEntry : whatsappProfiles.entrySet()) {
                    if (profileEntry.getValue().getPerson().getUserName().equals(userName)
                            && profileEntry.getValue().getPassword().equals(password)){
                        System.out.print("Enter phone number to save: ");
                        String phoneNumber = new Scanner(System.in).next();
                        for (Person person : contact) {
                            if (person.getPhoneNumber().equals(phoneNumber))throw new Exception("This number is already in your contacts!");
                        }
                        if (phoneNumber.matches("[a-zA-Z]") || phoneNumber.length() < 9) throw new Exception("Invalid phone number!");
                        for (Map.Entry<String, Profile> profile : whatsappProfiles.entrySet()) {
                            if (profile.getValue().getPerson().getPhoneNumber().equals(phoneNumber)){
                                contact.add(profile.getValue().getPerson());
                                profileEntry.getValue().getWhatsapp().setContacts(contact);
                                System.out.println("Contact added successfully! =>> " + profile.getValue().getPerson().getUserName());
                                isCorrect = true;
                            }
                        }
                    }
                }
                if (!isCorrect){
                    throw new Exception("Username or password is incorrect!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("First you should create a whatsapp profile!");
        }
        return "";
    }

    @Override
    public String sendMessage(Map<String, Profile> whatsappProfiles) {
        Stack<String> messages = new Stack<>();
        Map<String, Stack<String>> newMessage = new LinkedHashMap<>();
        if (whatsappProfiles.size() > 0){
            boolean isCorrect = false;
            try {
                System.out.print("Enter username: ");
                String userName = new Scanner(System.in).next();
                System.out.print("Enter password: ");
                String password = new Scanner(System.in).next();
                if (password.length() < 3) throw new Exception("Password is too short, must be at least 3 symbols!");
                for (Map.Entry<String, Profile> profileEntry : whatsappProfiles.entrySet()) {
                    if (profileEntry.getValue().getPerson().getUserName().equals(userName)
                            && profileEntry.getValue().getPassword().equals(password)){
                        System.out.print("Send message to (write contact name): ");
                        String contactName = new Scanner(System.in).next();
                        for (Person contact : profileEntry.getValue().getWhatsapp().getContacts()) {
                            if (contact.getUserName().equals(contactName)){
                               if (!profileEntry.getValue().getWhatsapp().getMessages().isEmpty()){
                                   for (Map.Entry<String, Stack<String>> received : profileEntry.getValue().getWhatsapp().getMessages().entrySet()) {
                                       System.out.println(received.getKey() + ": " + received.getValue());
                                   }
                               }
                                while (true) {
                                    System.out.print("Write message: ");
                                    String message = new Scanner(System.in).nextLine();
                                    System.out.print("Confirm to send(yes/no): ");
                                    String confirm = new Scanner(System.in).next();
                                    if (confirm.equals("yes")){
                                        messages.add(message);
                                        for (Map.Entry<String, Profile> contactEntry : whatsappProfiles.entrySet()) {
                                            if (contactEntry.getValue().getPerson().equals(contact)){
                                                newMessage.put(userName, messages);
                                                contactEntry.getValue().getWhatsapp().setMessages(newMessage);
                                                System.out.println(userName + ": " + newMessage.get(userName));
                                                isCorrect = true;
                                            }
                                        }
                                    } else if (confirm.equals("no")){
                                        break;
                                    }
                                }
                            }
                        }

                    }
                }
                if (!isCorrect){
                    throw new Exception("Username or password is incorrect!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("First you should create a whatsapp profile!");
        }
        return "";
    }
}
