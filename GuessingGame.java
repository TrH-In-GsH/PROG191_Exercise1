package fgw;
import java.util.Scanner;
public class GuessingGame {
    public static void main(String[] args) {
        guessingGame();
    }

    public static void guessingGame() {
        Scanner sc = new Scanner(System.in);

        //  Given number ranges, number of trials
        int max = 0, min = 0, K = 0;

        // The game should allow the player to specify the minimum and maximum range for the random number.
        // The number of attempts should be limited to a specified maximum value.
        System.out.println("<=====GUESSING GAME=====>");
        System.out.println("1. The number ranges from 1 to 10. You have 3 trial of guesses.");
        System.out.println("2. The number ranges from 1 to 100. You have 5 trial of guesses.");
        System.out.println("3. The number ranges from 1 to 1000. You have 8 trial of guesses.");
        System.out.println("\nChoose difficult level(1-3):");

        int level = sc.nextInt();
        while(level !=1 && level !=2 && level !=3){
            System.out.println("Input number from 1 to 3:");
             level = sc.nextInt();
             if (level ==1 || level ==2 || level ==3){
                 break;
             }
        }

        if (level==1){
             max = 10;
             min = 1;
             K = 3;
        }
        else if (level==2) {
             max = 100;
             min = 1;
             K = 5;
        }
        else if (level==3) {
             max = 1000;
             min = 1;
             K = 8;
        }

        //  Generate a random number between a specified minimum and maximum value
        int number = 1 + (int) ((max-min+1) * Math.random());

        int i, guess;

        //  Prompt the player to enter their guess.
        System.out.println(String.format("A number is chosen between %d to %d. Guess the number within %d trials.", min, max, K));

        //Guessing loop
        for (i = 0; i < K; i++) {
            System.out.println("Your guess: ");

            // Take input for guessing
            guess = sc.nextInt();
            while(guess < min || guess > max){
                System.out.println(String.format("Please input a number ranged from %d to %d:", min, max));
                guess = sc.nextInt();
                if (guess < max && guess > min ){
                    break;
                }
            }
            /*
                Compare the player's guess with the randomly generated number.
                Provide feedback to the player, indicating whether their guess was too high, too low, or correct.
                Keep track of the number of attempts made by the player.
                If the player guesses the correct number, congratulate them and display the number of attempts it took.
             */
            if (number == guess) {
                System.out.println(String.format("Congratulations! You guessed the number correctly in %d turns.", (i + 1)));
                break;
            } else if (number > guess && i != K - 1) {
                System.out.println(String.format("The number is greater than %d. You have %d guesses left!", guess, (K - i - 1)));
            } else if (number < guess && i != K - 1) {
                System.out.println(String.format("The number is less than %d. You have %d guesses left!", guess, (K - i - 1)));
            }
        }

        //  If the player exhausts all their attempts without guessing the correct number, reveal the correct number and inform them that they have lost the game.
        if (i == K) {
            System.out.println(String.format("You have exhausted %d trials. The number was %d", K, number));
            System.out.println("<=====GAME OVER=====>");
        }
    }
}
//• Validate the input to ensure it is a valid integer within the specified range.  The game should handle invalid input gracefully and prompt the player for a valid input.