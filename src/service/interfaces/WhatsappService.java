package service.interfaces;

import classes.Passport;
import classes.Profile;
import classes.Whatsapp;
import enums.Status;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public interface WhatsappService {
    //                1-  Create passport
//                2-  Get passport by first name
//                3-  Get all passports
//                4-  Create Whatsapp Profile
//                5-  Go to Whatsapp profile
//                6-  Get all profiles
//                7-  Get profile Status
//                8-  Change profile Status
//                9-  Add contact
//                10- Send a message
//                11- Get all available statuses
//                12- Get all available cities
    String createWhatsappProfile(Map<String, Profile> whatsappProfiles, Queue<Passport> passports);
    void getAllWhatsappProfiles(Map<String, Profile> whatsappProfiles);
    String  goToWhatsappProfile(Map<String, Profile> whatsappProfiles);
    String getStatus(Map<String, Profile> whatsappProfiles);
    String changeStatus(Map<String, Profile> whatsappProfiles);
    List<Status> getAllStatus();
    String addContact(Map<String, Profile> whatsappProfiles);
    String sendMessage(Map<String, Profile> whatsappProfiles);
}
