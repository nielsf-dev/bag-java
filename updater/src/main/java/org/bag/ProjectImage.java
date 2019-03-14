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
    public ProjectImage() {
        initComponents();
    }

    private void frontpageActionPerformed(ActionEvent e) {
        // TODO add your code here
        Object source = e.getSource();
        JCheckBox checkBox = (JCheckBox)source;
        System.out.println("action" + checkBox.isSelected());
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        imageDrawer1 = new ImageDrawer();
        frontpage = new JCheckBox();
        banner = new JCheckBox();
        hidden = new JCheckBox();

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
            "[]"));
        add(imageDrawer1, "cell 0 0,grow");

        //---- frontpage ----
        frontpage.setText("Voorpagina");
        frontpage.addActionListener(e -> frontpageActionPerformed(e));
        add(frontpage, "cell 0 1");

        //---- banner ----
        banner.setText("Banner");
        add(banner, "cell 0 2");

        //---- hidden ----
        hidden.setText("Hidden");
        add(hidden, "cell 0 3");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private ImageDrawer imageDrawer1;
    private JCheckBox frontpage;
    private JCheckBox banner;
    private JCheckBox hidden;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
