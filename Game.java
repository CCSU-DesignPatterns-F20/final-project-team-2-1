public class Game{
    public static void play(){
        GameGui gamePlay = new GameGui();
        // Creates board and path
        System.out.println("\nCreating The Board");
        var path = PathGenerator.create10by10EasyPath();
      
        Board board = new Board.BoardBuilder().setBoardSize(10, 10).setPathCell(path).build();
        
        gamePlay.setxBox(gamePlay.getxCanvas()/board.getRows());
        gamePlay.setyBox(gamePlay.getyCanvas()/board.getColumns());
        // gamePlay.drawBox(gamePlay.getJPanel(), 1, 1);
    }
}