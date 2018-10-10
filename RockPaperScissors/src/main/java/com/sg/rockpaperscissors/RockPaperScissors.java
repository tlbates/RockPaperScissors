/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tylerbates
 */
public class RockPaperScissors {

    public static void main(String[] args) {
        
        boolean playAgain = false;
        int userRound;

        do {
            System.out.println("Welcome to Rock, Paper, Scissors!");
            userRound = getUserRound();
            
            if (userRound > 10 || userRound < 1) {
                System.out.println("Wrong input for rounds.");
                break;
            }
            
            playGame(userRound);

            playAgain = userPlayAgain();
            /*System.out.println("Would you like to play again? (true/false)");
            playAgain = userInput.nextBoolean();*/

        } while (playAgain == true);
        
        System.out.println("Thanks for Playing!");

    }

    public static int getUserRound() {
        int round = 0;
        boolean trueNum = false;
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("How many rounds would you like to play? (1-10)");
        round = userInput.nextInt();
        
        return round;

    }

    public static void playGame(int roundNum) {

        Scanner userInput = new Scanner(System.in);
        Random random = new Random();

        int userAnswer, compAnswer;
        int userWins = 0;
        int compWins = 0;
        int ties = 0;

        for (int i = 1; i <= roundNum; i++) {
            do {
                System.out.println("Make a choice - Rock(1) - Paper(2) - Scissors(3)");
                userAnswer = userInput.nextInt();
                compAnswer = random.nextInt(3) + 1;
            } while (userAnswer > 3 || userAnswer < 1);

            if (compAnswer == 1 && userAnswer == 3) {
                compWins++;
                System.out.println("Computer wins this round!");
            } else if (userAnswer == 1 && compAnswer == 3) {
                userWins++;
                System.out.println("User wins this round!");
            } else if (userAnswer > compAnswer) {
                userWins++;
                System.out.println("User wins this round!");
            } else if (userAnswer < compAnswer) {
                compWins++;
                System.out.println("Computer wins this round!");
            } else if (userAnswer == compAnswer) {
                System.out.println("This round is a tie!");
                ties++;
            }

        }
        System.out.println("----------------------------------------");
        System.out.println("There were " + ties + "  ties during the game but...");

        if (userWins > compWins) {
            System.out.println("THE USER WINS!!");
            System.out.println("User win number: " + userWins);
            System.out.println("Computer win number: " + compWins);
        } else if (compWins > userWins) {
            System.out.println("THE COMPUTER WINS!!");
            System.out.println("Computer win number: " + compWins);
            System.out.println("User win number: " + userWins);
        } else {
            System.out.println("THE GAME IS A TIE!!");
            System.out.println("User win number: " + userWins);
            System.out.println("Computer win number: " + compWins);
        }

    }

    public static boolean userPlayAgain() {
        Scanner userInput = new Scanner(System.in);
        String choice;
        
        System.out.println("Would you like to play RPS again? (y)es or (n)o:");
        choice = userInput.nextLine();
        
        if ("yes".equalsIgnoreCase(choice)|| (choice != null
                && choice.toLowerCase().startsWith("y"))) {
            return true;
        } else {
            return false;
        }
    }
}
