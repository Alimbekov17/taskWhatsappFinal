package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String userName;
    private String phoneNumber;

    @Override
    public String toString() {
        return "Username    : " + userName +
                "\nPhone Number: " + phoneNumber;
    }
}
