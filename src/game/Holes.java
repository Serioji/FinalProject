package game;

import java.awt.*;

public class Holes extends Figure {
    public Color color;

    public Holes(int row, int col, Color color) {
        super();
        this.row = row;
        this.col=col;
        this.color=color;
    }

    public void render(Graphics g) {
        int x = this.col * GameTile.TILE_SIZE;
        int y = this.row * GameTile.TILE_SIZE;
        g.setColor(this.color);
        g.fillRect(x+10, y, 100, 100);

    }

}
