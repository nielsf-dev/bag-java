package org.bag;

import com.bulenkov.iconloader.IconLoader;
import net.miginfocom.swing.MigLayout;
import com.bulenkov.darcula.DarculaLaf;
import org.bag.domain.Image;
import org.bag.domain.Project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
        ProjectDetails projectDetails = new ProjectDetails();
        Project project = new Project("detitel", "tekst", "", createImages(), 0,1);
        projectDetails.setProject(project);

        JScrollPane scrollPane = new JScrollPane(projectDetails);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane,"growx, growy");

        // Main frame
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1024, 800);
        jFrame.setContentPane(mainPanel);
        jFrame.setVisible(true);
    }


    private static ArrayList<org.bag.domain.Image> createImages() {
        ArrayList<org.bag.domain.Image> images = new ArrayList<>();
        images.add(new org.bag.domain.Image("image1.jpg"));
        images.add(new Image("image2.jpg"));
        return images;
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