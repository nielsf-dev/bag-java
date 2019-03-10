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
    private Project project;
    public ProjectDetails() {
        initComponents();

      //  this.project = project;
    }

    class ProjectTextField extends JTextField{
        private Project project;

        public ProjectTextField(int arg, Project project) {
            super(arg);
            this.project = project;
            addFocusListener(new FocusAdapter() {
                @Override
                public void focusLost(FocusEvent e) {
                    System.out.println("focus lost");
                    writeToModel();
                }
            });
        }

        public void writeToModel() {
        }
    }

    private void addButtonMouseClicked(MouseEvent e) {
    }

    private void textField2FocusLost(FocusEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        label1 = new JLabel();
        separator1 = new JSeparator();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        label2 = new JLabel();
        separator3 = new JSeparator();
        textField5 = new JTextField();
        textField6 = new JTextField();
        textField7 = new JTextField();
        label3 = new JLabel();
        separator4 = new JSeparator();
        textField8 = new JTextField();
        textField9 = new JTextField();
        textField10 = new JTextField();
        label4 = new JLabel();
        separator5 = new JSeparator();
        textField11 = new JTextField();
        addButton = new JButton();

        //======== this ========
        setBackground(new Color(80, 79, 79));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "fill,insets 0,hidemode 3,align left top,gap 8 8",
            // columns
            "[min!,fill]10" +
            "[208:34,fill]",
            // rows
            "[min!]" +
            "[]" +
            "[]" +
            "[]" +
            "[30:30:30]" +
            "[min!]" +
            "[]" +
            "[]" +
            "[]" +
            "[30:30:30]" +
            "[min!]" +
            "[]" +
            "[]" +
            "[]" +
            "[30:30:30]" +
            "[min!]" +
            "[]"));

        //---- label1 ----
        label1.setText("Titel");
        add(label1, "cell 0 0");
        add(separator1, "cell 1 0");

        //---- textField2 ----
        textField2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                textField2FocusLost(e);
            }
        });
        add(textField2, "cell 0 1 2 1");
        add(textField3, "cell 0 2 2 1");
        add(textField4, "cell 0 3 2 1,growx");

        //---- label2 ----
        label2.setText("Locatie");
        add(label2, "cell 0 5");
        add(separator3, "cell 1 5,growx");
        add(textField5, "cell 0 6 2 1,growx");
        add(textField6, "cell 0 7 2 1,growx");
        add(textField7, "cell 0 8 2 1,growx");

        //---- label3 ----
        label3.setText("Text");
        add(label3, "cell 0 10");
        add(separator4, "cell 1 10,growx");
        add(textField8, "cell 0 11 2 1,growx");
        add(textField9, "cell 0 12 2 1,growx");

        //---- textField10 ----
        textField10.setText("Chinese");
        add(textField10, "cell 0 13 2 1,growx");

        //---- label4 ----
        label4.setText("Plaatjes");
        add(label4, "cell 0 15");
        add(separator5, "cell 1 15,growx");
        add(textField11, "cell 0 16 2 1,growx");

        //---- addButton ----
        addButton.setText("Add");
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addButtonMouseClicked(e);
            }
        });
        add(addButton, "cell 0 16 2 1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private JLabel label1;
    private JSeparator separator1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label2;
    private JSeparator separator3;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JLabel label3;
    private JSeparator separator4;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JLabel label4;
    private JSeparator separator5;
    private JTextField textField11;
    private JButton addButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
