/*
 * This class represents my 3 versions of Number Guessing Game
 * 
 * @author Mykhailo Kosenko
 * @version 11/27/2022
 */
import java.util.Scanner;

public class Game{
    //FIELDS
    private static int number;
    private static int numTen;
    private static int input;
    private static int wins = 0;
    private static int looses = 0;
    /*
     * This method generates winning numbers.
     */
    public static void generate(){
        number = (int)((Math.random() * 999) + 1);
        numTen = (int)((Math.random() * 9) + 1);
    }
    /*
     * This method represents first type of game - the Game Of Thousand
     */
    public static void gameOfThousand(){
        Scanner kboard = new Scanner(System.in);
        System.out.println("Welcome to the thousand game!");
        System.out.println("Here you have to guess a random number from 1 to 1000!");
        System.out.println("You have infinite amount of try.");
        generate();
        do{
            System.out.println("Enter your integer to guess: ");
            input = kboard.nextInt();
            if(input == number){
                System.out.println("Congratulations!You win!");
                System.out.println("Your amounts of tries was: " + looses);
            } else if(input > number){
                System.out.println("No.The number is less");
                looses++;
            } else {
                System.out.println("No.The number is bigger");
                looses++;
            }
        }while(input != number);
    }
    /*
     * This method represents second type of game - the Championship
     */
    public static void championship(){
        Scanner kboard = new Scanner(System.in);
        System.out.println("Welcome to the championship!");
        System.out.println("Here you have to guess a random number from 1 to 10!");
        System.out.println("You have 2 try.Round go 5 games.Whole game lasts 3 rounds!");
        generate();
        int pointsWin = 0;
        int pointsLos = 0;
        for(int i = 3;i > 0;i--){
            for(int k = 5;k > 0;k--){
                for(int j = 2;j > 0;j--){
                    System.out.println("Enter your integer to guess: ");
                    input = kboard.nextInt();
                    if(input == numTen){
                        System.out.println("Congratulations!You win!");
                        wins++;
                        if(k != 1){
                            System.out.println("New game!");
                        }
                        break;
                    } else if(input > numTen){
                        System.out.println("No.The number is less");
                        if(j == 1){
                            System.out.println("The number was: " + numTen);
                        }
                    } else {
                        System.out.println("No.The number is bigger");
                        if(j == 1){
                            System.out.println("The number was: " + numTen);
                        }
                    }
                    if(j == 1){
                        looses++;
                        if(k != 1){
                            System.out.println("New game!");
                        }
                    }
                }
                if(k == 1){
                    System.out.println("The end of the round!Your score is: " + 
                    "\nWins = " + wins +
                    "\nLooses = " + looses);
                    if(wins > looses){
                        System.out.println("You have won this round!");
                        pointsWin++;
                    } else {
                        System.out.println("You have loose this round!");
                        pointsLos++;
                    }
                    wins = 0;
                    looses = 0;
                    if(i != 1){
                        System.out.println("New round!");
                    }
                }
                generate();
            }
            if(i == 1){
                System.out.println("It is the end of this tournament!");
                System.out.println("Your wins: " + pointsWin + 
                                   "\nYour looses: " + pointsLos);
                if(pointsWin > pointsLos){
                    System.out.println("Congratulations!You are the champion!");
                } else {
                    System.out.println("Oh no!You loose!");
                }
            }
        }
    }
    /*
     * This class represents third type of game - the Infinite Game
     */
    public static void infiniteGame(){
        Scanner kboard = new Scanner(System.in);
        System.out.println("Welcome to the infinite game!");
        System.out.println("Here you have to guess a random number from 1 to 10!");
        System.out.println("You have 1 try per game.Round go 1 game.Whole game can lasts infinite times!");
        System.out.println("You will win if number of victories will be more than 5 and " + 
                           "\nnumber of looses will exceed number of victories not more than 5.");
        System.out.println("And loose if number of looses exceed number of wins on 10.");
        while(true){
            generate();
            System.out.println("Enter your integer to guess: ");
            input = kboard.nextInt();
            if(input == numTen){
                System.out.println("Congratulations!You just earned a point!");
                wins++;
                System.out.println("Your score is: " + 
                                   "\nWins: " + wins +
                                   "\nLooses: " + looses);
                generate();
            } else {
                looses++;
                System.out.println("You loose.The number was: " + numTen);
                System.out.println("Your score is: " + 
                                   "\nWins: " + wins +
                                   "\nLooses: " + looses);
                generate();
            }
            if(wins > 5 && looses - wins < 6){
                System.out.println("Congratulations!You won!");
                break;
            }
            if(looses - wins > 9){
                System.out.println("You loose!");
                break;
            }
        }
    }
    /*
     * This class gives more information about games
     */
    public static void information(){
        System.out.println("We have 3 types of number guessing game!");
        System.out.println("1.First type of game is called the Game Of Thousand!" + 
                           "\nIn this game you have to guess a rundom number from 1 to 1000." + 
                           "\nYou have infinite tries.");
        System.out.println("2.In second type of game you will have 3 rounds, every for 5 games." +
                           "\nIn each game you have 2 tries.This game is called the Championship!");
        System.out.println("3.Third type of game is called the Infinite Game!This game can lasts forever." +
                           "\nYou have infinite games and 1 try each game." +
                           "\nIf number of looses will exceed number of wins in 10, you will loose." +
                           "\nIf number of wins will be at least 5 and number of looses will not exceed wins more tha 5, you will win!");
        System.out.println("Good luck!");
    }
    /*
     * main method that will terminate till input is not 5
     */
    public static void main(String[] args){
        Scanner kboard = new Scanner(System.in);
        System.out.println("Welcome to the Game!");
        while(true){
            wins = 0;//assign wins and looses to zeros for new games
            looses = 0;
            System.out.println("Enter the number of game you want to play: ");
            System.out.println("1.Game Of Thousand" +
                               "\n2.Championship" +
                               "\n3.Infinite Game" +
                               "\n4.Get more information about this games" + 
                               "\n5.Quit");
            input = kboard.nextInt();
            if(input == 5){
                break;
            } else if(input == 1){
                gameOfThousand();
            } else if(input == 2){
                championship();
            } else if(input == 3){
                infiniteGame();
            } else {
                information();
            }
        }
    }
}