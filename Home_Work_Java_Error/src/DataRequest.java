import java.io.*;
import java.util.Scanner;

public class DataRequest {

    private String firstName;
    private String lastName;
    private String middleName;
    private String yearOfBirth;
    private long numberPhone;
    private char gender;
    private final Scanner scan = new Scanner(System.in);

    private void EnterFirstName() {
        System.out.println("Enter first name:");
        firstName = scan.nextLine();
        if (firstName.equals("")) {
            throw new RuntimeException("Вводимое значение поля 'Имя' не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterLastName() {
        System.out.println("Enter last name:");
        lastName = scan.nextLine();
        if (lastName.equals("")) {
            throw new RuntimeException("Вводимое значение поля 'Фамилия' не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterMiddleName() {
        System.out.println("Enter middle name");
        middleName = scan.nextLine();
        if (middleName.equals("")) {
            throw new RuntimeException("Вводимое значение поля 'Отчество' не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterYearOfBirth() {
        System.out.println("Enter year of birth:");
        yearOfBirth = scan.nextLine();
        if (yearOfBirth.equals("")) {
            throw new RuntimeException("Вводимое значение 'Дата рождения' не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterNumberPhone() {
        try {
            System.out.println("Enter number phone:");
            String number = scan.nextLine();
            if (number.equals("")) {
                throw new RuntimeException("Вводимое значение в поле 'телефон' не может быть пустым,\nпопробуйте снова!");
            }
            numberPhone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Не верный формат ввода номера 'телефона', попробуйте снова!");
        }
    }

    private void EnterGender() {
        System.out.println("Enter gender (f, m):");
        String gen;
        String f = "f";
        String m = "m";
        gen = scan.nextLine();
        if (gen.length() > 1) {
            throw new RuntimeException("Вы ввели слишком много символов в поле 'пол' \nпопробуйте снова!");
        }
        if (gen.equals(f) || gen.equals(m)) {
            gender = gen.charAt(0);
        } else {
            throw new RuntimeException("Вы ввели не верный символ в поле 'пол' тот символ!");
        }
    }

    private void OutPutData() {
        System.out.println("\nFirst name \t- \t" + firstName + "\n" + "Last name \t- \t" + lastName + "\n" + "Middle name \t- \t" + middleName + "\n" + "Year of birth \t- \t" + yearOfBirth + "\n" + "Number phone \t- \t" + numberPhone + "\n" + "Gender   \t- \t" + gender);
    }

    private void DataEnter() {
        EnterFirstName();
        EnterLastName();
        EnterMiddleName();
        EnterYearOfBirth();
        EnterNumberPhone();
        EnterGender();
        OutPutData();
    }

    public void SaveDataEnter() {
        DataEnter();
        String file = lastName + ".txt";
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("<" + firstName + "> " + "<" + lastName + "> " + "<" + middleName + "> " + "<" + yearOfBirth + "> " + "<" + numberPhone + "> " + "<" + gender + ">\n");
            System.out.println("Файл успешно сохранен!");
        }catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Что то пошло не так!");
        }
    }
}