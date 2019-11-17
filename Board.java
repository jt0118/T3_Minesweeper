import java.io.*;
import java.util.*;

public class Board {

    private ArrayList<Square> playField;
    private ArrayList<String> parsedData;

    public Board(ArrayList<String> data){
        playField = new ArrayList<Square>();
        parsedData = data;
    }

    void populateBoard(){

        String temp = " ";

        for(int i = 0; i < parsedData.size(); i++){
            Square square = new Square();
            temp = parsedData.get(i);
            if(temp.equals("M")){
                square.setMine();
                square.setNumber(-1);
            }
            int tempNum = Integer.parseInt(temp);
            if(tempNum >= 0){
                square.setNumber(tempNum);
            }
            playField.add(square);
        }

    }

    void printBoard(){
        for(int i = 0; i < playField.size(); i++) {
            System.out.println(playField);
        }
    }

}
