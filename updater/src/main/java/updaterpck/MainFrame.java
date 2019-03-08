/*
 * Created by JFormDesigner on Fri Mar 08 20:32:11 CET 2019
 */

package updaterpck;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Niels
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        panel1 = new JPanel();
        panel3 = new JPanel();
        button1 = new JButton();
        separator1 = new JSeparator();
        scrollPane1 = new JScrollPane();
        list1 = new JList();
        panel2 = new JPanel();
        textField1 = new JTextField();
        textArea1 = new JTextArea();
        separator2 = new JSeparator();
        textField2 = new JTextField();

        //======== this ========
        setBackground(new Color(134, 137, 139));
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]"));

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 102, 102));

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[187,fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

                //---- button1 ----
                button1.setText("text");
                panel3.add(button1);
            }
            panel1.add(panel3, "cell 0 0");
            panel1.add(separator1, "cell 0 1");

            //======== scrollPane1 ========
            {

                //---- list1 ----
                list1.setBackground(new Color(102, 102, 102));
                scrollPane1.setViewportView(list1);
            }
            panel1.add(scrollPane1, "cell 0 2");
        }
        contentPane.add(panel1, "cell 0 0");

        //======== panel2 ========
        {
            panel2.setLayout(new MigLayout(
                "hidemode 3",
                // columns
                "[fill]",
                // rows
                "[]" +
                "[]" +
                "[]"));
            panel2.add(textField1, "cell 0 0");
            panel2.add(textArea1, "cell 0 0");
            panel2.add(separator2, "cell 0 1");
            panel2.add(textField2, "cell 0 2");
        }
        contentPane.add(panel2, "cell 1 0");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private JPanel panel1;
    private JPanel panel3;
    private JButton button1;
    private JSeparator separator1;
    private JScrollPane scrollPane1;
    private JList list1;
    private JPanel panel2;
    private JTextField textField1;
    private JTextArea textArea1;
    private JSeparator separator2;
    private JTextField textField2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
