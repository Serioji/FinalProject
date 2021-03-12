package game;

import java.awt.*;

public class Dwarfs extends Figure {
    public Color color;

    public Dwarfs(int row, int col, Color color,String id,Color color2) {
        super();
        this.row = row;
        this.col=col;
        this.color=color;
        this.id = "D";
        this.color2=color2;
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isMoveValid(int moveRow, int moveCol) {

        int rowCoeficient = Math.abs(moveRow - this.row);
        int colCoeficient = moveCol - this.col;
        if(rowCoeficient==0&&colCoeficient==2||colCoeficient==0 && rowCoeficient==2)
            return  true;
        return false;
    }

    public void render(Graphics g) {
        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;
        g.setColor(this.color);
        g.fillRect(x+11, y, 99, 99);
        g.setColor(this.color2);
        g.fillOval(x+50,y+32,25,25);

    }
    public void move(int row,int col){
        this.row = row;
        this.col = col;
    }

}