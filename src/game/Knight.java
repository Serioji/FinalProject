package game;

import java.awt.*;

public class Knight extends Figure {
    public Color color;

    public Knight(int row, int col, Color color) {
        super();
        this.row = row;
        this.col=col;
        this.color=color;
    }

    public void render(Graphics g) {
        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;
        g.setColor(this.color);
        g.fillRect(x+10, y+33, 100, 100);

    }
    public void move(int row,int col){
       this.row = row;
       this.col = col;
    }

}