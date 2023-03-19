import javax.swing.*;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int maxNumber = 100;
        int numberToGuess = rand.nextInt(maxNumber) + 1;
        int numberOfGuesses = 0;
        int maxGuesses = 10;
        boolean win = false;
        int score = 0;

        for (int i = 1; i <= 3; i++) { // play 3 rounds
            numberOfGuesses = 0;
            win = false;
            numberToGuess = rand.nextInt(maxNumber) + 1;

            while (numberOfGuesses < maxGuesses && !win) {
                String guessString = JOptionPane.showInputDialog("Guess a number between 1 and " + maxNumber + ":");
                int guess = Integer.parseInt(guessString);
                numberOfGuesses++;

                if (guess == numberToGuess) {
                    win = true;
                    int roundScore = 100 / numberOfGuesses; // calculate score based on the number of attempts
                    score += roundScore; // add the score to the total score
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + numberOfGuesses + " tries. Your score for this round is " + roundScore + ".");
                } else if (guess < numberToGuess) {
                    JOptionPane.showMessageDialog(null, "Your guess is too low. Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Your guess is too high. Try again.");
                }
            }

            if (!win) {
                JOptionPane.showMessageDialog(null, "Sorry, you did not guess the number. The number was " + numberToGuess + ".");
            }
        }

        JOptionPane.showMessageDialog(null, "Game over! Your total score is " + score + ".");
    }
}
