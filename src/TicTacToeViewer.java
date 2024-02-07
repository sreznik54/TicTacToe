import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private static final int    WINDOW_WIDTH = 600,
            WINDOW_HEIGHT = 600;

    private static final int ORGIN = 80;
    private Square[][] board;
    private Image[] markerImage;
    private TicTacToe game;

    public TicTacToeViewer(TicTacToe game) {
        // TODO: Write the view's constructor.
        this.game = game;
        board = game.getBoard();
        markerImage = new Image[2];
        markerImage[0] = new ImageIcon("Resources/X.png").getImage();
        markerImage[1] = new ImageIcon("Resources/O.png").getImage();
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void paint(Graphics g)
    {
        this.drawBoard(g);
        this.drawAxis(g);
        if (game.getGameOver()){
            drawWinner(g, game.getWinner());
        }
    }

    public void drawBoard(Graphics g){
        for(int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++) {
                this.board[i][j].draw(g,ORGIN + j*Square.SIDE, ORGIN + i*Square.SIDE);
            }
        }
    }

    public void drawAxis(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawString("0", ORGIN + 20, ORGIN - 20);
        g.drawString("1", ORGIN + 20 + Square.SIDE, ORGIN - 20);
        g.drawString("2", ORGIN + 20 + Square.SIDE*2, ORGIN - 20);

        g.drawString("0", ORGIN - 20, ORGIN + 20);
        g.drawString("1", ORGIN - 20 , ORGIN + 20 + Square.SIDE);
        g.drawString("2", ORGIN - 20 , ORGIN + 20+ Square.SIDE*2);
    }

    public void drawWinner(Graphics g, String win){
        g.setColor(Color.BLACK);

        if(win.equals("-")){
            g.drawString("TIE GAME", ORGIN, 550);
        }
        else if(win.equals("X")){
            g.drawString("X WINS", ORGIN, 550);
        }
        else if(win.equals("O")){
            g.drawString("O WINS", ORGIN, 550);
        }
    }


}
