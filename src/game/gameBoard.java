package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

public class gameBoard extends JFrame implements MouseListener {
    public static final int TILE_SIDE_COUNT_UP = 9;
    public static final int TILE_SIDE_COUNT_RIGHT = 10;
    protected Holes[][] holes;
    protected Knight[][] knights;
    int randomNumber1,randomNumber2;
    int trapCounter;

    public gameBoard() {
        this.holes = (new Holes[TILE_SIDE_COUNT_UP][TILE_SIDE_COUNT_RIGHT]);
        this.setVisible(true);
        this.setSize(1400, 1400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
        Traps();
    }

    private void Traps(){
        randomNumber1 = ThreadLocalRandom.current().nextInt(1,5);
        trapCounter = randomNumber1;
        do{
            trapCounter--;
            randomNumber2 = ThreadLocalRandom.current().nextInt(2,5);
            randomNumber1 = ThreadLocalRandom.current().nextInt(1,9);
            this.holes[randomNumber2][randomNumber1] = (new Holes(randomNumber2,randomNumber1,Color.BLACK));
        }while(trapCounter>0);
    }

    @Override
    public void paint(Graphics g) {
        /**
         *
         * @author Vasil
         * @param "визуализиране на игралните пешки върху бойното поле чрез два for цикъла и повикване на точната им позиция чрез row,col"
         */

        super.paint(g);

                this.renderGameTile(g, 0, 0);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 7; col++) {
                renderGamePiece(g, row, col);
            }
        }

    }

    private void renderGameTile(Graphics g, int row, int col) {

        GameTile tile = new GameTile(row, col);
        tile.render(g);
    }

    private Holes getHoles(int row, int col) {
        return this.holes[row][col];

    }

    private boolean hasHole(int row, int col) {
        return this.getHoles(row, col) != null;
    }
    private Knight getKnight(int row, int col) {
        return this.knights[row][col];

    }

    private boolean hasKnight(int row, int col) {
        return this.getKnight(row, col) != null;
    }
    private void renderGamePiece(Graphics g, int row, int col) {
        if (this.hasHole(row, col)) {
            Holes p = (Holes) this.getHoles(row, col);
            p.render(g);
        }
        if(this.hasKnight(row,col)){
            Knight p = (Knight) this.getKnight(row,col);
            p.render(g);
         }

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
