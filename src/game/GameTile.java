package game;


import java.awt.*;

public class GameTile {
        public static final int TILE_SIZE = 100;
        private int row;
        private int col;
        private int tileSize;


        public GameTile(int row, int col) {

            this.row = row;
            this.col = col;
            this.tileSize = 100;

        }
    public void render(Graphics g) {
        /**
         *
         * @author Vasil
         * @param "това е визуализирането на бойното поле със съответния му цвят и параметри за изчисляването на големината му"
         */
        int tileX = this.col * this.tileSize;
        int tileY = this.row * this.tileSize;
        g.setColor(Color.GRAY);
        g.fillRect(10,31,900,700);
        g.fillRect(1010,225,300,225);
        g.setColor(Color.WHITE);
        g.fillRect(10,231,900,300);
        g.setColor(Color.red);
        g.fillRect(10,31,TILE_SIZE,TILE_SIZE);g.fillRect(210,31,TILE_SIZE,TILE_SIZE);g.fillRect(410,31,TILE_SIZE,TILE_SIZE);
        g.fillRect(610,31,TILE_SIZE,TILE_SIZE);g.fillRect(810,31,TILE_SIZE,TILE_SIZE);
        g.fillRect(10,631,TILE_SIZE,TILE_SIZE);g.fillRect(210,631,TILE_SIZE,TILE_SIZE);g.fillRect(410,631,TILE_SIZE,TILE_SIZE);g.fillRect(610,631,TILE_SIZE,TILE_SIZE);g.fillRect(810,631,TILE_SIZE,TILE_SIZE);g.fillRect(110,131,TILE_SIZE,TILE_SIZE);
        g.fillRect(310,131,TILE_SIZE,TILE_SIZE);g.fillRect(510,131,TILE_SIZE,TILE_SIZE);
        g.fillRect(710,131,TILE_SIZE,TILE_SIZE);g.fillRect(110,531,TILE_SIZE,TILE_SIZE);
        g.fillRect(310,531,TILE_SIZE,TILE_SIZE);g.fillRect(510,531,TILE_SIZE,TILE_SIZE); g.fillRect(710,531,TILE_SIZE,TILE_SIZE);

        g.setColor(Color.BLACK);
        g.fillRect(1010,275,300,3);
        for (int i=31; i<=731 ;i+=100){
            for(int j=8;j<=908;j+=100){
                if(j<908&&i<731) {
                    g.fillRect(j, i, 2, 100);
                    g.fillRect(j, i, 100, 2);
                }
                if(j==908&&i<731){
                    g.fillRect(j, i, 2, 102);
                }
                if(j<908&&i==731){
                    g.fillRect(j, i, 102, 2);
                }

            }
        }
    }


}
