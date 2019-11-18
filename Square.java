public class Square {

    //properties of a square
    private boolean isFlag; //hint flag with numbers
    private boolean isMine; //it is a mine
    private boolean hidden; //square is visible or not
    int number; //the number that appears if applicable
    private int squareID;

    //constructor for a square
    public Square () {
        isFlag = false;
        isMine = false;
        hidden = true;
        number = 0;
        String strSquareID = String.valueOf(getSquareID());
    }

    //is this square currently flagged?
    public boolean getIsFlag() {
        return isFlag;
    }

    //does this square contain a mine?
    public boolean getIsMine() {
        return isMine;
    }

    //does this square contain any value whatsoever? (blank or not)
    public boolean getIsHidden() {
        return hidden;
    }

    //return the value of the number of the square
    public int getNumber() {
        return number;
    }

    //set the number for the square
    public void setNumber(int newNum) {
        number = newNum;
    }

    //set a mine
    public void setMine() {
        isMine = true;
    }

    //set a flag
    public void setFlag() {
        if(isFlag == false){
            isFlag = true;
        }
        else{
            isFlag = false;
        }
    }

    public void setHidden(){
        if(hidden == false){
            hidden = true;
        }
        else{
            hidden = false;
        }
    }

    public void setSquareID(int ID){
        squareID = ID;
    }
    public int getSquareID(){
        return squareID;
    }
}
