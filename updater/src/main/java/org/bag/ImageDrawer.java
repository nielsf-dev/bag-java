package org.bag;

import com.jformdesigner.annotations.BeanInfo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@BeanInfo(description = "My bean")
public class ImageDrawer extends JComponent {
    @Override
    public void paint(Graphics g) {
        URL resource = UpdaterApp.class.getResource("/citygardenavond.jpg");
        try {
            BufferedImage read = ImageIO.read(resource);

            BufferedImage outputImage = new BufferedImage(200, 200, read.getType());

            // scales the input image to the output image
            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(read, 0, 0, 200, 200, null);
            g2d.dispose();
            g.drawImage(outputImage,0,0,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
