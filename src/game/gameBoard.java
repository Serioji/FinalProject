package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

public class gameBoard extends JFrame implements MouseListener {
    public static final int TILE_SIDE_COUNT_UP = 7;
    public static final int TILE_SIDE_COUNT_RIGHT = 15;
    protected Holes[][] holes;
    protected Knight[][] knights;
    protected Elfs[][] elfs;
    protected  Dwarfs[][] dwarfs;
    protected Knight knight;
    protected Elfs elf;
    protected Dwarfs dwarf;
    int randomNumber1,randomNumber2;
    int trapCounter;
    int playerTurn;
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    public gameBoard() {
        this.holes = (new Holes[TILE_SIDE_COUNT_UP][TILE_SIDE_COUNT_RIGHT]);
        this.setVisible(true);
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);
        Traps();
        this.knights =(new Knight[TILE_SIDE_COUNT_UP][TILE_SIDE_COUNT_RIGHT]);
        this.elfs =(new Elfs[TILE_SIDE_COUNT_UP][TILE_SIDE_COUNT_RIGHT]);
        this.dwarfs =(new Dwarfs[TILE_SIDE_COUNT_UP][TILE_SIDE_COUNT_RIGHT]);
        summonKnight();
        summonElfs();
        summonDwarfs();
        label();
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
private void label(){
    label.setText("Player 1 Units");
    label.setBounds(1150,50,100,50);
    label1.setText("Player 2 Units");
    label1.setBounds(1150,450,100,50);
    this.add(label);
    this.add(label1);
    this.setLayout(null);
}
    private void summonKnight(){
        this.knights[1][9] = (new Knight(1,9,Color.GREEN,"K",Color.red));
        this.knights[1][10] = (new Knight(1,10,Color.GREEN,"K",Color.red));
        this.knights[5][9] = (new Knight(5,9,Color.GREEN,"K",Color.blue));
        this.knights[5][10] = (new Knight(5,10,Color.GREEN,"K",Color.blue));
    }
    private void summonElfs(){
        this.elfs[1][11] = (new Elfs(1,11,Color.magenta,"E",Color.red));
        this.elfs[1][12] = (new Elfs(1,12,Color.magenta,"E",Color.red));
        this.elfs[5][11] = (new Elfs(5,11,Color.magenta,"E",Color.blue));
        this.elfs[5][12] = (new Elfs(5,12,Color.magenta,"E",Color.blue));
    }
    private void summonDwarfs(){
        this.dwarfs[1][13] = (new Dwarfs(1,13,Color.CYAN,"E",Color.red));
        this.dwarfs[1][14] = (new Dwarfs(1,14,Color.CYAN,"E",Color.red));
        this.dwarfs[5][13] = (new Dwarfs(5,13,Color.CYAN,"E",Color.blue));
        this.dwarfs[5][14] = (new Dwarfs(5,14,Color.CYAN,"E",Color.blue));
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

        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 15; col++) {
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
    private Elfs getElfs(int row, int col) {
        return this.elfs[row][col];

    }

    private boolean hasElfs(int row, int col) {
        return this.getElfs(row, col) != null;
    }
    private Dwarfs getDwarfs(int row, int col) {
        return this.dwarfs[row][col];

    }

    private boolean hasDwarfs(int row, int col) {
        return this.getDwarfs(row, col) != null;
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
        if(this.hasElfs(row,col)){
            Elfs p = (Elfs) this.getElfs(row,col);
            p.render(g);
        }
        if(this.hasDwarfs(row,col)){
            Dwarfs p = (Dwarfs) this.getDwarfs(row,col);
            p.render(g);
        }

    }

    private void moveKinght(int row, int col, Knight p1) {
        int initialRow = p1.getRow();
        int initialCol = p1.getCol();

        p1.move(row, col);

        this.knights[p1.getRow()][p1.getCol()] = this.knight;
        this.knights[initialRow][initialCol] = null;

        this.knight = null;
    }
    private void moveElfs(int row, int col, Elfs p1) {
        int initialRow = p1.getRow();
        int initialCol = p1.getCol();

        p1.move(row, col);

        this.elfs[p1.getRow()][p1.getCol()] = this.elf;
        this.elfs[initialRow][initialCol] = null;

        this.elf = null;
    }
    private void moveDwarfs(int row, int col, Dwarfs p1) {
        int initialRow = p1.getRow();
        int initialCol = p1.getCol();

        p1.move(row, col);

        this.dwarfs[p1.getRow()][p1.getCol()] = this.dwarf;
        this.dwarfs[initialRow][initialCol] = null;

        this.dwarf = null;
    }


    private int getBoardDimensionBasedOnCoordinates(int coordinates) {
        return coordinates / GameTile.TILE_SIZE;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.getBoardDimensionBasedOnCoordinates(e.getY());
        int col = this.getBoardDimensionBasedOnCoordinates(e.getX());
        row--;


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
