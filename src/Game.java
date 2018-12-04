import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.util.concurrent.TimeUnit;


public class Game {

    JButton[] tiles = new JButton[9];
    boolean isTileTaken[] = new boolean[]{false, false, false, false, false, false, false, false, false};
    JFrame boardFrame;
    int tileXPos = 0;
    int tileYPos = 0;
    EventHandler handler = new EventHandler();
    String buttonText = "X";
    Font buttonFont = new Font("Arial", Font.PLAIN, 80);
    boolean isGameFinished = false;
    String winner = "";


    public Game()
    {
        createBoard();
    }


    public void createBoard() {
        boardFrame = new JFrame("Game");
        boardFrame.setSize(608, 660);
        boardFrame.setLayout(null);
        boardFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        boardFrame.setLocation(500, 300);
        boardFrame.setBackground(Color.BLACK);


        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new JButton();
            tiles[i].setSize(200, 200);
            tiles[i].setLocation(tileXPos, tileYPos);
            tiles[i].setFont(buttonFont);
            tileXPos = tileXPos + 200;

            if (tileXPos > 400) {
                tileXPos = 0;
                tileYPos = tileYPos + 200;
            }

            tiles[i].addActionListener(handler);
            boardFrame.add(tiles[i]);
        }

        boardFrame.setVisible(true);
    }

    private class EventHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < tiles.length; i++) {
                if (e.getSource() == tiles[i] && isTileTaken[i] == false) {
                    tiles[i].setText(buttonText);
                    buttonText = "O";
                    isTileTaken[i] = true;
                    checkForWinner();
                    if (winner.equals("")) {
                        computerTurn();
                        checkForWinner();
                    }
                } else if (isTileTaken[i] == true && e.getSource() == tiles[i]) {
                    JOptionPane.showMessageDialog(null, "Tile is taken. You fool!");
                }
            }

        }
    }

    public void computerTurn() {
        int max = 8;
        int min = 0;
        int number = (int) (Math.random() * ((max - min) + 1)) + min;
        // int min=0, max=8;


        while (isTileTaken[number] == true) {
            number = (int) (Math.random() * ((max - min) + 1)) + min;
        }

        //Number is selected now print on the tile

       /* try{
            TimeUnit.SECONDS.sleep(3);
        }
        catch (Exception e)
        {
            System.out.print("Error");
        }*/

        tiles[number].setText(buttonText);
        isTileTaken[number] = true;
        buttonText = "X";



    }//end of computer turn

    public void checkForWinner() {
        //JB - created else-if here for efficiency and deal with "no winner" scenario

        //Horizontal wins for X
        if (tiles[0].getText().equals("X") && tiles[1].getText().equals("X") && tiles[2].getText().equals("X")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player One Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        } else if (tiles[3].getText().equals("X") && tiles[4].getText().equals("X") && tiles[5].getText().equals("X")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player One Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        } else if (tiles[6].getText().equals("X") && tiles[7].getText().equals("X") && tiles[8].getText().equals("X")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player One Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        }

        //vertical wins for x
        else if (tiles[0].getText().equals("X") && tiles[3].getText().equals("X") && tiles[6].getText().equals("X")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player One Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        } else if (tiles[1].getText().equals("X") && tiles[4].getText().equals("X") && tiles[7].getText().equals("X")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player One Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        } else if (tiles[2].getText().equals("X") && tiles[5].getText().equals("X") && tiles[8].getText().equals("X")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player One Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        }

        //diagonal wins for x
        else if (tiles[0].getText().equals("X") && tiles[4].getText().equals("X") && tiles[8].getText().equals("X")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player One Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";
        } else if (tiles[6].getText().equals("X") && tiles[4].getText().equals("X") && tiles[2].getText().equals("X")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player One Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerTwo";

        }


        //Horizontal wins for O
        else if (tiles[0].getText().equals("O") && tiles[1].getText().equals("O") && tiles[2].getText().equals("O")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player Two Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        } else if (tiles[3].getText().equals("O") && tiles[4].getText().equals("O") && tiles[5].getText().equals("O")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player Two Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        } else if (tiles[6].getText().equals("O") && tiles[7].getText().equals("O") && tiles[8].getText().equals("O")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player Two Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);

            winner = "playerOne";
        }

        //vertical wins for O
        else if (tiles[0].getText().equals("O") && tiles[3].getText().equals("O") && tiles[6].getText().equals("O")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player Two Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        } else if (tiles[1].getText().equals("O") && tiles[4].getText().equals("O") && tiles[7].getText().equals("O")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player Two Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        } else if (tiles[2].getText().equals("O") && tiles[5].getText().equals("O") && tiles[8].getText().equals("O")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player Two Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        }

        //diagonal wins for O
        else if (tiles[0].getText().equals("O") && tiles[4].getText().equals("O") && tiles[8].getText().equals("O")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player Two Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        } else if (tiles[6].getText().equals("O") && tiles[4].getText().equals("O") && tiles[2].getText().equals("O")) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Player Two Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "playerOne";

        } else if (isTileTaken[0] == true && isTileTaken[1] == true && isTileTaken[2] == true
                && isTileTaken[3] == true && isTileTaken[4] == true && isTileTaken[5] == true
                && isTileTaken[6] == true && isTileTaken[7] == true && isTileTaken[8] == true) {
            isGameFinished = true;
            JOptionPane.showMessageDialog(null, "Neither Player Wins", "End of Game", JOptionPane.INFORMATION_MESSAGE);
            winner = "na";
        }

    }//end of check for winner

    public void computerGame()
    {
        while(!isGameFinished)
        {
            buttonText = "X";

            computerTurn();

            checkForWinner();

            try
            {
                Thread.sleep(1500);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }

            buttonText = "O";

            computerTurn();

            checkForWinner();

            try
            {
                Thread.sleep(1500);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}//end of game
