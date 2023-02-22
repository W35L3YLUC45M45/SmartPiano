package SupportClasses;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The type Drawable image.
 */
public class DrawableImage extends JPanel {

    // The image to render
    private BufferedImage image;

    /**
     * Instantiates a new Drawable image.
     *
     * @param path the path
     */
// Constructor with parameters
    public DrawableImage(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    @Override
    public Dimension getPreferredSize() {
        Dimension preferred = super.getPreferredSize();

        float width = image.getWidth();
        float height = image.getHeight();

        // Calculate the height needed to mantain aspect ratio
        preferred.height = Math.round(getWidth()*height/width);

        return preferred;
    }
    */

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}

