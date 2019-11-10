import javax.swing.*;

public class Instruction{
    public void showMenu() {
        JOptionPane.showMessageDialog(null, "Difficulties:\nEasy = smallest grid with least amount of mines\n\tMedium = larger grid with more mines\n\tHard = largest grid with the most amount of mines\n\nPlaying the Game:\nClick on a square to reveal it. If you think it could be a mine, place a flag.\n\tUncover all squares without hitting a mine to win the game. If you click a mine, game over!", "Need Help?", JOptionPane.INFORMATION_MESSAGE);

    }
}