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

    public void render(Graphics g) {
        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;
        g.setColor(this.color);
        g.fillRect(x+11, y+34, 99, 99);
        g.setColor(this.color2);
        g.fillOval(x+50,y+66,25,25);

    }
    public void move(int row,int col){
        this.row = row;
        this.col = col;
    }

}