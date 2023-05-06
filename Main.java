import java.util.Scanner;
import java.util.Random;

class Game
{
    int computerNo;
    int myNumber;
    int attempts = 0;
    
    public Game()
    {
        Random r = new Random();
        computerNo = r.nextInt(100);

        System.out.println("Welcome to Guess the Number Game");
        System.out.println("You have to guess a no greater than 0 and lesser than 100");
    }

    public void guessedNo(int n)
    {
        myNumber = n;
    }

    public int iscorrect()
    {
        if(computerNo == myNumber) return 0;
        else if(computerNo > myNumber) return 1; //less than computer no
        else if(computerNo < myNumber) return -1;//greater than computer no
        else return 2; //other than 0-100
    }

    public void attemptsCount()
    {
        attempts++;
    }

    public int noOfAttempts()
    {
        return attempts;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game ajmat = new Game();

        //Taking entry from the user
        int choice;
        System.out.println("Enter your Number!");
        choice = sc.nextInt();

        //passing the guessed no into the class
        ajmat.guessedNo(choice);
        ajmat.attemptsCount();
        
        while(true)
        {

            if(ajmat.iscorrect() == 0)
            {
                int attempt = ajmat.noOfAttempts();
                System.out.println("Congratulations! You guessed the correct Number");
                System.out.println("Your No of Attempts are: " + attempt);
                break;
            }

            else if(ajmat.iscorrect() == 1)
            {
                System.out.println("Please Enter a Greater Number");
                choice = sc.nextInt();
                ajmat.guessedNo(choice);
                ajmat.attemptsCount();
            }

            else if(ajmat.iscorrect() == -1)
            {
                System.out.println("Please Enter a Lesser Number");
                choice = sc.nextInt();
                ajmat.guessedNo(choice);
                ajmat.attemptsCount();
            }

            else
            {
                System.out.println("Please Enter a Valid Number Between 0 and 100");
                choice = sc.nextInt();
                ajmat.guessedNo(choice);
                ajmat.attemptsCount();
            }
        }
        sc.close();
        System.out.println("Game Ends!");
    }
}
