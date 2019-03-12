/*
 * Created by JFormDesigner on Tue Mar 12 21:38:43 CET 2019
 */

package org.bag;

import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Niels
 */
public class ProjectImage extends JPanel {
    public ProjectImage() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        imageDrawer1 = new ImageDrawer();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();

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
            "[200!]",
            // rows
            "[200!]" +
            "[min!]"));
        add(imageDrawer1, "cell 0 0,grow");

        //---- checkBox1 ----
        checkBox1.setText("Voorpagina");
        add(checkBox1, "cell 0 1");

        //---- checkBox2 ----
        checkBox2.setText("Banner");
        add(checkBox2, "cell 0 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private ImageDrawer imageDrawer1;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
