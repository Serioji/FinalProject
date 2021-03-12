package game;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Knight extends Figure {
    public Color color;
    int randomNumber1;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Knight(int row, int col, Color color,String id,Color color2) {
        super();
        this.row = row;
        this.col=col;
        this.color=color;
        this.color2=color2;
        this.id= "K";
        this.armor=3;
        this.health=15;
        this.attack=8;
    }
    public boolean isMoveValid(int moveRow, int moveCol) {

        int rowCoeficient = Math.abs(moveRow - this.row);
        int colCoeficient = moveCol - this.col;
        if(rowCoeficient<=1&&colCoeficient==0||colCoeficient<=1 && rowCoeficient==0)
            return  true;
        return false;
    }
    public boolean isAttackValid(int moveRow, int moveCol) {

        int rowCoeficient = Math.abs(moveRow - this.row);
        int colCoeficient = moveCol - this.col;
        if(rowCoeficient==1&&colCoeficient==0||colCoeficient==1 && rowCoeficient==0)
            return  true;
        return false;
    }

    public void hpGainKnight(){
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