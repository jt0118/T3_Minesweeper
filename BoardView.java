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
    private int selectedDifficutly;

    public BoardView(JFrame mainFrame, JPanel mainPanel, JPanel nPanel, JPanel ePanel, JPanel wPanel, JPanel sPanel,
                     ArrayList<Square> squareList, int rightSquares, int selectedDifficutly){
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;
        this.nPanel = nPanel;
        this.ePanel = ePanel;
        this.wPanel = wPanel;
        this.sPanel = sPanel;
        squareID = 0;
        squareCollection = squareList;
        this.rightSquares = rightSquares;
        this.selectedDifficutly = selectedDifficutly;
    }

    public void buildBoard(){
        JPanel boardPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JButton instruction = new JButton("Help");
        JButton quit = new JButton("Quit");

        int gridDimension = 0;
        int ewDimension = 0;
        if(selectedDifficutly == 0){
            gridDimension = 5;
            ewDimension = 75;
        }
        else if(selectedDifficutly == 1){
            gridDimension = 9;
            ewDimension = 50;
        }
        else{
            gridDimension = 16;
            ewDimension = 25;
        }

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
        boardPanel.setLayout(new GridLayout(gridDimension, gridDimension,1,1));
        boardPanel.setPreferredSize(new Dimension(250, 200));

        // southPanel settings
        southPanel.setVisible(true);
        southPanel.setLayout(new FlowLayout());
        if(selectedDifficutly != -1){
            southPanel.setPreferredSize(new Dimension(500, 50));
        }
        else{
            southPanel.setPreferredSize(new Dimension(500, 30));
        }

        // ePanel and wPanel settings
        ePanel.setPreferredSize(new Dimension(ewDimension,1));
        wPanel.setPreferredSize(new Dimension(ewDimension,1));

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

        // button settings
        button.setMargin(new Insets(2,2,2,2));

        squareID++;
        return button;
    }
}
