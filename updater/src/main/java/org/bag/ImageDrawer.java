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

    public void setUrl(String url) throws Exception {
        URL resource = new URL(url);
        BufferedImage read = ImageIO.read(resource);
        outputImage = new BufferedImage(100, 100, read.getType());

        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(read, 0, 0, 100, 100, null);
        g2d.dispose();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(outputImage,0,0,this);
    }
}
