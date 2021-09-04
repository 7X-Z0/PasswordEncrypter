import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner UserInput = new Scanner(System.in);
        Main sw = new Main();
        String encryptionCode = String.valueOf(Main.encryptionString());
        System.out.println("Here is your public Encryption code: " + encryptionCode);
        String decryptorCode = String.valueOf(Main.decryptorString());
        System.out.println("Here is your Decryption code: " + decryptorCode);
        System.out.println("Welcome to password encryptor");
        Thread.sleep(1000);
        System.out.println("Code made by: 7X_Z0");
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
            System.exit(0);
        }
    }
    //Method 1 Scrambling
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
