package music.visibility;

import music.core.Numbers;
import music.core.Point;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Render {
    private int width,height,margin;
    private int widthIn,heightIn;
    private double multiplicationX,multiplicationY;
    //-------------------------
    private BufferedImage image;
    private Graphics2D g;
    //-----------------
    private int step = 0;

    public Render(int width, int height, int margin) {
        this.width = width;
        this.height = height;
        this.margin = margin;

        this.widthIn = width - 2 * margin;
        this.heightIn = height - 2 * margin;

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = image.createGraphics();
    }

    // get -----
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public BufferedImage getImage(){ return image; }

    // set ------
    public void setMultiplication(double multiplicationX,double multiplicationY) {
        this.multiplicationX = multiplicationX;
        this.multiplicationY = multiplicationY;
    }

    public void setAutoMultiplicationX(int countOfPoints){
        multiplicationX = (double)widthIn/(double)countOfPoints;
    }
    public void setAutoMultiplicationY(int maxSpeed){
        multiplicationY = (double)heightIn/(double)maxSpeed;
    }

    public void process(Numbers numbers) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,width,height);

        g.setColor(Color.WHITE);
        for (Point point : numbers.getPoints()) {
            int x = (int) (point.getDistanceNow()*multiplicationX) + margin;
            int y = (int) (point.getSpeed()*multiplicationY) + margin;

            int rad = 10;
            g.fillOval(x-rad,y-rad,rad*2,rad*2);
        }
    }
}
