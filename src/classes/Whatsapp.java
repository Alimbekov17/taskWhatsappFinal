package classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Whatsapp {
    private List<Person> contacts;
    private Map<String, Stack<String>> messages;

    @Override
    public String toString() {
        return "\nContacts: \n" + contacts +
                "\nMessages: \n" + messages;
    }
}
