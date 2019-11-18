import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BoardController extends MouseAdapter{
    private JButton squareButton;
    private JFrame mainFrame;
    private int remainingSquares;
    private boolean continueGame;

    public BoardController(JButton squareButton, JFrame mainFrame, ArrayList<Square> squareCollection, int remainingSquares){
        this.squareButton = squareButton;
        this.mainFrame = mainFrame;
        this.remainingSquares = remainingSquares;
        continueGame = true;
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
                        remainingSquares--;
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
