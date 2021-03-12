package game;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Dwarfs extends Figure {
    public Color color;
    int randomNumber1;

    public Dwarfs(int row, int col, Color color,String id,Color color2) {
        super();
        this.row = row;
        this.col=col;
        this.color=color;
        this.id = "D";
        this.color2=color2;
        this.attack=6;
        this.health=12;
        this.armor=2;
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
        if(rowCoeficient<=2&&colCoeficient==0||colCoeficient<=2 && rowCoeficient==0)
            return  true;
        return false;
    }
    public boolean isAttackValid(int moveRow, int moveCol) {

        int rowCoeficient = Math.abs(moveRow - this.row);
        int colCoeficient = moveCol - this.col;
        if(rowCoeficient==2&&colCoeficient==0||colCoeficient==2 && rowCoeficient==0)
            return  true;
        return false;
    }
    public void hpGainDwarfs(){
        randomNumber1 = ThreadLocalRandom.current().nextInt(1,6);
        switch (randomNumber1){
            case 1 -> health+=1;
            case 2 -> health+=2;
            case 3 -> health+=3;
            case 4 -> health+=4;
            case 5 -> health+=5;
            case 6 -> health+=6;
        }
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