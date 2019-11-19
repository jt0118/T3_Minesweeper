import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardControl {

    public Boolean continueGame;
    public int rightSquares;
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel nPanel;
    private JPanel ePanel;
    private JPanel wPanel;
    private JPanel sPanel;
    private JPanel boardPanel;
    private JPanel boardSPanel;

    public BoardControl(JFrame mainFrame, JPanel mainPanel, JPanel nPanel, JPanel ePanel, JPanel wPanel, JPanel sPanel,
                        int rightSquares, JPanel boardPanel, JPanel boardSPanel){
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;
        this.nPanel = nPanel;
        this.ePanel = ePanel;
        this.wPanel = wPanel;
        this.sPanel = sPanel;
        continueGame = true;
        this.rightSquares = rightSquares;
        this.boardPanel = boardPanel;
        this.boardSPanel = boardSPanel;
    }

    public void check(){
        if(rightSquares == 0 || !continueGame){
            boardSPanel.setVisible(false);
            boardPanel.setVisible(false);
            mainPanel.setVisible(true);
            sPanel.setVisible(true);
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
