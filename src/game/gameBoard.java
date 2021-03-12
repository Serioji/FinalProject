package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ThreadLocalRandom;

public class gameBoard extends JFrame implements MouseListener {
    public static final int TILE_SIDE_COUNT_UP = 8;
    public static final int TILE_SIDE_COUNT_RIGHT = 15;
    protected Holes[][] holes;
    protected Knight[][] knights;
    protected Elfs[][] elfs;
    protected  Dwarfs[][] dwarfs;
    protected Helper[][] helpers;
    protected Knight knight;
    protected Elfs elf;
    protected Dwarfs dwarf;
    int randomNumber1,randomNumber2;
    int trapCounter;
    int playerTurn = 0;
    int firstRow,firstCol;
    int player =0;
    Color playerC;

    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JLabel label5 = new JLabel();
    JLabel label6 = new JLabel();
    JLabel label7 = new JLabel();

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
        summonUnit();
        label();
        this.helpers =(new Helper[TILE_SIDE_COUNT_UP][TILE_SIDE_COUNT_RIGHT]);
    }

    private void Traps(){
        randomNumber1 = ThreadLocalRandom.current().nextInt(1,5);
        trapCounter = randomNumber1;
        do{
            trapCounter--;
            randomNumber2 = ThreadLocalRandom.current().nextInt(3,6);
            randomNumber1 = ThreadLocalRandom.current().nextInt(1,9);
            this.holes[randomNumber2][randomNumber1] = (new Holes(randomNumber2,randomNumber1,Color.BLACK));
        }while(trapCounter>0);
    }
private void label(){
    label.setText("Player 1 Units");
    label.setBounds(1175,-10,100,50);
    label1.setText("Player 2 Units");
    label1.setBounds(1175,450,100,50);
    label2.setText("K");
    label2.setBounds(1000,500,100,50);
    label3.setText("E");
    label3.setBounds(1200,500,100,50);
    label4.setText("D");
    label4.setBounds(1400,500,100,50);
    label5.setText("D");
    label5.setBounds(1400,10,100,50);
    label6.setText("K");
    label6.setBounds(1000,10,100,50);
    label7.setText("E");
    label7.setBounds(1200,10,100,50);
    this.add(label);
    this.add(label1);
    this.add(label2);
    this.add(label3);
    this.add(label4);
    this.add(label5);
    this.add(label6);
    this.add(label7);
    this.setLayout(null);
}
    private void summonUnit(){
        switch (playerTurn) {
            case 0 -> this.knights[1][9] = (new Knight(1, 9, Color.GREEN, "K", Color.red));
            case 1 -> this.knights[6][9] = (new Knight(6, 9, Color.GREEN, "K", Color.BLACK));
            case 2 -> this.knights[1][10] = (new Knight(1, 10, Color.GREEN, "K", Color.red));
            case 3 -> this.knights[6][10] = (new Knight(6, 10, Color.GREEN, "K", Color.BLACK));
            case 4 ->this.elfs[1][11] = (new Elfs(1,11,Color.magenta,"E",Color.red));
            case 5 ->this.elfs[6][11] = (new Elfs(6,11,Color.magenta,"E",Color.BLACK));
            case 6 ->this.elfs[1][12] = (new Elfs(1,12,Color.magenta,"E",Color.red));
            case 7 ->this.elfs[6][12] = (new Elfs(6,12,Color.magenta,"E",Color.BLACK));
            case 8 ->this.dwarfs[1][13] = (new Dwarfs(1,13,Color.CYAN,"D",Color.red));
            case 9 ->this.dwarfs[6][13] = (new Dwarfs(6,13,Color.CYAN,"D",Color.BLACK));
            case 10 ->this.dwarfs[1][14] = (new Dwarfs(1,14,Color.CYAN,"D",Color.red));
                    case 11 ->this.dwarfs[6][14] = (new Dwarfs(6,14,Color.CYAN,"D",Color.BLACK));
        }

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

        for (int row = 0; row < 8; row++) {
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
    private Helper getHelper(int row, int col) {
        return this.helpers[row][col];

    }

    private boolean hasHelpers(int row, int col) {
        return this.getHelper(row, col) != null;
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
        if(this.hasHelpers(row,col)){
            Helper p = (Helper) this.getHelper(row,col);
            p.render(g);
        }

    }

    private void help(int row){
        int end = row+1;
        for(;row<=end;row++){
            for(int col=0;col<9;col++){
                this.helpers[row][col] =(new Helper(row,col,Color.lightGray));
            }
        }
    }
    private void deleter(){
        for(int row=0;row<8;row++){
            for(int col=0;col<10;col++){
                if(hasHelpers(row,col)){
                    helpers[row][col]=null;
                }
            }
        }
    }

    private void moveKnight(int row, int col, Knight p1) {
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
    private void knightMove(int row,int col,int firstRow,int firstCol){
        Knight p1 =(Knight) this.knight;
        if(this.hasKnight(row,col)){

        } else if(p1.isMoveValid(row,col)){
            moveKnight(row,col,p1);
        }
    }


    private int getBoardDimensionBasedOnCoordinates(int coordinates) {
        return coordinates / GameTile.TILE_SIZE;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.getBoardDimensionBasedOnCoordinates(e.getY());
        int col = this.getBoardDimensionBasedOnCoordinates(e.getX());
        if (dwarf != null || knight != null || elf != null) {
            if (hasHelpers(row, col)) {
                deleter();
                if (dwarf != null) {
                    this.dwarfs[row][col] = (new Dwarfs(row, col, Color.CYAN, "D", playerC));
                    dwarf = null;
                    this.dwarfs[firstRow][firstCol]=null;
                }
                if (knight != null) {
                    this.knights[row][col] = (new Knight(row, col, Color.GREEN, "K", playerC));
                    knight = null;
                    this.knights[firstRow][firstCol]=null;
                }
                if (elf != null) {
                    this.elfs[row][col] = (new Elfs(row, col, Color.MAGENTA, "E", playerC));
                    elf = null;
                    this.elfs[firstRow][firstCol]=null;
                }
                if(playerTurn==12){
                   this.helpers[row][col] =null;
                }
            }
            summonUnit();
        } else {
            if (playerTurn % 2 == 0) {
                help(1);
                playerC = Color.RED;
            } else {
                help(6);
                playerC = Color.BLACK;
            }
            playerTurn++;
            firstRow = row;
            firstCol = col;
            if (this.hasKnight(row, col))
                this.knight = this.getKnight(row, col);
            if (this.hasDwarfs(row, col))
                this.dwarf = this.getDwarfs(row, col);
            if (this.hasElfs(row, col))
                this.elf = this.getElfs(row, col);
        }
        if(this.knight !=null){
            knightMove(row,col,firstRow,firstCol);

        }
        if(this.dwarf !=null){
            dwarfMove(row,col,firstRow,firstCol);
            }
        if(this.elf !=null){
            elfMove(row,col,firstRow,firstCol);
        }
        else{
            firstRow=row;
            firstCol=col;
        }
        this.repaint();

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
