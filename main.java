public class main {
    public static void main(String[] args){
        BoardParser parser = new BoardParser();
        Board board = new Board(parser.getParsedData());
        board.populateBoard();
        board.printBoard();
    }
}
