package game;


import java.awt.*;

public class GameTile {
        public static final int TILE_SIZE = 100;
        private int row;
        private int col;
        private int tileSize;
        private Color color;

        public GameTile(int row, int col, Color color) {

            this.row = row;
            this.col = col;
            this.tileSize = 100;
            this.color=color;
        }
    public void render(Graphics g) {
        /**
         *
         * @author Vasil
         * @param "това е визуализирането на бойното поле със съответния му цвят и параметри за изчисляването на големината му"
         */
        int tileX = this.col * this.tileSize;
        int tileY = this.row * this.tileSize;
        g.setColor(Color.red);
        g.fillRect(10,31,TILE_SIZE,TILE_SIZE);g.fillRect(210,31,TILE_SIZE,TILE_SIZE);g.fillRect(410,31,TILE_SIZE,TILE_SIZE);
        g.fillRect(610,31,TILE_SIZE,TILE_SIZE);g.fillRect(810,31,TILE_SIZE,TILE_SIZE);
        g.fillRect(10,631,TILE_SIZE,TILE_SIZE);g.fillRect(210,631,TILE_SIZE,TILE_SIZE);g.fillRect(410,631,TILE_SIZE,TILE_SIZE);g.fillRect(610,631,TILE_SIZE,TILE_SIZE);g.fillRect(810,631,TILE_SIZE,TILE_SIZE);g.fillRect(110,131,TILE_SIZE,TILE_SIZE);
        g.fillRect(310,131,TILE_SIZE,TILE_SIZE);g.fillRect(510,131,TILE_SIZE,TILE_SIZE);
        g.fillRect(710,131,TILE_SIZE,TILE_SIZE);g.fillRect(110,531,TILE_SIZE,TILE_SIZE);
        g.fillRect(310,531,TILE_SIZE,TILE_SIZE);g.fillRect(510,531,TILE_SIZE,TILE_SIZE); g.fillRect(710,531,TILE_SIZE,TILE_SIZE);
        g.setColor(Color.GRAY);
        g.fillRect(10,531,TILE_SIZE,TILE_SIZE);g.fillRect(210,531,TILE_SIZE,TILE_SIZE);
        g.fillRect(410,531,TILE_SIZE,TILE_SIZE);g.fillRect(610,531,TILE_SIZE,TILE_SIZE);g.fillRect(810,531,TILE_SIZE,TILE_SIZE);g.fillRect(10,131,TILE_SIZE,TILE_SIZE);
        g.fillRect(210,131,TILE_SIZE,TILE_SIZE);g.fillRect(410,131,TILE_SIZE,TILE_SIZE);g.fillRect(610,131,TILE_SIZE,TILE_SIZE);g.fillRect(810,131,TILE_SIZE,TILE_SIZE);g.fillRect(110,31,TILE_SIZE,TILE_SIZE);g.fillRect(310,31,TILE_SIZE,TILE_SIZE);
        g.fillRect(510,31,TILE_SIZE,TILE_SIZE);g.fillRect(710,31,TILE_SIZE,TILE_SIZE);g.fillRect(110,631,TILE_SIZE,TILE_SIZE);g.fillRect(310,631,TILE_SIZE,TILE_SIZE);g.fillRect(510,631,TILE_SIZE,TILE_SIZE);g.fillRect(710,631,TILE_SIZE,TILE_SIZE);
        g.setColor(this.color);g.fillRect(tileX+10, tileY+31, TILE_SIZE, TILE_SIZE);
        g.setColor(Color.BLACK);
        for (int i=31; i<=931 ;i+=100){
            for(int j=8;j<=958;j+=100){
                if(i<=681&&j<=900) {
                    g.fillRect(j, i, 2, 100);
                    g.fillRect(j, i, 100, 2);
                }  if(i==731&&j<908){
                    g.fillRect(j, i, 100, 2);
                }
                if(i<731&&j==900){
                    g.fillRect(j, i, 2, 102);
                }

            }
        }


    }


}
