import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
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
                frame.setVisible(false);
                difficultyMenu(frame);
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
        centerPanel.setLayout(new GridLayout(3,1, 10, 10));
        centerPanel.setPreferredSize(new Dimension(width, 200));

        // eastPanel settings
        eastPanel.setVisible(true);
        eastPanel.setLayout(new GridLayout(3,1, 10, 10));
        eastPanel.setPreferredSize(new Dimension(100, 15));

        // westPanel settings
        westPanel.setVisible(true);
        westPanel.setPreferredSize(new Dimension(100, 15));

        // northPanel settings
        northPanel.setVisible(true);
        northPanel.setPreferredSize(new Dimension(500, 50));

        // southPanel settings
        southPanel.setVisible(true);
        southPanel.setPreferredSize(new Dimension(500, 50));

        // frame settings
        frame.setLayout(new BorderLayout());
        frame.setSize(500,500);
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

    public static void difficultyMenu(JFrame aFrame){
        // Create a frame
        JFrame difficulty = new JFrame();
        // Create panels : this is where the components will live
        JPanel centerPanel = new JPanel();
        JPanel northPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel southPanel = new JPanel();
        // Buttons
        JButton easy = new JButton("Easy");
        JButton medium = new JButton("Medium");
        JButton hard = new JButton("Hard");
        JButton back = new JButton("Back");
        int width = 250;
        int height = 25;
        // Text Area
        JLabel title = new JLabel("Choose a Difficulty");

        // Button Actions
        easy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //send info to templateAccessor to choose easy board

            }
        });

        medium.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //send info to templateAccessor to choose medium board
            }
        });

        hard.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //send info to templateAccessor to choose hard board
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                difficulty.setVisible(false);
                aFrame.setVisible(true);
            }
        });

        // Button settings
        easy.setPreferredSize(new Dimension(width, height));
        medium.setPreferredSize(new Dimension(width, height));
        hard.setPreferredSize(new Dimension(width, height));
        back.setPreferredSize(new Dimension(width, height));
        // centerPanel settings
        centerPanel.setVisible(true);
        centerPanel.setLayout(new GridLayout(3,1, 10, 10));
        centerPanel.setPreferredSize(new Dimension(width, 200));

        // eastPanel settings
        eastPanel.setVisible(true);
        eastPanel.setLayout(new GridLayout(3,1, 10, 10));
        eastPanel.setPreferredSize(new Dimension(100, 15));

        // westPanel settings
        westPanel.setVisible(true);
        westPanel.setPreferredSize(new Dimension(100, 15));

        // northPanel settings
        northPanel.setVisible(true);
        northPanel.setPreferredSize(new Dimension(500, 50));

        // southPanel settings
        southPanel.setVisible(true);
        southPanel.setPreferredSize(new Dimension(500, 50));

        // frame settings
        difficulty.setLayout(new BorderLayout());
        difficulty.setSize(500,500);
        difficulty.setVisible(true);
        difficulty.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding components to frame
        difficulty.add(centerPanel, BorderLayout.CENTER);
        difficulty.add(northPanel, BorderLayout.NORTH);
        difficulty.add(eastPanel, BorderLayout.EAST);
        difficulty.add(westPanel, BorderLayout.WEST);
        difficulty.add(southPanel, BorderLayout.SOUTH);

        // Adding components to the panels
        centerPanel.add(easy);
        centerPanel.add(medium);
        centerPanel.add(hard);
        centerPanel.add(back);
        northPanel.add(title);
    }


}


