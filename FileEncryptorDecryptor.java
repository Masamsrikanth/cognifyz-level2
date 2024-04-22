import java.io.*;
import java.util.Scanner;

public class FileEncryptorDecryptor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.println("Enter the file name or path:");
        String fileName = scanner.nextLine();
        
        if (choice == 1) {
            encryptFile(fileName);
        } else if (choice == 2) {
            decryptFile(fileName);
        } else {
            System.out.println("Invalid choice. Please choose 1 for encryption or 2 for decryption.");
        }
    }
    
    private static void encryptFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted_" + fileName))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                // Perform simple encryption by shifting characters by 1
                char encryptedChar = (char) (ch + 1);
                writer.write(encryptedChar);
            }
            System.out.println("Encryption complete. Encrypted file saved as encrypted_" + fileName);
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
    
    private static void decryptFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("decrypted_" + fileName))) {
            int ch;
            while ((ch = reader.read()) != -1) {
                // Perform decryption by shifting characters back by 1
                char decryptedChar = (char) (ch - 1);
                writer.write(decryptedChar);
            }
            System.out.println("Decryption complete. Decrypted file saved as decrypted_" + fileName);
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
}
