import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BoardView {

    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel nPanel;
    private JPanel ePanel;
    private JPanel wPanel;
    private JPanel sPanel;
    private int squareID;
    private int rightSquares;
    private ArrayList<Square> squareCollection;
    BoardControl boardControl;

    public BoardView(JFrame mainFrame, JPanel mainPanel, JPanel nPanel, JPanel ePanel, JPanel wPanel, JPanel sPanel,
                     ArrayList<Square> squareList, int rightSquares){
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;
        this.nPanel = nPanel;
        this.ePanel = ePanel;
        this.wPanel = wPanel;
        this.sPanel = sPanel;
        squareID = 0;
        squareCollection = squareList;
        this.rightSquares = rightSquares;
    }

    public void buildBoard(){
        JPanel boardPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JButton instruction = new JButton("Help");
        JButton quit = new JButton("Quit");

        boardControl = new BoardControl(mainFrame, mainPanel, this.nPanel, this.ePanel, this.wPanel, this.sPanel,
                this.rightSquares, boardPanel, southPanel);

        quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });

        instruction.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Instruction help = new Instruction();
                help.showMenu();
            }
        });

        // mainPanel settings
        mainPanel.setVisible(false);
        sPanel.setVisible(false);

        // boardPanel settings
        boardPanel.setVisible(true);
        boardPanel.setLayout(new GridLayout(5, 5,1,1));
        boardPanel.setPreferredSize(new Dimension(250, 200));

        // southPanel settings
        southPanel.setVisible(true);
        southPanel.setLayout(new FlowLayout());
        southPanel.setPreferredSize(new Dimension(500, 50));

        // mainFrame components
        mainFrame.add(boardPanel, BorderLayout.CENTER);
        mainFrame.add(southPanel, BorderLayout.SOUTH);

        // boardPanel components
        for(int i = 0; i < squareCollection.size(); i++){
            boardPanel.add(createButton());
        }

        // southPanel components
        southPanel.add(instruction);
        southPanel.add(quit);
    }

    public JButton createButton(){
        JButton button = new JButton();
        ButtonFunctionality functionality = new ButtonFunctionality(button, boardControl);

        if(squareCollection.get(squareID).getIsMine()){
            functionality.mineButtonFunctionality(squareCollection, squareID);
        }
        else{
            functionality.regularButtonFunctionality(squareCollection, squareID);
        }

        squareID++;
        return button;
    }
}
