import java.util.*;

public class Task_4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password length:");
        int len = sc.nextInt();
        System.out.println("Include Number?(yes/no): ");
        boolean IncludeNumber = sc.next().equalsIgnoreCase("Yes");
        System.out.println("Include lower letter?(yes/no): ");
        boolean IncludeLower = sc.next().equalsIgnoreCase("Yes");
        System.out.println("Include upper letter?(yes/no): ");
        boolean IncludeUpper = sc.next().equalsIgnoreCase("Yes");
        System.out.println("Include special characters?(yes/no): ");
        boolean IncludeSpecial = sc.next().equalsIgnoreCase("Yes");
        String password = generatePassword(len, IncludeNumber, IncludeLower, IncludeUpper, IncludeSpecial);
        System.out.println("Geneted password: " + password);
        sc.close();
    }

    // methods
    public static String generatePassword(int len, boolean includeNumbers, boolean includeLower, boolean includeUpper,
            boolean includeSpecial) {
        String numbers = "0123456789";
        String lowerCase = "abcdefghijklmopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMOPQRSTUVWXYZ";
        String specialChars = "!@#$%^&*()_+=<>:.,;?/";
        String allowedChars = "";
        if (includeNumbers)
            allowedChars += numbers;
        if (includeLower)
            allowedChars += lowerCase;
        if (includeUpper)
            allowedChars += upperCase;
        if (includeSpecial)
            allowedChars += specialChars;
        if (allowedChars.isEmpty()) {
            return "No Character types selected";
        }
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int index = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(index));
        }
        return password.toString();
    }

}
