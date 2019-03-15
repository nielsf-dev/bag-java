/*
 * Created by JFormDesigner on Sun Mar 10 11:54:04 CET 2019
 */

package org.bag;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import net.miginfocom.swing.*;
import org.bag.domain.Project;

/**
 * @author Niels
 */
public class ProjectDetails extends JPanel {
    public ProjectDetails() {
        initComponents();
        plaatjesLayout.setLayout(new WrapLayout());
    }

    public void setProject(Project project){
        this.add(new ProjectText(project, ProjectText.ProjectTextType.Title),"cell 0 0, growx");
        this.add(new ProjectText(project, ProjectText.ProjectTextType.Location), "cell 0 1, growx");
        this.add(new ProjectText(project, ProjectText.ProjectTextType.Text), "cell 0 2, growx");
    }

    private void button1ActionPerformed(ActionEvent e) {
        this.plaatjesLayout.add(new ProjectImage());
        this.plaatjesLayout.revalidate();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        label1 = new JLabel();
        separator1 = new JSeparator();
        plaatjesLayout = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
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

        //---- button2 ----
        button2.setText("Opslaan");
        add(button2, "cell 0 5");

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
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
