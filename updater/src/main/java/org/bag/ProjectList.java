/*
 * Created by JFormDesigner on Fri Mar 08 23:27:44 CET 2019
 */

package org.bag;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import com.intellij.uiDesigner.core.*;
import net.miginfocom.swing.*;

class ProjectListItem{
    public int ID;
    public String Text;

    public ProjectListItem(int ID, String text) {
        this.ID = ID;
        Text = text;
    }

    @Override
    public String toString() {
        return Text;
    }
}
/**
 * @author Niels
 */
public class ProjectList extends JPanel {

    private DefaultListModel<ProjectListItem> items = new DefaultListModel<>();

    public ProjectList() {
        initComponents();

        items.addElement(new ProjectListItem(1,"Test"));
        list1.setModel(items);
    }

    private void addButtonMouseClicked(MouseEvent e) {
        // TODO add your code here

    }

    public void refresh(){
        String url = "https://bag-java.herokuapp.com/updaterProjectList";

    }

    private void btProjectToevoegenActionPerformed(ActionEvent e) {
        items.addElement(new ProjectListItem(1,"Test2"));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        btProjectToevoegen = new JButton();
        separator1 = new JSeparator();
        scrollPane1 = new JScrollPane();
        list1 = new JList();

        //======== this ========
        setPreferredSize(null);
        setMinimumSize(null);
        setMaximumSize(null);
        setBorder(null);

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "filly,insets 0,hidemode 3",
            // columns
            "[206:307]",
            // rows
            "[min!,top]" +
            "[min!]" +
            "[]"));

        //---- btProjectToevoegen ----
        btProjectToevoegen.setText("Project toevoegen");
        btProjectToevoegen.setIcon(new ImageIcon(getClass().getResource("/add.png")));
        btProjectToevoegen.addActionListener(e -> btProjectToevoegenActionPerformed(e));
        add(btProjectToevoegen, "cell 0 0,align left top,grow 0 0");
        add(separator1, "cell 0 1,growx");

        //======== scrollPane1 ========
        {
            scrollPane1.setBorder(null);

            //---- list1 ----
            list1.setBorder(null);
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1, "cell 0 2,grow");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private JButton btProjectToevoegen;
    private JSeparator separator1;
    private JScrollPane scrollPane1;
    private JList list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
