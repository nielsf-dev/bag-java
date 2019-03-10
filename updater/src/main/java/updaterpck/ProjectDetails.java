/*
 * Created by JFormDesigner on Sun Mar 10 11:54:04 CET 2019
 */

package updaterpck;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import net.miginfocom.swing.*;

/**
 * @author Niels
 */
public class ProjectDetails extends JPanel {
    public ProjectDetails() {
        initComponents();
    }

    private void addButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        formPanel = new JPanel();
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
        setBorder(new TitledBorder("Details"));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "insets 0,hidemode 3,gap 0 0",
            // columns
            "[fill]",
            // rows
            "[]"));

        //======== formPanel ========
        {
            formPanel.setLayout(new MigLayout(
                "fill,insets 0,hidemode 3,gap 8 8",
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
            formPanel.add(label1, "cell 0 0");
            formPanel.add(separator1, "cell 1 0");
            formPanel.add(textField2, "cell 0 1 2 1");
            formPanel.add(textField3, "cell 0 2 2 1");
            formPanel.add(textField4, "cell 0 3 2 1,growx");

            //---- label2 ----
            label2.setText("Locatie");
            formPanel.add(label2, "cell 0 5");
            formPanel.add(separator3, "cell 1 5,growx");
            formPanel.add(textField5, "cell 0 6 2 1,growx");
            formPanel.add(textField6, "cell 0 7 2 1,growx");
            formPanel.add(textField7, "cell 0 8 2 1,growx");

            //---- label3 ----
            label3.setText("Text");
            formPanel.add(label3, "cell 0 10");
            formPanel.add(separator4, "cell 1 10,growx");
            formPanel.add(textField8, "cell 0 11 2 1,growx");
            formPanel.add(textField9, "cell 0 12 2 1,growx");
            formPanel.add(textField10, "cell 0 13 2 1,growx");

            //---- label4 ----
            label4.setText("Plaatjes");
            formPanel.add(label4, "cell 0 15");
            formPanel.add(separator5, "cell 1 15,growx");
            formPanel.add(textField11, "cell 0 16 2 1,growx");

            //---- addButton ----
            addButton.setText("Add");
            addButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    addButtonMouseClicked(e);
                }
            });
            formPanel.add(addButton, "cell 0 16 2 1");
        }
        add(formPanel, "cell 0 0,gapx null 0,gapy 0");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private JPanel formPanel;
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
