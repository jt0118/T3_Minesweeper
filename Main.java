import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        JButton start = new JButton("Start");
        JButton end = new JButton("End");
        JButton instruction = new JButton("Instruction");

        start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

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

        frame.add(start);
        frame.add(end);
        frame.add(instruction);

        frame.setLayout(new FlowLayout());
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
