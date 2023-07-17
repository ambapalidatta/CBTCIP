import java.util.Random;
import java.util.*;

public class Guess_Number
{
    public static void main(String[] args) {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; // Generates a random number between 1 and 100
        int attempts = 0;

        Scanner sc = new Scanner(System.in);
        int guess;

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I have selected a number between 1 and 100 (inclusive). Can you guess it?");
        System.out.println();

        while (true) {
            if(attempts > 10)
            {
                System.out.println("Sorry, the number of attempts exceeds!");
                break;
            }
            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++; // Keeps the count of attempts

            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
                System.out.println();
                break;
            } else if (guess < targetNumber) {
                System.out.println("Your guess is too low. Try again.");
                System.out.println();
            } else {
                System.out.println("Your guess is too high. Try again.");
                System.out.println();
            }
        }

        sc.close();
    }
}
    
