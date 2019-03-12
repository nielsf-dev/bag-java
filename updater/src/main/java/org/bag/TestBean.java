package org.bag;

import com.jformdesigner.annotations.BeanInfo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@BeanInfo(description = "My bean")
public class TestBean extends JComponent {
    @Override
    public void paint(Graphics g) {
        URL resource = UpdaterApp.class.getResource("/add.png");
        try {
            BufferedImage read = ImageIO.read(resource);
            g.drawImage(read,0,0,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
