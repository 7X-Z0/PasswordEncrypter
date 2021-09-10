import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner UserInput = new Scanner(System.in);
        Main sw = new Main();
        String encryptionCode = String.valueOf(Main.encryptionString());
        System.out.println("Here is your public Encryption key: " + encryptionCode);
        String decryptorCode = String.valueOf(Main.decryptorString());
        System.out.println("Here is your Decryption key: " + decryptorCode);
        System.out.println("Welcome to password encryptor");
        Thread.sleep(1000);
        System.out.println("Code made by: 7X-Z0");
        Thread.sleep(1000);
        System.out.println("To encrypt password, please provide encryption key");
        String userEncryption = UserInput.nextLine();
        if (Objects.equals(userEncryption, encryptionCode)){
            System.out.println("Encryption key correct (" + encryptionCode + ")");
        } else {
            System.out.println("Encryption key incorrect\n" + "Please refer to an admin or company portal to receive key");
            System.out.println("Program terminated");
            System.exit(0);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n" + "Please input your password");
        String Input = UserInput.nextLine();
        Thread.sleep(100);
        String shuffled = sw.shuffle(Input);
        System.out.println("Password has been encrypted");
        System.out.println("Here is encrypted password: " + shuffled);
        Thread.sleep(100);
        System.out.println("Would you like to decrypt your password?\n" + "Yes   _   No");
        String continueCode = UserInput.nextLine();
        if (Objects.equals(continueCode, "Yes")){
            System.out.println("Please input decryption code");
            String userDecryptor = UserInput.nextLine();
            if (Objects.equals(userDecryptor, decryptorCode)){
                System.out.println("Your password is: " + Input);
            } else {
                System.out.println("Incorrect code, stealing passwords is a crime\nAdmin has been notified, program terminated");
            }
        } else {
            System.out.println("Thank you for using the program\n" + "Program ending.");
            System.exit(0);
        }
    }

    //Method 1 Scrambling (longer)

    //Method 1 uses the UserInput variable to add the password into a list
    //The program uses the list to randomly swap the letters in the list and adds them into a new list called "shuffledWord"
    //"shuffledWord" is then returned and shown to the user
    private String shuffle(String Input){
        String shuffledWord = Input;
        int wordSize = Input.length();
        int shuffleCount = 10;
        for(int i = 0; i < shuffleCount; i++){
            int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
            int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);
            shuffledWord = swapCharacters(shuffledWord,position1, position2);
        }
        return shuffledWord;
    }
    private String swapCharacters(String shuffledWord, int position1, int position2){
        char[] charArray = shuffledWord.toCharArray();
        char temp = charArray[position1];
        charArray[position1] = charArray[position2];
        charArray[position2] = temp;
        return new String(charArray);
    }

    //Method 2 Scrambling (Simpler)

    //Method 2 uses the StringBuilder function to generate a random encryption and decryption key
    //The function uses a list of characters A-Z and 0-9
    //The function also uses the Random import utility to choose random characters with the length specified in the code
    //Modifications can be made by changing the "decryptioncharacters" variable to the User's input to Scramble the word
    //Using the Input of the User's length, the length of the returned word, can be the same length as the User's Input.

    //Decryption Key generator
    public static StringBuilder decryptorString(){
        String decryptioncharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder decryptorCode = new StringBuilder();
        Random rnd = new Random();
        while (decryptorCode.length() < 6){
            int index = (int) (rnd.nextFloat() * decryptioncharacters.length());
            decryptorCode.append(decryptioncharacters.charAt(index));
        }
        return decryptorCode;
    }

    //Encryption key generator
    public static StringBuilder encryptionString(){
        String encryptionCharaters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder encryptionCode = new StringBuilder();
        Random rnd = new Random();
        while (encryptionCode.length() < 6){
            int index = (int) (rnd.nextFloat() * encryptionCharaters.length());
            encryptionCode.append(encryptionCharaters.charAt(index));
        }
        return encryptionCode;
    }
}
