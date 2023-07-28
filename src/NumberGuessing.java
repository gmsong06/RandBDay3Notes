import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        int maxAttempts = 10;
        int attempts = 0;
        int guess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between 1 and 100. Can you guess it in " + maxAttempts + " attempts?");

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < targetNumber) {
                System.out.println("Try higher!");
            } else if (guess > targetNumber) {
                System.out.println("Try lower!");
            } else {
                System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                break;
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
        }

        scanner.close();
    }
}
