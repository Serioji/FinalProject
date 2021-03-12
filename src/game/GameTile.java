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
        g.fillRect(10,100,900,700);
        g.fillRect(910,100,600,100);
        g.fillRect(910,600,600,100);
        g.setColor(Color.WHITE);
        g.fillRect(10,300,900,300);
        g.setColor(Color.red);
        g.fillRect(10,100,TILE_SIZE,TILE_SIZE);g.fillRect(210,100,TILE_SIZE,TILE_SIZE);g.fillRect(410,100,TILE_SIZE,TILE_SIZE);
        g.fillRect(610,100,TILE_SIZE,TILE_SIZE);g.fillRect(810,100,TILE_SIZE,TILE_SIZE);
        g.fillRect(10,700,TILE_SIZE,TILE_SIZE);g.fillRect(210,700,TILE_SIZE,TILE_SIZE);g.fillRect(410,700,TILE_SIZE,TILE_SIZE);g.fillRect(610,700,TILE_SIZE,TILE_SIZE);g.fillRect(810,700,TILE_SIZE,TILE_SIZE);g.fillRect(510,200,TILE_SIZE,TILE_SIZE);
        g.fillRect(310,200,TILE_SIZE,TILE_SIZE);g.fillRect(110,200,TILE_SIZE,TILE_SIZE);
        g.fillRect(110,600,TILE_SIZE,TILE_SIZE);g.fillRect(710,200,TILE_SIZE,TILE_SIZE);
        g.fillRect(310,600,TILE_SIZE,TILE_SIZE);g.fillRect(510,600,TILE_SIZE,TILE_SIZE); g.fillRect(710,600,TILE_SIZE,TILE_SIZE);

        g.setColor(Color.BLACK);
        for (int i=100; i<=800 ;i+=100){
            for(int j=10;j<=910;j+=100){
                if(j<910&&i<800) {
                    g.fillRect(j, i, 2, 100);
                    g.fillRect(j, i, 100, 2);
                }
                if(j==910&&i<800){
                    g.fillRect(j, i, 2, 102);
                }
                if(j<910&&i==800){
                    g.fillRect(j, i, 102, 2);
                }

            }
        }
    }


}
