import java.util.Scanner;
public class CurrencyConverter {
    public static void main(String[] args) {
        double usdToInrRate = 73.5;
        double usdToEuroRate = 0.85; 
        Scanner scanner = new Scanner(System.in);
        String baseCurrency = "USD";

        System.out.println("Choose target currency:");
        System.out.println("1. Indian Rupees (INR)");
        System.out.println("2. Euro (EUR)");
        System.out.print("Enter your choice (1 or 2): ");
        
        int choice = scanner.nextInt();
        double exchangeRate = 0.0;
        String targetCurrency = "";

        if (choice == 1) {
            exchangeRate = usdToInrRate;
            targetCurrency = "INR";
        } else if (choice == 2) {
            exchangeRate = usdToEuroRate;
            targetCurrency = "EUR";
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.print("Enter the amount in USD: ");
        double amountInUSD = scanner.nextDouble();
        double convertedAmount = amountInUSD * exchangeRate;
        System.out.println(amountInUSD + " USD is equal to " + convertedAmount + " " + targetCurrency);
        scanner.close();
    }
}