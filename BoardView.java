import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardView {

    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel sPanel;

    public BoardView(JFrame mainFrame, JPanel mainPanel, JPanel sPanel){
        this.mainFrame = mainFrame;
        this.mainPanel = mainPanel;
        this.sPanel = sPanel;
    }

    public void showBoard(){

    }

    public void buildBoard(){
        JPanel boardPanel = new JPanel();
        JPanel southPanel = new JPanel();
        JButton instruction = new JButton("Help");
        JButton quit = new JButton("Quit");
        JButton button = new JButton("hi");

        for(int i = 0; i < 25; i++){
            String buttonNum = "" + i;
            JButton squareButton = new JButton(buttonNum);

            // Button settings
            squareButton.setPreferredSize(new Dimension(10,10));
        }

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
        boardPanel.add(button);

        // southPanel components
        southPanel.add(instruction);
        southPanel.add(quit);

    }
}
