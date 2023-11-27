package Register;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        showMenu();
    }

    static ArrayList<Person> listPerson = new ArrayList<>();

    private static boolean validateDocumentNumber(String documentNumber) {
        return documentNumber.matches("[0-9]+") && documentNumber.length() <= 8;
    }

    private static boolean validateBirthday(String birthday) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        formatDate.setLenient(false);
        try {
            formatDate.parse(birthday);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static void register() {
        String name = JOptionPane.showInputDialog("Please, add the name person");
        String lastname = JOptionPane.showInputDialog("Please, add the last name person");
        String documentNumberInput = JOptionPane.showInputDialog("Please, add the document number of the person");
        String birthdayDate = JOptionPane
                .showInputDialog("Please, add the birthday of the person in formate dd/MM/yyyy");

        if (name.isBlank() || lastname.isBlank()) {
            JOptionPane.showMessageDialog(null, "The name or the last name cannot be blank", lastname, 0);
            return;
        }
        if (!validateDocumentNumber(documentNumberInput)) {
            JOptionPane.showMessageDialog(null, "The document number must be a number and have 8 digits",
                    "Validation error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!validateBirthday(birthdayDate)) {
            JOptionPane.showMessageDialog(null, "The date of birth must be in the format dd/MM/yyyy and be valid",
                    "Validation error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            SimpleDateFormat formatDate = new SimpleDateFormat();
            Date birthday = formatDate.parse(birthdayDate);
            Integer documentNumber = Integer.parseInt(documentNumberInput);
            Person person = new Person(name, lastname, documentNumber, birthday);
            listPerson.add(person);
            JOptionPane.showMessageDialog(null, "Registered person", "Successfully cumpleted",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error in date or document number, please check", "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void listAll() {
        if (listPerson.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There aren't registered people", "List Empty",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder message = new StringBuilder("List of people successfully registered: \n");
            for (Person person : listPerson) {
                message.append(person.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, message.toString(), "List of people", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void showMenu() {
        String[] options = { "Register new person", "Show list person", "Exit" };
        Integer optionselect = JOptionPane.showOptionDialog(null, "Select an option", "Register",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (optionselect) {
            case 0:
                register();
                break;
            case 1:
                listAll();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.exit(0);
                break;
        }
    }
}
