import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose language/Välj språk: (1) English (2) Svenska");

        String languageChoice;
        do {
            languageChoice = scanner.nextLine();
        } while (!languageChoice.equals("1") && !languageChoice.equals("2"));

        boolean isEnglish = languageChoice.equals("1");

        while (true) {
            playGame(isEnglish);
            String playAgain = isEnglish ? "Do you want to play again? (yes/no)" : "Vill du spela igen?";
            System.out.println(playAgain);
            String playAgainInput = scanner.nextLine().toLowerCase();
            if (!playAgainInput.equals("yes") && !playAgainInput.equals("ja")) {
                break;
            }
        }
    }

    public static void playGame(boolean isEnglish){
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        String welcomeMessage = isEnglish ? "Welcome to the Number Guessing Game!" : "Välkommen till nummergissningsspelet!";
        String guessMessage = isEnglish ? "Try to guess a number between 0 and 10." : "Försök att gissa ett nummer mellan 0 och 10.";

        System.out.println(welcomeMessage);
        System.out.println(guessMessage);

        int rand_int1 = rand.nextInt(11); // För att inkludera 10 i intervallet
        int guess = 0;
        int counter = 0;

        while (guess != rand_int1) {
            try {
                guess = scanner.nextInt();
                counter++;

                if (guess > rand_int1) {
                    System.out.print(isEnglish ? "Guess lower: " : "Gissa lägre: ");
                } else if (guess < rand_int1) {
                    System.out.print(isEnglish ? "Guess higher: " : "Gissa högre: ");
                } else {
                    String congratsMessage = isEnglish ? "Congratulations! You guessed it right. The number was %d. It took you %d guesses." : "Grattis! Du gissade rätt. Numret var %d. Det tog dig %d gissningar.";
                    System.out.println(String.format(congratsMessage, rand_int1, counter));
                }
            } catch (InputMismatchException e){
                String errorMessage = isEnglish ? "Please enter a valid integer." : "Ange ett giltigt heltal.";
                System.out.println(errorMessage);
                scanner.nextLine(); // Rensa inmatningsbufferten
            }
        }
    }
}
