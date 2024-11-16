public class Main {
    public static void main(String[] args) {

        Password password = new Password();

        password.generatePassword();
        System.out.println(password.getPassword());


    }
}