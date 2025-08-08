import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;

public class LoginRedirect {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if(username.equals("AMRIT") && password.equals("2005")) {
            System.out.println("Login successful! Redirecting to Contineo portal...");
            System.out.println("Opening URL: https://sims.sit.ac.in/parents/index.php");
            openWebpage("https://sims.sit.ac.in/parents/index.php");
        }else {
            System.out.println("Invalid username or password.");
        }

        scanner.close();
    }

    public static void openWebpage(String url) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(new URI(url));
        } catch (Exception e) {
            System.out.println("Failed to open browser: " + e.getMessage());
        }
    }
}
