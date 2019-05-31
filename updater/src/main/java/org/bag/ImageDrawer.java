package org.bag;

import com.jformdesigner.annotations.BeanInfo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@BeanInfo(description = "My bean")
public class ImageDrawer extends JComponent {

    BufferedImage outputImage;

    public ImageDrawer() {
    }

    public void setUrl(URL url) throws Exception {
        try {
            BufferedImage read = ImageIO.read(url);
            outputImage = new BufferedImage(100, 100, read.getType());

            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(read, 0, 0, 100, 100, null);
            g2d.dispose();
        }
        catch(Exception ex){
            System.out.println("Cant read image from " + url.toString() + " -> " + ex.getMessage());
        }
    }

    public void setUrl2(URL url) throws Exception {
        BufferedImage read = ImageIO.read(url);
        outputImage = new BufferedImage(16, 16, read.getType());

        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(read, 0, 0, 16, 16, null);
        g2d.dispose();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(outputImage,0,0,this);
    }
}
