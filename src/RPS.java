/**
 * Lab 4 Rock, Paper, Scissors GUI
 * Jayden LaCombe and Lance Hoffpauer
 * 1/25/2022
 */

import javax.swing.*;
import java.util.Random;

public class RPS {

    public static void main(String[] args) {

        // Step 1 - Introduction

        ImageIcon introIcon = new ImageIcon("Images/RPS_Intro.png");
        ImageIcon choiceIcon = new ImageIcon("Images/RPS_Blue.png");
        ImageIcon sbpIcon = new ImageIcon("Images/SBP.jpg");
        ImageIcon pbrIcon = new ImageIcon("Images/PBR.jpg");
        ImageIcon rbsIcon = new ImageIcon("Images/RBS.jpg");
        ImageIcon quitIcon = new ImageIcon("Images/gameOver.jpg");
        String introPrompt = "<html><h1>Rock, Paper, Scissors</h1>";

        String[] playButton = {"Play"};

        int play = JOptionPane.showOptionDialog(null, introPrompt,
                "Rock, Paper, Scissors                             J.LaCombe and L. Hoffpauer",
                0, 0, introIcon, playButton, playButton[0]);

        if (play != 0) System.exit(0);

        // Step 2 - Start Repeat

        int computerPoints = 0;
        int playerPoints = 0;

        while (computerPoints <= 3 || playerPoints <= 3) {

            // Step 3 - Enter Player Choice of Rock Paper or Scissors

            String decisionPrompt = "<html>Please click on one of<br>" + "The following buttons,<br>" + "Corresponding to your play<br>";
            String[] choices = {"Rock", "Paper", "Scissors"};

            int choice = JOptionPane.showOptionDialog(null, decisionPrompt,
                    "Rock, Paper, Scissors                             J.LaCombe and L. Hoffpauer",
                    0, 0, choiceIcon, choices, choices[0]);

            if (choice == -1) System.exit(0);

            String playerChoice = "";
            String computerChoice = "";

            // Step 4 - Translate Player Choice

            switch (choice) {
                case 2 -> playerChoice = "Scissors";
                case 1 -> playerChoice = "Paper";
                case 0 -> playerChoice = "Rock";
            }


            // Step 5 - Generate Computers Play


            Random rand = new Random();
            int computerMove = rand.nextInt(3);

            // Step 6 - Translate Computers Choice

            switch (computerMove) {
                case 2 -> computerChoice = "Scissors";
                case 1 -> computerChoice = "Paper";
                case 0 -> computerChoice = "Rock";
            }

            // Step 7 - Determine Winner for this Round and Adjust Score

            String decisions = "<html>You played : " + playerChoice + "<br>" +
                    "Computer Played : " + computerChoice + "<br>";

            String computerWin = "The Computer Won and has Earned a Point.";
            String playerWin = "You Beat the Computer and Have Earned a Point!";
            String sBp = "<h1>Scissor Cut Paper!</h1>";
            String rBs = "<h1>Rock Crushes Scissors!</h1>";
            String pBr = "<h1>Paper Wraps Rock!</h1>";

            String rock = "Rock";
            String paper = "Paper";
            String scissor = "Scissors";

            ImageIcon tieIcon = new ImageIcon("Images/tieGame.jpg");

            int xButton = 0;

            //If Statements

            if (computerChoice.equals(playerChoice)) {


                String tie = "<h2>Result is a Tie! <br>" + "No Point</h2>";
                String tiePrompt = decisions + tie;


                JOptionPane.showMessageDialog(null, tiePrompt,
                        "Rock, Paper, Scissors                           J.LaCombe and L. Hoffpauer",
                        0, tieIcon);


            } else if (computerChoice.equals(scissor) && playerChoice.equals(paper)) {

                String comBeatsPlayerSBP = decisions;
                comBeatsPlayerSBP += computerWin;
                comBeatsPlayerSBP += sBp;

                JOptionPane.showMessageDialog(null, comBeatsPlayerSBP,
                        "Rock, Paper, Scissors                             J.LaCombe and L. Hoffpauer",
                        0, sbpIcon);

                computerPoints += 1;


            } else if (computerChoice.equals(paper) && playerChoice.equals(rock)) {

                String comBeatsPlayerPBR = decisions;
                comBeatsPlayerPBR += computerWin;
                comBeatsPlayerPBR += pBr;

                JOptionPane.showMessageDialog(null, comBeatsPlayerPBR,
                        "Rock, Paper, Scissors                      " +
                                "                           J.LaCombe and L. Hoffpauer",
                        0, pbrIcon);

                computerPoints += 1;


            } else if (computerChoice.equals(rock) && playerChoice.equals(scissor)) {

                String comBeatsPlayerRBS = decisions;
                comBeatsPlayerRBS += computerWin;
                comBeatsPlayerRBS += rBs;

                JOptionPane.showMessageDialog(null, comBeatsPlayerRBS,
                        "Rock, Paper, Scissors                      " +
                                "                 J.LaCombe and L. Hoffpauer",
                        0, rbsIcon);

                computerPoints += 1;


            } else if (computerChoice.equals(paper) && playerChoice.equals(scissor)) {

                String playerBeatsComSBP = decisions;
                playerBeatsComSBP += playerWin;
                playerBeatsComSBP += sBp;

                JOptionPane.showMessageDialog(null, playerBeatsComSBP,
                        "Rock, Paper, Scissors                             J.LaCombe and L. Hoffpauer",
                        0, sbpIcon);

                playerPoints += 1;


            } else if (computerChoice.equals(rock) && playerChoice.equals(paper)) {

                String playerBeatsComPBR = decisions;
                playerBeatsComPBR += playerWin;
                playerBeatsComPBR += pBr;

                JOptionPane.showMessageDialog(null, playerBeatsComPBR,
                        "Rock, Paper, Scissors                             J.LaCombe and L. Hoffpauer",
                        0, pbrIcon);

                playerPoints += 1;


            } else if (computerChoice.equals(scissor) && playerChoice.equals(rock)) {

                String playerBeatsComRBS = decisions + playerWin + rBs;


                JOptionPane.showMessageDialog(null, playerBeatsComRBS,
                        "Rock, Paper, Scissors                             J.LaCombe and L. Hoffpauer",
                        0, rbsIcon);

                playerPoints += 1;

            }

            String winner = "";

            if (playerPoints == 3) {
                winner = "P";
            } else if (computerPoints == 3) {
                winner = "C";
            }

            String finalScore = "<html><p>Your Score: " + playerPoints + "<br>"
                    + "Computer Score: " + computerPoints + "</p>";

            String[] quitGame = {"Quit Game"};

            if (winner.equals("P")) {

                String playerWinsGame = finalScore + "<h1>You Won!</h1>" + "<p>Please click the \"Quit Game\" button to end the game.</p>";
                playerWinsGame += "<h1>Thanks For Playing!<h1>";

                JOptionPane.showOptionDialog(null, playerWinsGame,
                        "Rock, Paper, Scissors                             J.LaCombe and L. Hoffpauer",
                        0, 0, quitIcon, quitGame, quitGame[0]);

                System.exit(1);

            } else if (winner.equals("C")) {

                String comWinsGame = finalScore + "<h1>You lost :(  </h1>" +
                        "<p>Please click the \"Quit Game\" button to end the game  <br>" +
                        "Thanks For Playing! Better Luck Next Time!  <br></p>";


                JOptionPane.showOptionDialog(null, comWinsGame,
                        "Rock, Paper, Scissors                             J.LaCombe and L. Hoffpauer",
                        0, 0, quitIcon, quitGame, quitGame[0]);
                System.exit(1);
            }

        }

    }

}

