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
        if(rightSquares == 0){
            boardSPanel.setVisible(false);
            boardPanel.setVisible(false);
            winScreen();
        }
        else if(!continueGame){
            boardSPanel.setVisible(false);
            boardPanel.setVisible(false);
            loseScreen();
        }
    }

    public void winScreen(){
        JPanel winPanel = new JPanel();
        JPanel buttomWinPanel = new JPanel();
        JLabel winner = new JLabel();
        winner.setIcon(new ImageIcon("Images/win.gif"));
        JButton tryAgain = new JButton("Play Again");
        JButton quit = new JButton("Quit");

        quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });

        tryAgain.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                winPanel.setVisible(false);
                buttomWinPanel.setVisible(false);
                mainPanel.setVisible(true);
                sPanel.setVisible(true);
            }
        });

        // winPanel settings
        winPanel.setVisible(true);
        winPanel.setLayout(new FlowLayout());
        winPanel.setPreferredSize(new Dimension(250, 200));

        // buttomWinPanel settings
        buttomWinPanel.setVisible(true);
        buttomWinPanel.setLayout(new FlowLayout());
        buttomWinPanel.setPreferredSize(new Dimension(500, 50));

        // mainFrame components
        mainFrame.add(winPanel, BorderLayout.CENTER);
        mainFrame.add(buttomWinPanel, BorderLayout.SOUTH);

        // winPanel components
        winPanel.add(winner);

        // buttomWinPanel components
        buttomWinPanel.add(tryAgain);
        buttomWinPanel.add(quit);

    }

    public void loseScreen(){
        JPanel losePanel = new JPanel();
        JPanel buttomLosePanel = new JPanel();
        JLabel loser = new JLabel();
        loser.setIcon(new ImageIcon("Images/lose.gif"));
        JButton tryAgain = new JButton("Play Again");
        JButton quit = new JButton("Quit");

        quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });

        tryAgain.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                losePanel.setVisible(false);
                buttomLosePanel.setVisible(false);
                mainPanel.setVisible(true);
                sPanel.setVisible(true);
            }
        });

        // losePanel settings
        losePanel.setVisible(true);
        losePanel.setLayout(new FlowLayout());
        losePanel.setPreferredSize(new Dimension(250, 200));

        // buttomLosePanel settings
        buttomLosePanel.setVisible(true);
        buttomLosePanel.setLayout(new FlowLayout());
        buttomLosePanel.setPreferredSize(new Dimension(500, 50));

        // mainFrame components
        mainFrame.add(losePanel, BorderLayout.CENTER);
        mainFrame.add(buttomLosePanel, BorderLayout.SOUTH);

        // losePanel components
        losePanel.add(loser);

        // buttomWinPanel components
        buttomLosePanel.add(tryAgain);
        buttomLosePanel.add(quit);
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
