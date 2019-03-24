/*
 * Created by JFormDesigner on Sun Mar 10 11:54:04 CET 2019
 */

package org.bag;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import net.miginfocom.swing.*;
import org.bag.domain.Project;
import org.bag.dto.UpdaterProject;
import org.bag.dto.UpdaterProjectImage;
import org.springframework.web.client.RestTemplate;

/**
 * @author Niels
 */
public class ProjectDetails extends JPanel {

    final JFileChooser jFileChooser = new JFileChooser();
    private ArrayList<ProjectImage> projectImages;
    private ProjectText titleControl;
    private ProjectText locationControl;
    private ProjectText textControl;
    private UpdaterProject updaterProject;

    public ProjectDetails() {
        initComponents();
        projectImages = new ArrayList<>();
        plaatjesLayout.setLayout(new WrapLayout());
    }

    public void setProject(int projectId){

        if(projectId > 0) {
            RestTemplate restTemplate = new RestTemplate();
            updaterProject = restTemplate.getForObject("https://bag-java.herokuapp.com/updaterProject/" + projectId, UpdaterProject.class);
            if(updaterProject == null) {
                JOptionPane.showMessageDialog(this,"Niet gelukt project op te halen");
                return;
            }
        }
        else{
            updaterProject = new UpdaterProject();
        }

        if(titleControl != null)
            this.remove(titleControl);

        if(locationControl != null)
            this.remove(locationControl);

        if(textControl != null)
            this.remove(textControl);
        this.revalidate();
        this.repaint();

        titleControl = new ProjectText(this, updaterProject, ProjectText.ProjectTextType.Title);
        this.add(titleControl,"cell 0 0, growx");

        locationControl = new ProjectText(this, updaterProject, ProjectText.ProjectTextType.Location);
        this.add(locationControl, "cell 0 1, growx");

        textControl = new ProjectText(this, updaterProject, ProjectText.ProjectTextType.Text);
        this.add(textControl, "cell 0 2, growx");

        this.plaatjesLayout.removeAll();
        for(UpdaterProjectImage updaterProjectImage : updaterProject.getImages()){
            ProjectImage projectImage = null;
            try {
                projectImage = new ProjectImage(this, updaterProjectImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.projectImages.add(projectImage);
            this.plaatjesLayout.add(projectImage);
        }
        this.plaatjesLayout.revalidate();
        this.plaatjesLayout.repaint();

        this.revalidate();
        this.repaint();

    }

    private void button1ActionPerformed(ActionEvent e)  {
        int selecteer = jFileChooser.showDialog(this, "Selecteer");
        if(selecteer == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = jFileChooser.getSelectedFile();
                System.out.println(selectedFile.getName());

                Map config = new HashMap();
                config.put("cloud_name", "bag187");
                config.put("api_key", "926762486782314");
                config.put("api_secret", "rG5N5fhVriWEbn1YrqmXCjPnk_A");
                Cloudinary cloudinary = new Cloudinary(config);

                // om te deleten
                //cloudinary.uploader().destroy("zombie", ObjectUtils.emptyMap());
                // cloudinary.uploader().

                System.out.println("Uploading..");
                Map upload = cloudinary.uploader().upload(selectedFile, ObjectUtils.emptyMap());
                Object url = upload.get("url");
                System.out.println(url);

                UpdaterProjectImage updaterProjectImage = new UpdaterProjectImage(0,(String)url,false,false);
                updaterProject.getImages().add(updaterProjectImage);

                ProjectImage projectImage = new ProjectImage(this, updaterProjectImage);
                this.projectImages.add(projectImage);
                this.plaatjesLayout.add(projectImage);
                this.plaatjesLayout.revalidate();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex.toString());
            }
        }
    }

    public void removePlaatje(UpdaterProjectImage image){
        ProjectImage toRemove = null;
        for (ProjectImage projectImage : projectImages) {
            if(projectImage.getUrl().equalsIgnoreCase(image.getUrl())){
                this.plaatjesLayout.remove(projectImage);
                this.plaatjesLayout.revalidate();
                this.plaatjesLayout.repaint();
                this.revalidate();
                toRemove = projectImage;
            }
        }

        if(toRemove != null) {
            this.projectImages.remove(toRemove);
        }

        updaterProject.getImages().remove(image);
    }

    private void btOpslaanActionPerformed(ActionEvent e) {
        this.titleControl.bindToProject();
        this.locationControl.bindToProject();
        this.textControl.bindToProject();

        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.put("https://bag-java.herokuapp.com/updaterProject",updaterProject,UpdaterProject.class);
        restTemplate.put("https://bag-java.herokuapp.com/updaterProject",updaterProject,UpdaterProject.class);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        label1 = new JLabel();
        separator1 = new JSeparator();
        plaatjesLayout = new JPanel();
        button1 = new JButton();
        btOpslaan = new JButton();
        button3 = new JButton();

        //======== this ========
        setBackground(new Color(76, 76, 76));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
                "fillx,insets 0,novisualpadding,hidemode 3,align left top,gap 0 0",
                // columns
                "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]" +
                        "[]" +
                        "[grow]" +
                        "[]"));

        //---- label1 ----
        label1.setText("Plaatjes");
        add(label1, "cell 0 3,alignx left,growx 0,gapx 10");

        //---- separator1 ----
        separator1.setBorder(new EtchedBorder());
        add(separator1, "cell 0 3,growx");

        //======== plaatjesLayout ========
        {
            plaatjesLayout.setBackground(new Color(76, 76, 76));
            plaatjesLayout.setLayout(new FlowLayout());
        }
        add(plaatjesLayout, "cell 0 4,grow");

        //---- button1 ----
        button1.setText("Plaatje toevoegen");
        button1.addActionListener(e -> button1ActionPerformed(e));
        add(button1, "cell 0 5,alignx left,growx 0");

        //---- btOpslaan ----
        btOpslaan.setText("Opslaan");
        btOpslaan.addActionListener(e -> btOpslaanActionPerformed(e));
        add(btOpslaan, "cell 0 5");

        //---- button3 ----
        button3.setText("Annuleren");
        add(button3, "cell 0 5");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private JLabel label1;
    private JSeparator separator1;
    private JPanel plaatjesLayout;
    private JButton button1;
    private JButton btOpslaan;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
