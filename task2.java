import java.util.Scanner;

public class task2 {
    public task2() {
    }

    public static void main(String[] var0) {
        System.out.println("1 Ruppe");
        System.out.println("2 Dollar");
        System.out.println("3 Euro");
        Scanner var1 = new Scanner(System.in);
        System.out.println("Choose the currency");
        int var2 = var1.nextInt();
        System.out.println("Enter the amount");
        double var3 = var1.nextDouble();
        switch (var2) {
            case 1:
                Ruppe_to_other(var3);
                break;
            case 2:
                Dollar_to_other(var3);
                break;
            case 3:
                Euro_to_other(var3);
                break;
            default:
                System.out.println("Invalid choice");
        }

    }

    public static void Ruppe_to_other(double var0) {
        System.out.println("1 Ruppe Exchange Rate = 0.013 Dollar");
        System.out.println();
        System.out.println("" + var0 + " Ruppe = " + var0 * 0.013 + " Dollar");
        System.out.println();
        System.out.println("1 Ruppe Exchange Rate  = 0.012 Euro");
        System.out.println();
        System.out.println("" + var0 + " Ruppe = " + var0 * 0.012 + " Euro");
        System.out.println();
    }

    public static void Dollar_to_other(double var0) {
        System.out.println("1 Dollar Exchange Rate  = 79.37 Ruppe");
        System.out.println();
        System.out.println("" + var0 + " Dollar = " + var0 * 79.37 + " Ruppe");
        System.out.println();
        System.out.println("1 Dollar Exchange Rate = 0.98 Euro ");
        System.out.println();
        System.out.println("" + var0 + " Dollar = " + var0 * 0.98 + " Euro");
    }

    public static void Euro_to_other(double var0) {
        System.out.println("1 Euro  Exchange Rate = 80.85 Ruppe");
        System.out.println();
        System.out.println("" + var0 + " Euro = " + var0 * 80.85 + " Ruppe");
        System.out.println();
        System.out.println("1 Euro Exchange Rate = 1.02 Dollar");
        System.out.println();
        System.out.println("" + var0 + " Euro = " + var0 * 1.02 + " Dollar");
    }
}
