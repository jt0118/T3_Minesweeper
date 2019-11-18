import java.io.*;
import java.util.ArrayList;

public class Board {

    private ArrayList<Square> playField;
    private ArrayList<String> parsedData;

    public Board(ArrayList<String> data){
        playField = new ArrayList<Square>();
        parsedData = data;
    }

    void populateBoard(){

        String temp = " ";
        int tempID = 1;

        for(int i = 0; i < parsedData.size(); i++){
            Square square = new Square();
            temp = parsedData.get(i);
            if(temp.equals("M")){
                square.setMine();
                square.setNumber(-1);
            }
            else {
                int tempNum = Integer.parseInt(temp);
                if (tempNum >= 0) {
                    square.setNumber(tempNum);
                }
            }
            square.setSquareID(tempID);
            playField.add(square);
            tempID++;
        }

    }
}
