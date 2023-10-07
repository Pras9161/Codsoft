import java.util.Scanner;
import java.lang.Math;

public class task1 {
    public static void main(String[] args) {

        int answer = (int) (Math.random() * 100) + 1;

        int k = 5;

        Scanner inp = new Scanner(System.in);

        boolean correct = false;
        System.out.println("Think no between 1 to 100 .\nYou have 5 tries to guess the number.");
        while (k > 0) {
            System.out.println("Enter your guess: ");
            int guess = inp.nextInt();

            if (guess == answer) {
                System.out.println("You guessed the number!\nYou win!");
                break;
            }

            else if (guess > answer) {
                System.out.println("Your guess is too high.\nYou have" + (k - 1) + " tries left.");
                k--;
            }

            else {
                System.out.println("Your guess is too low.\nYou have" + (k - 1) + " tries left.");
                k--;
            }

        }

        if (correct == false) {
            System.out.println("Your tries has Ended . \nYou lose!");
        }
    }
}