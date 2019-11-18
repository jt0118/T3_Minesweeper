import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ButtonFunctionality extends MouseAdapter{
    private JButton squareButton;
    private JFrame mainFrame;
    private boolean continueGame;
    private BoardController controller;

    public ButtonFunctionality(JButton squareButton, JFrame mainFrame, ArrayList<Square> squareCollection, BoardController controller){
        this.squareButton = squareButton;
        this.mainFrame = mainFrame;
        continueGame = true;
        this.controller = controller;
    }

    public void mineButtonFunctionality(ArrayList<Square> squareCollection, int index){
        squareButton.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)){
                    mainFrame.dispose();
                }
            }

            public void mouseReleased(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) {
                    if(squareCollection.get(index).getIsHidden()){
                        if(!squareCollection.get(index).getIsFlag()) {
                            squareButton.setText("F");
                            squareCollection.get(index).setFlag();
                        }
                        else{
                            squareButton.setText("");
                            squareCollection.get(index).setFlag();
                        }
                        }
                }
                if(SwingUtilities.isLeftMouseButton(e)){
                    mainFrame.dispose();
                }
            }
        });
    }

    public void regularButtonFunctionality(ArrayList<Square> squareCollection, int index){

            int identity = squareCollection.get(index).getNumber();
            String updateIdentity = "" + identity;

            squareButton.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        squareButton.setText(updateIdentity);
                        squareCollection.get(index).setHidden();
                    }
                }

                public void mouseReleased(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        if (squareCollection.get(index).getIsHidden()) {
                            if (!squareCollection.get(index).getIsFlag()) {
                                squareButton.setText("F");
                                squareCollection.get(index).setFlag();
                            } else {
                                squareButton.setText("");
                                squareCollection.get(index).setFlag();
                            }
                        }
                    }
                }
            });
    }
}
