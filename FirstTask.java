import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int attemptsLeft = 10;
            int score = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nNew round started!");
            System.out.println("I have selected a number between 1 and 100. You have " + attemptsLeft + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess;

                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score = attemptsLeft * 10; // Example scoring: higher score for fewer attempts
                    totalScore += score;
                    break;
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }

                attemptsLeft--;
                System.out.println("Attempts remaining: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all your attempts! The correct number was: " + numberToGuess);
            }

            System.out.println("Your score this round: " + score);
            System.out.println("Total score: " + totalScore);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("Thank you for playing! Your total score is: " + totalScore);
        scanner.close();
    }
}