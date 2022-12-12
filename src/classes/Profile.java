package classes;

import enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    private Person person;
    private String password;
    private String image;
    private Status status;
    private Whatsapp whatsapp;

    @Override
    public String toString() {
        return "                Whatsapp Profile\n" +
                "\n" + person +
                "\nImage : \n" + image +
                "\nStatus: " + status +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" +
                whatsapp +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}
