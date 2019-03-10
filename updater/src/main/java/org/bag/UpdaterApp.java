package org.bag;

import com.bulenkov.iconloader.IconLoader;
import net.miginfocom.swing.MigLayout;
import com.bulenkov.darcula.DarculaLaf;
import javax.swing.*;
import java.awt.*;

public class UpdaterApp
{
    public static void main(String[] args) throws Exception {
        // Looks
        Icon icon = IconLoader.getIcon("/com/bulenkov/darcula/icons/treeNodeCollapsed.png");
        UIManager.setLookAndFeel(new DarculaLaf());
        setUIFont (new javax.swing.plaf.FontUIResource("Segoe UI",Font.PLAIN,13));

        // Main mig layout
        MigLayout migLayout = new MigLayout("fill, insets 0, gap 0 0",
                "[min!][fill]",
                "[]");
        JPanel mainPanel = new JPanel(migLayout);
        mainPanel.add(new ProjectList(),"growy, gapright 0");

        // Project details scrollable
        JScrollPane scrollPane = new JScrollPane(new ProjectDetails());
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane,"growx, growy");

        // Main frame
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1024, 800);
        jFrame.setContentPane(mainPanel);
        jFrame.setVisible(true);
    }

    public static void setUIFont (javax.swing.plaf.FontUIResource f){
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put (key, f);
        }
    }
}