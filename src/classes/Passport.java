package classes;

import enums.Cities;
import enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Passport {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private Cities placeOfBirth;
    private Gender gender;

    @Override
    public String toString() {
        return "            Passport\n" +
                "\nID            : " + id +
                "\nFirst name    : " + firstName +
                "\nLast name     : " + lastName +
                "\nDate of Birth : " + birthDay +
                "\nPlace of Birth: " + placeOfBirth +
                "\nGender        : " + gender + "\n" +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}
