import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ButtonFunctionality extends MouseAdapter{
    private JButton squareButton;
    private BoardControl boardControl;
    private ImageIcon flag;

    public ButtonFunctionality(JButton squareButton, BoardControl boardControl){
        this.squareButton = squareButton;
        this.boardControl = boardControl;
        ImageIcon imageIcon = new ImageIcon("images/flag.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH);
        flag = new ImageIcon(newimg);
    }

    public void mineButtonFunctionality(ArrayList<Square> squareCollection, int index){
        squareButton.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) {
                    if(squareCollection.get(index).getIsHidden()){
                        if(!squareCollection.get(index).getIsFlag()) {
                            squareButton.setIcon(flag);
                            squareCollection.get(index).setFlag();
                        }
                        else{
                            squareButton.setIcon(null);
                            squareCollection.get(index).setFlag();
                        }
                        }
                }
                if(SwingUtilities.isLeftMouseButton(e)){
                    boardControl.decContinueGame();
                    boardControl.check();
                }
            }
        });
    }

    public void regularButtonFunctionality(ArrayList<Square> squareCollection, int index){

            int identity = squareCollection.get(index).getNumber();
            String updateIdentity = "" + identity;

            squareButton.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        if (squareCollection.get(index).getIsHidden()) {
                            if (!squareCollection.get(index).getIsFlag()) {
                                squareButton.setIcon(flag);
                                squareCollection.get(index).setFlag();
                            } else {
                                squareButton.setIcon(null);
                                squareCollection.get(index).setFlag();
                            }
                        }
                    }
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if (squareCollection.get(index).getIsHidden()) {
                            squareButton.setBackground(Color.lightGray);
                            squareButton.setIcon(null);
                            if(squareCollection.get(index).getNumber() != 0){
                                squareButton.setText(updateIdentity);
                            }
                            squareCollection.get(index).setHidden();
                            boardControl.decRightSquares();
                            boardControl.check();
                        }
                    }
                }
            });
    }
}