import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;  // Random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10;  // Maximum attempts per round
            boolean hasWon = false;

            System.out.println("Welcome to the Number Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !hasWon) {
                System.out.print("Enter your guess: ");
                int userGuess;
                try {
                    userGuess = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();  // Consume the invalid input
                    continue;
                }
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    hasWon = true;
                    score += (maxAttempts - attempts + 1);  // Higher score for fewer attempts
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == maxAttempts && !hasWon) {
                    System.out.println("You've used all your attempts. The correct number was: " + numberToGuess);
                }
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();

            while (!response.equals("yes") && !response.equals("no")) {
                System.out.print("Invalid response. Please enter 'yes' or 'no': ");
                response = scanner.next().toLowerCase();
            }

            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}