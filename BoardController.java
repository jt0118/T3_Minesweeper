import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardController {

    public Boolean continueGame;
    public int rightSquares;
    private JFrame mainFrame;
    private JPanel mainPanel;

    public BoardController(JFrame mainFrame, JPanel mainPanel, int rightSquares){
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;
       continueGame = true;
       this.rightSquares = rightSquares;
    }

    public void check(){
        if(rightSquares == 0 || !continueGame){
            mainFrame.dispose();
        }
    }

    public int getRightSquares(){
        return rightSquares;
    }

    public void decRightSquares(){
        rightSquares--;
    }

    public void decContinueGame(){
        continueGame = false;
    }

}
