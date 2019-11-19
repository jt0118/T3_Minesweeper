import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ButtonFunctionality extends MouseAdapter{
    private JButton squareButton;
    private BoardController bc;

    public ButtonFunctionality(JButton squareButton, BoardController b){
        this.squareButton = squareButton;
        bc = b;
    }

    public void mineButtonFunctionality(ArrayList<Square> squareCollection, int index){
        squareButton.addMouseListener(new MouseAdapter(){
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
                    bc.decContinueGame();
                    bc.check();
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
                                squareButton.setText("F");
                                squareCollection.get(index).setFlag();
                            } else {
                                squareButton.setText("");
                                squareCollection.get(index).setFlag();
                            }
                        }
                    }
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if (squareCollection.get(index).getIsHidden()) {
                            squareButton.setText(updateIdentity);
                            squareCollection.get(index).setHidden();
                            bc.decRightSquares();
                            bc.check();
                        }
                    }
                }
            });
    }
}