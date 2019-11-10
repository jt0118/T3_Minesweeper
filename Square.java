package edu.uah.cs.cs321.aoife;

public class Square {

    //properties of a square
    private boolean isFlag; //hint flag with numbers
    private boolean isMine; //it is a mine
    private boolean hidden; //square is visible or not
    int number; //the number that appears if applicable

    //constructor for a square
    public Square () {
        isFlag = false;
        isMine = false;
        hidden = true;
        number = 0;
    }
    //is this square currently flagged?
    public boolean isFlag() {
        return isFlag;
    }
    //does this square contain a mine?
    public boolean isMine() {
        return isMine;
    }
    //does this square contain any value whatsoever? (blank or not)
    public boolean isHidden() {
        return hidden;
    }
    //return the value of the number of the square
    public int getnumber() {
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
        isFlag = true;
    }
    //unflag a square
    public void unFlag() {
        isFlag = false;
    }
    //unhide a square
    public void unhide() {
        hidden = false;
    }

}
