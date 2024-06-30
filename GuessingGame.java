import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int round = 1;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("Round " + round + ":");
            System.out.println("Guess the number between 1 and 100. You have 10 attempts.");

            while (attempts < 10 && !correctGuess) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    totalScore += 10 - attempts + 1;  // Higher score for fewer attempts
                    correctGuess = true;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
            round++;
        }

        System.out.println("Game Over. Your total score is: " + totalScore);
        scanner.close();
    }
}
