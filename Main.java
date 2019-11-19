import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        createFrame();
    }

    public static void createFrame(){
        // Create a frame
        JFrame frame = new JFrame();
        // Create panels : this is where the components will live
        JPanel centerPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel southPanel = new JPanel();
        // Buttons
        JButton start = new JButton("Start");
        JButton end = new JButton("End");
        JButton instruction = new JButton("Instruction");
        int width = 250;
        int height = 25;
        // Text Area
        JLabel title = new JLabel("Minesweeper");

        // Button Actions
        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                difficultyMenu(frame, centerPanel, northPanel, eastPanel, westPanel, southPanel);
            }
        });

        end.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        instruction.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Instruction help = new Instruction();
                help.showMenu();
            }
        });

        // Button settings
        start.setPreferredSize(new Dimension(width, height));
        end.setPreferredSize(new Dimension(width, height));
        instruction.setPreferredSize(new Dimension(width, height));

        // centerPanel settings
        centerPanel.setVisible(true);
        centerPanel.setLayout(new GridLayout(3,1, 10, 25));
        centerPanel.setPreferredSize(new Dimension(width, 200));

        // eastPanel settings
        eastPanel.setVisible(true);
        eastPanel.setPreferredSize(new Dimension(125, 15));

        // westPanel settings
        westPanel.setVisible(true);
        westPanel.setPreferredSize(new Dimension(125, 15));

        // northPanel settings
        northPanel.setVisible(true);
        northPanel.setPreferredSize(new Dimension(550, 50));

        // southPanel settings
        southPanel.setVisible(true);
        southPanel.setPreferredSize(new Dimension(550, 50));

        // frame settings
        frame.setLayout(new BorderLayout());
        frame.setSize(550,550);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding components to frame
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(southPanel, BorderLayout.SOUTH);

        // Adding components to the panels
        centerPanel.add(start);
        centerPanel.add(instruction);
        centerPanel.add(end);
        northPanel.add(title);
    }

    public static void difficultyMenu(JFrame mFrame, JPanel cPanel, JPanel nPanel, JPanel ePanel, JPanel wPanel,
                                      JPanel sPanel){
        cPanel.setVisible(false);
        JPanel difficultyPanel = new JPanel();
        JButton easy = new JButton("Easy");
        JButton medium = new JButton("Medium");
        JButton back = new JButton("Back");
        JButton hard = new JButton("Hard");

        // Button Actions
        easy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardParser parser = new BoardParser(0);
                Board board = new Board(parser.getParsedData());
                board.populateBoard();
                ArrayList<Square> squareList = new ArrayList<Square>();
                squareList = board.getPlayField();
                int right = board.getnonMineSquare();
                SkinSetting(mFrame, cPanel, nPanel, ePanel, wPanel, sPanel, squareList, right, difficultyPanel, 0);
            }
        });

        medium.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardParser parser = new BoardParser(1);
                Board board = new Board(parser.getParsedData());
                board.populateBoard();
                ArrayList<Square> squareList = new ArrayList<Square>();
                squareList = board.getPlayField();
                int right = board.getnonMineSquare();
                SkinSetting(mFrame, cPanel, nPanel, ePanel, wPanel, sPanel, squareList, right, difficultyPanel, 1);
            }
        });

        hard.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                BoardParser parser = new BoardParser(-1);
                Board board = new Board(parser.getParsedData());
                board.populateBoard();
                ArrayList<Square> squareList = new ArrayList<Square>();
                squareList = board.getPlayField();
                int right = board.getnonMineSquare();
                SkinSetting(mFrame, cPanel, nPanel, ePanel, wPanel, sPanel, squareList, right, difficultyPanel, -1);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficultyPanel.setVisible(false);
                cPanel.setVisible(true);
            }
        });
        // Difficulty Panel Settings
        difficultyPanel.setVisible(true);
        difficultyPanel.setLayout(new GridLayout(4,1, 10, 10));
        difficultyPanel.setPreferredSize(new Dimension(250, 200));

        // reset settings
        wPanel.setPreferredSize(new Dimension(125, 15));
        ePanel.setPreferredSize(new Dimension(125, 15));
        sPanel.setVisible(true);

        // Add difficulty panel to frame
        mFrame.add(difficultyPanel, BorderLayout.CENTER);
        mFrame.add(sPanel, BorderLayout.SOUTH);

        // Add skin selection to panel
        difficultyPanel.add(easy);
        difficultyPanel.add(medium);
        difficultyPanel.add(hard);
        difficultyPanel.add(back);
    }
    
    public static void SkinSetting(JFrame mFrame, JPanel cPanel, JPanel nPanel, JPanel ePanel, JPanel wPanel,
                                   JPanel sPanel, ArrayList<Square> squareList, int right, JPanel difficulty,
                                   int selectedDifficutly){
        difficulty.setVisible(false);
        JPanel skinPanel = new JPanel();
        JButton skin1 = new JButton("Skin 1");
        JButton skin2 = new JButton("Skin 2");
        JButton back = new JButton("Back");

        skin1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //aPanel.setVisible(true);
                skinPanel.setVisible(false);
                BoardView board = new BoardView(mFrame, cPanel, nPanel, ePanel, wPanel, sPanel, squareList, right,
                                                selectedDifficutly);
                board.buildBoard();
            }
        });

        skin2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //cPanel.setVisible(true);
                skinPanel.setVisible(false);
                BoardView board = new BoardView(mFrame, cPanel, nPanel, ePanel, wPanel, sPanel, squareList, right,
                                                selectedDifficutly);
                board.buildBoard();
            }
        });

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                difficulty.setVisible(true);
                skinPanel.setVisible(false);
            }
        });

        // Skin Panel Settings
        skinPanel.setVisible(true);
        skinPanel.setLayout(new GridLayout(3,1, 10, 10));
        skinPanel.setPreferredSize(new Dimension(250, 200));

        // Add skin panel to frame
        mFrame.add(skinPanel, BorderLayout.CENTER);

        // Add skin selection to panel
        skinPanel.add(skin1);
        skinPanel.add(skin2);
        skinPanel.add(back);
    }
}


