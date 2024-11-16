import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Password {

    private String password;

    public String getPassword(){

        return password;
    }



    public void generatePassword() {


        Scanner scanner = new Scanner(System.in);

        int password_length = 0;
        boolean number_check = false;
        boolean  capitalLetter_check = false;
        boolean specialChar_check = false;
        boolean flag = true;

        while (flag) {



            try {
                System.out.println("Сколько символов должно быть в пароле?");
                password_length = scanner.nextInt();
                if (password_length <= 0) {
                    System.out.println("Длина пароля должна быть больше 0");
                    scanner.next();
                }

                scanner.nextLine();

                System.out.println("Должны ли быть в пароле быть цифры? 'Да' или  'Нет'");

                switch (scanner.nextLine()) {

                    case "Да" -> number_check = true;
                    case "Нет" -> number_check = false;
                    default -> {System.out.println("Введите 'Да' или 'Нет'"); scanner.next();;}
                }

                System.out.println("Должны ли быть в пароле заглавные буквы? 'Да' или  'Нет'");

                switch (scanner.nextLine()) {

                    case "Да" -> capitalLetter_check = true;
                    case "Нет" -> capitalLetter_check = false;
                    default -> {System.out.println("Введите 'Да' или 'Нет'"); scanner.next();;}
                }

                System.out.println("Должны ли быть в пароле специальные символы? 'Да' или  'Нет'");

                switch (scanner.nextLine()) {

                    case "Да" -> specialChar_check = true;
                    case "Нет" -> specialChar_check = false;
                    default -> {System.out.println("Введите 'Да' или 'Нет'"); scanner.next();;}
                }

                System.out.println("В пароле будут:");
                System.out.println(String.format("Количество символов: %s", password_length));
                System.out.println(String.format("Цифры: %s", number_check ? "Да" : "Нет"));
                System.out.println(String.format("Заглавные буквы: %s", capitalLetter_check ? "Да" : "Нет"));
                System.out.println(String.format("Специальные символы: %s", specialChar_check ? "Да" : "Нет"));


                scanner.nextLine();
                System.out.println("Всё верно? 'Да' или 'Нет'.");

                switch (scanner.nextLine()) {

                    case "Да" -> {
                        flag = false;
                        scanner.close();
                    }
                    case "Нет" -> {
                        continue;

                    }
                    default -> {
                        System.out.println("Введите 'Да' или 'Нет'");
                        scanner.next();
                    }
                }

            }catch (InputMismatchException e) {

                System.out.println("Укажите число");

                scanner.next();
            }

        }
        generatedPassword(password_length, number_check, capitalLetter_check, specialChar_check);


    }

    private void generatedPassword(int password_length, boolean number_check,
                                     boolean  capitalLetter_check, boolean specialChar_check) {


        HashMap<Integer, Character> alphabet = new HashMap<>();
        for (char letter = 'a'; letter <= 'z'; letter++) {
            alphabet.put(letter - 'a', letter);
        }

        HashMap<Integer, Character> capitalAlphabet = new HashMap<>();
        for (char letter = 'A'; letter <= 'Z'; letter++) {
            capitalAlphabet.put(letter - 'A', letter);
        }

        String[] chars = {"@", "/", "!", "#", "%", "&"};

        StringBuilder stringBuilder = new StringBuilder();






        for (int i = 0; i < password_length; i++){
            int char_pos = new Random().nextInt(26);
            stringBuilder.append(alphabet.get(char_pos));
        }

        int counter = 0;
        char capitalLetter = 0;
        int num = 0;
        String specialChar = "";

        if (number_check) {

            counter += 1;
            num = new Random().nextInt(10);
        }

        if (capitalLetter_check) {

            counter += 1;
            int char_pos = new Random().nextInt(26);
            capitalLetter = capitalAlphabet.get(char_pos);
        }

        if (specialChar_check) {

            counter += 1;
            int char_pos = new Random().nextInt(chars.length);
            specialChar = chars[char_pos];
        }

        stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - counter));

        if (number_check) {
            stringBuilder.insert(new Random().nextInt(stringBuilder.length()), num);
        }
        if (capitalLetter_check) {
            stringBuilder.insert(new Random().nextInt(stringBuilder.length()), capitalLetter);
        }
        if (specialChar_check) {
            stringBuilder.insert(new Random().nextInt(stringBuilder.length()), specialChar);
        }

        this.password = stringBuilder.toString();

    }




}
