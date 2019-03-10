/*
 * Created by JFormDesigner on Sun Mar 10 20:58:28 CET 2019
 */

package org.bag;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;
import org.bag.domain.Project;

/**
 * @author Niels
 */
public class ProjectText extends JPanel {
    public enum ProjectTextType{
        Title,
        Location,
        Text
    }

    private Project project;
    private ProjectTextType projectTextType;

    public ProjectText(Project project, ProjectTextType projectTextType){
        this();
        this.project = project;
        this.projectTextType = projectTextType;
        if(projectTextType == ProjectTextType.Title)
            this.projectTextLabel.setText("Title");
        else if(projectTextType == ProjectTextType.Location)
            this.projectTextLabel.setText("Location");
        else
            this.projectTextLabel.setText("Text");
    }

    public ProjectText() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        projectTextLabel = new JLabel();
        separator1 = new JSeparator();
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        textArea3 = new JTextArea();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "fillx,hidemode 3,aligny top",
            // columns
            "[min!]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- projectTextLabel ----
        projectTextLabel.setText("text");
        add(projectTextLabel, "cell 0 0");
        add(separator1, "cell 1 0");
        add(textArea1, "cell 0 1 2 1,growx");
        add(textArea2, "cell 0 2 2 1,growx");
        add(textArea3, "cell 0 3 2 1,growx");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private JLabel projectTextLabel;
    private JSeparator separator1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
