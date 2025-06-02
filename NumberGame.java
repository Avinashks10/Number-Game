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
        Game g=new Game();
            boolean b=false;
            int attempts = 0;
            int maxChances = 10;

            while(!b && attempts < maxChances) {
                System.out.println("Chance " + (attempts + 1) + " of " + maxChances);
                g.takeUserInput();
                b = g.isCorrectNumber();
                attempts++;
            }
                if (b) {
                    System.out.println("You Won in " + attempts + " attempts!");
                } else {
                    System.out.println("Sorry!You Failed. The correct number was: " + g.Computer_input);
                }
        
        System.out.println("Game Over.Thank you for playing the game.");
    }
}