package game;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Figure {
    int row,col,attack,armor,health;
    String id;
    Color color;
    Color color2;
    int randomNumber1;
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
}

