/*
 * Created by JFormDesigner on Sun Mar 10 20:58:28 CET 2019
 */

package org.bag;

import java.awt.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.*;
import org.bag.domain.Project;
import org.bag.dto.UpdaterProject;

/**
 * @author Niels
 */
public class ProjectText extends JPanel {
    private  ProjectDetails projectDetails = null;


    public enum ProjectTextType{
        Title,
        Location,
        Text
    }

    private UpdaterProject project;
    private ProjectTextType projectTextType;

    public ProjectText(ProjectDetails projectDetails, UpdaterProject project, ProjectTextType projectTextType){
        this();
        this.project = project;
        this.projectDetails = projectDetails;
        this.projectTextType = projectTextType;
        if(projectTextType == ProjectTextType.Title) {
            this.projectTextLabel.setText("Titel");
            this.textArea1.setText(project.getTitel_nl());
            this.textArea2.setText(project.getTitel_en());
            this.textArea3.setText(project.getTitel_zh());
        }
        else if(projectTextType == ProjectTextType.Location) {
            this.projectTextLabel.setText("Locatie");
            this.textArea1.setText(project.getLocatie_nl());
            this.textArea2.setText(project.getLocatie_en());
            this.textArea3.setText(project.getLocatie_zh());
        }
        else if(projectTextType == ProjectTextType.Text) {
            this.projectTextLabel.setText("Tekst");
            this.textArea1.setText(project.getText_nl());
            this.textArea2.setText(project.getText_nl());
            this.textArea3.setText(project.getText_zh());
        }
    }

    public void bindToProject() {
        if(projectTextType == ProjectTextType.Title) {
            project.setTitel_nl(this.textArea1.getText());
            project.setTitel_en(this.textArea2.getText());
            project.setTitel_zh(this.textArea3.getText());
        }
        else if(projectTextType == ProjectTextType.Location) {
            project.setLocatie_nl(this.textArea1.getText());
            project.setLocatie_en(this.textArea2.getText());
            project.setLocatie_zh(this.textArea3.getText());
        }
        else if(projectTextType == ProjectTextType.Text) {
            project.setText_nl(this.textArea1.getText());
            project.setText_en(this.textArea2.getText());
            project.setText_zh(this.textArea3.getText());
        }
    }

    public ProjectText() {
        initComponents();
    }

    public UpdaterProject getProject() {
        return project;
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
        setBackground(new Color(76, 76, 76));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "fillx,hidemode 3,aligny top,gapy 10",
            // columns
            "[min!]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]"));
        add(projectTextLabel, "cell 0 0");

        //---- separator1 ----
        separator1.setBorder(new EtchedBorder());
        add(separator1, "cell 1 0");

        //---- textArea1 ----
        textArea1.setBorder(new LineBorder(new Color(108, 108, 108)));
        add(textArea1, "cell 0 1 2 1,growx");

        //---- textArea2 ----
        textArea2.setBorder(new LineBorder(new Color(108, 108, 108)));
        add(textArea2, "cell 0 2 2 1,growx");

        //---- textArea3 ----
        textArea3.setBorder(new LineBorder(new Color(108, 108, 108)));
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
