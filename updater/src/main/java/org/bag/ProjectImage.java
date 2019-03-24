/*
 * Created by JFormDesigner on Tue Mar 12 21:38:43 CET 2019
 */

package org.bag;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import net.miginfocom.swing.*;

/**
 * @author Niels
 */
public class ProjectImage extends JPanel {
    private Boolean frontpageSelected;
    private Boolean bannerselected;
    private String url;
    private ProjectDetails projectDetails;

    public ProjectImage(ProjectDetails projectDetails, String url) throws Exception {
        initComponents();
        this.url = url;
        this.projectDetails = projectDetails;
        this.imageDrawer1.setUrl(url);
        frontpageSelected = false;
        bannerselected = false;
    }

    private void frontpageActionPerformed(ActionEvent e) {
        if(isSelected(e)){
            frontpageSelected = true;
            hidden.setEnabled(true);
        }
        else {
            frontpageSelected = false;
            if(!bannerselected)
                hidden.setEnabled(false);
        }
    }

    public void setFrontPageChecked(Boolean checked){
        frontpage.setSelected(checked);
    }

    public void setBannerChecked(Boolean checked){
        banner.setSelected(checked);
    }

    public void setHiddenChecked(Boolean checked){
        hidden.setSelected(checked);
    }

    private void bannerActionPerformed(ActionEvent e) {
        if(isSelected(e)){
            bannerselected = true;
            hidden.setEnabled(true);
        }
        else {
            bannerselected = false;
            if(!frontpageSelected)
                hidden.setEnabled(false);
        }
    }

    private boolean isSelected(ActionEvent e) {
        Object source = e.getSource();
        JCheckBox checkBox = (JCheckBox)source;
        return checkBox.isSelected();
    }

    private void btDeleteActionPerformed(ActionEvent e) {
        projectDetails.removePlaatje(url);
    }

    public String getUrl() {
        return url;
    }

    public ProjectDetails getProjectDetails() {
        return projectDetails;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        imageDrawer1 = new ImageDrawer();
        frontpage = new JCheckBox();
        banner = new JCheckBox();
        hidden = new JCheckBox();
        btDelete = new JButton();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "fill,hidemode 3",
            // columns
            "[min!]",
            // rows
            "[100!]" +
            "[min!]" +
            "[]" +
            "[]" +
            "[]"));
        add(imageDrawer1, "cell 0 0,grow");

        //---- frontpage ----
        frontpage.setText("Voorpagina");
        frontpage.addActionListener(e -> frontpageActionPerformed(e));
        add(frontpage, "cell 0 1");

        //---- banner ----
        banner.setText("Banner");
        banner.addActionListener(e -> bannerActionPerformed(e));
        add(banner, "cell 0 2");

        //---- hidden ----
        hidden.setText("Hidden");
        hidden.setEnabled(false);
        add(hidden, "cell 0 3");

        //---- btDelete ----
        btDelete.setText("Verwijder");
        btDelete.addActionListener(e -> btDeleteActionPerformed(e));
        add(btDelete, "cell 0 4");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private ImageDrawer imageDrawer1;
    private JCheckBox frontpage;
    private JCheckBox banner;
    private JCheckBox hidden;
    private JButton btDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
