import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numeroBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);
        //array que guarda las bolas
        ArrayList<BouncingBall> arrayBolas = new ArrayList<>();

        // crate and show the balls
        for(int i = 0; i < numeroBolas; i++)
        {
            Random aleatorio = new Random();
            int radio =  aleatorio.nextInt(100);

            int red =  aleatorio.nextInt(256);
            int green =  aleatorio.nextInt(256);
            int blue =  aleatorio.nextInt(256);

            int x =  aleatorio.nextInt(220);
            int y =  aleatorio.nextInt(210);


            arrayBolas.add(new BouncingBall(x, y, radio, new Color(red,green,blue), ground, myCanvas));
            arrayBolas.get(i).draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(BouncingBall elemento : arrayBolas)
            {
                elemento.move();
                // stop once ball has travelled a certain distance on x axis
                if(elemento.getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
    
    /**
     * dibujar un rectángulo sin relleno en la pantalla y dentro tantas bolas como se indiquen 
     * 
     */
    public void boxBounce(int numeroBolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, 400, 550, 400);
        myCanvas.drawLine(50, 400, 50, 0);
        myCanvas.drawLine(550, 0, 50, 0);
        myCanvas.drawLine(550, 0, 550, 400);
        //array que guarda las bolas
        ArrayList<BoxBall> arrayBolas = new ArrayList<>();

        // crate and show the balls
        for(int i = 0; i < numeroBolas; i++)
        {
            Random aleatorio = new Random();
            int radio =  aleatorio.nextInt(100);

            int red =  aleatorio.nextInt(256);
            int green =  aleatorio.nextInt(256);
            int blue =  aleatorio.nextInt(256);

            int x =  aleatorio.nextInt(220);
            int y =  aleatorio.nextInt(210);


            arrayBolas.add(new BoxBall(x, y, radio, new Color(red,green,blue), ground, myCanvas));
            arrayBolas.get(i).draw();
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(BoxBall elemento : arrayBolas)
            {
                elemento.move();
                // stop once ball has travelled a certain distance on x axis
                if(elemento.getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
    
}
