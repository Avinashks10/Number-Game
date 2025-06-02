import java.util.Random;
import java.util.Scanner;
 
class Game{
    public int Computer_input;
    public int User_input;
    private Scanner input;

    public Game() {
        Random rand=new Random();
        Computer_input = rand.nextInt(100) + 1;
        input = new Scanner(System.in);
    }
    public void takeUserInput(){
        System.out.println("Enter the Number You Guessed :");
        User_input=input.nextInt();
    }
    boolean isCorrectNumber(){
        if(User_input==Computer_input){
            System.out.println("Congrats!!!You Guessed the Correct Number..");
            return true;
        }
        else if(User_input<Computer_input){
            System.out.println("Your Number is Less than the Computer Number...");
        }
        else if (User_input>Computer_input){
            System.out.println("Your Number is Greater than the Computer Number ...");
        }
        return false;
    }
}    
public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;
        int totalScore = 0;
        int roundsWon = 0;
        int roundNumber = 0;

        while (playAgain) {
            roundNumber++;
        Game g=new Game();
            boolean isGuessed = false;
            int attempts = 0;
            int maxChances = 10;

            System.out.println("\nRound " + roundNumber + ": Guess the number between 0 and 100.");

            while(!isGuessed && attempts < maxChances) {
                System.out.println("Chance " + (attempts + 1) + " of " + maxChances);
                g.takeUserInput();
                isGuessed = g.isCorrectNumber();
                attempts++;
            }
                if (isGuessed) {
                    roundsWon++;
                    int roundScore = 10;
                    if (attempts <= 5) {
                        roundScore += 5;
                    }
                    totalScore += roundScore;
                    System.out.println("You Won in " + attempts + " attempts! ");
                    System.out.println("Round Score: " + roundScore);
                } else {
                    System.out.println("Sorry! You Failed. The correct number was: " + g.Computer_input);
                }
                System.out.print("Do you want to play another round? (yes/no): ");
                String response = sc.nextLine().toLowerCase();
                playAgain = response.equals("yes") || response.equals("y");
            }
            System.out.println("\nGame Summary:");
            System.out.println("Rounds Won: " + roundsWon);
            System.out.println("Total Score: " + totalScore);
            System.out.println("Thank you for playing!");
            sc.close();
    }
}
