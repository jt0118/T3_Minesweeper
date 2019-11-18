import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardController {
    private boolean continueGame;
    private int rightSquares;
    private boolean hitMine;
    private JFrame mainFrame;
    private JPanel centerPanel;


    public BoardController(int rightSquares, JFrame mainFrame, JPanel centerPanel){
        continueGame = true;
        hitMine = false;
        this.rightSquares = rightSquares;
        this.mainFrame = mainFrame;
        this.centerPanel = centerPanel;
    }

    public void checkGame(){
        if(rightSquares == 0 || hitMine){
            mainFrame.dispose();
        }
    }

    public int getRightSquares(){
        return rightSquares;
    }

    public void setRightSquares(int updatedRight){
        this.rightSquares = updatedRight;
    }

    public boolean getContinueGame(){
        return continueGame;
    }

    public void setContinueGame(){
        continueGame = false;
    }
}
