package org.bag;

import com.bulenkov.iconloader.IconLoader;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import net.miginfocom.swing.MigLayout;
import com.bulenkov.darcula.DarculaLaf;
import org.bag.domain.Image;
import org.bag.domain.Project;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UpdaterApp
{
    public static void main(String[] args) throws Exception {
        uploadImageToCloudinary();

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
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(scrollPane,"growx, growy");

        // Main frame
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1024, 800);
        jFrame.setContentPane(mainPanel);
        jFrame.setResizable(false);

        jFrame.setVisible(true);
    }

    private static void uploadImageToCloudinary() {
        //String path = "/home/niels/src/bag-java/website/src/main/resources/static/images/nl.png";
        String path = "/home/niels/src/bag-java/website/src/main/resources/static/upload/portfolio/CityGarden/citygardentuin.jpg";

        Map config = new HashMap();
        config.put("cloud_name", "bag187");
        config.put("api_key", "926762486782314");
        config.put("api_secret", "rG5N5fhVriWEbn1YrqmXCjPnk_A");
        Cloudinary cloudinary = new Cloudinary(config);

        File file = new File(path);
        try {
            System.out.println("Uploading..");
            Map params = ObjectUtils.asMap("public_id", "testbag/citygardentuin.jpg");
            Map upload = cloudinary.uploader().upload(file, params);
            Object url = upload.get("url");
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static ArrayList<Image> createImages() {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("image1.jpg"));
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