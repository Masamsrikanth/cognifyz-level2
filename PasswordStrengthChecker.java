import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        
        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?`~].*");
        
        int strengthScore = calculateStrength(length, hasUppercase, hasLowercase, hasDigit, hasSpecialChar);
        String strengthDescription = getStrengthDescription(strengthScore);
        
        System.out.println("Password strength: " + strengthDescription);
    }
    
    private static int calculateStrength(int length, boolean hasUppercase, boolean hasLowercase, boolean hasDigit, boolean hasSpecialChar) {
        int strength = 0;
        
        // Length
        if (length >= 8 && length <= 12) {
            strength += 1;
        } else if (length > 12) {
            strength += 2;
        }
        
        // Uppercase
        if (hasUppercase) {
            strength += 1;
        }
        
        // Lowercase
        if (hasLowercase) {
            strength += 1;
        }
        
        // Digit
        if (hasDigit) {
            strength += 1;
        }
        
        // Special Character
        if (hasSpecialChar) {
            strength += 2;
        }
        
        return strength;
    }
    
    private static String getStrengthDescription(int strengthScore) {
        if (strengthScore <= 2) {
            return "Weak";
        } else if (strengthScore <= 4) {
            return "Moderate";
        } else if (strengthScore <= 6) {
            return "Strong";
        } else {
            return "Very Strong";
        }
    }
}
