import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.GapContent;

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
                SkinSetting(centerPanel, frame);
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

    public static void SkinSetting(JPanel aPanel, JFrame aFrame){
        aPanel.setVisible(false);
        JPanel skinPanel = new JPanel();
        JButton skin1 = new JButton("Skin 1");
        JButton skin2 = new JButton("Skin 2");
        JButton back = new JButton("Back");

        skin1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                aPanel.setVisible(true);
                skinPanel.setVisible(false);
            }
        });

        skin2.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               aPanel.setVisible(true);
               skinPanel.setVisible(false);
           }
        });

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                aPanel.setVisible(true);
                skinPanel.setVisible(false);
            }
        });

        // Skin Panel Settings
        skinPanel.setVisible(true);
        skinPanel.setLayout(new GridLayout(3,1, 10, 10));
        skinPanel.setPreferredSize(new Dimension(250, 200));

        // Add skin panel to frame
        aFrame.add(skinPanel, BorderLayout.CENTER);

        // Add skin selection to panel
        skinPanel.add(skin1);
        skinPanel.add(skin2);
        skinPanel.add(back);
    }

}
