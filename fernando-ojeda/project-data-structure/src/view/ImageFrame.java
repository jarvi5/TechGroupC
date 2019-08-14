package ui2.view;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageFrame implements Border {

    private BufferedImage image = null;

    public ImageFrame(BufferedImage pImagen) {
        image = pImagen;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (image != null) {
            g.drawImage(image, 0, 0, width, 100, null);
        }
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
