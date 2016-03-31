import java.awt.*;
import java.awt.geom.*;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BoxBall 
{
    private Canvas canvas;
    private int ySpeed = 1;
    private int xSpeed = 1;
    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
   private int izquierda;
   private int derecha;
   private int arriba;
   private int abajo;
    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall (int xPos, int yPos, int ballDiameter, Color ballColor,
    int arriba,int abajo,int izquierda,int derecha, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = abajo;
        canvas = drawingCanvas;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();

        // compute new position
        ySpeed+=0;
        yPosition += ySpeed;
        
        
        xSpeed +=0;
        xPosition += xSpeed;
        
        //abajo
        if(yPosition >= (abajo-diameter))  {
            yPosition = (int)(abajo - diameter);
            ySpeed = -ySpeed ; 
        }
        //arriba
         if (yPosition <= (arriba) ) {
            yPosition = (int)(arriba + diameter);
            ySpeed = -ySpeed ; 
        }
        //izquierda
        if(xPosition >= (izquierda) && ySpeed > 0) {
            xPosition = (int)(izquierda - diameter);
            ySpeed = -ySpeed; 
        }
        //derecha
         if(xPosition >= (derecha-diameter) && ySpeed > 0) {
            xPosition = (int)(derecha - diameter);
            ySpeed = -ySpeed ; 
        }
        //         // draw again at new position
        draw();
    }

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}

    