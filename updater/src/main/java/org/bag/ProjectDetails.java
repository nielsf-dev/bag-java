/*
 * Created by JFormDesigner on Sun Mar 10 11:54:04 CET 2019
 */

package org.bag;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.miginfocom.swing.*;
import org.bag.domain.Project;


/**
 * @author Niels
 */
public class ProjectDetails extends JPanel {
    public ProjectDetails() {
        initComponents();
    }

    public void setProject(Project project){
        this.add(new ProjectText(project, ProjectText.ProjectTextType.Title),"cell 0 0, growx");
        this.add(new ProjectText(project, ProjectText.ProjectTextType.Location), "cell 0 1, growx");
        this.add(new ProjectText(project, ProjectText.ProjectTextType.Text), "cell 0 2, growx");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels

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
            "[]"));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
