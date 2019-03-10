/*
 * Created by JFormDesigner on Fri Mar 08 23:27:44 CET 2019
 */

package updaterpck;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.intellij.uiDesigner.core.*;
import net.miginfocom.swing.*;

/**
 * @author Niels
 */
public class MainPanel extends JPanel {
    public MainPanel() {
        initComponents();
    }

    private void addButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        LayoutManager layout = formPanel.getLayout();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        button3 = new JButton();
        button2 = new JButton();
        separator2 = new JSeparator();
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
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();

        //======== this ========
        setPreferredSize(new Dimension(600, 500));
        setMinimumSize(new Dimension(600, 500));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "fill,hidemode 3",
            // columns
            "[min!]" +
            "[190!]" +
            "[min!]" +
            "[fill]",
            // rows
            "[min!,top]" +
            "[]"));

        //---- button3 ----
        button3.setText("Project toevoegen");
        button3.setIcon(new ImageIcon("/home/niels/src/bag-java/updater/src/main/resources/add.png"));
        add(button3, "cell 0 0,align left top,grow 0 0");

        //---- button2 ----
        button2.setText("Synchroniseren");
        button2.setIcon(new ImageIcon("/home/niels/src/bag-java/updater/src/main/resources/refresh.png"));
        button2.setEnabled(false);
        add(button2, "cell 1 0,align left top,grow 0 0");

        //---- separator2 ----
        separator2.setOrientation(SwingConstants.VERTICAL);
        add(separator2, "cell 2 0 1 2,growy");

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
        add(formPanel, "cell 3 0 1 2,gapx null 0,gapy 0");

        //======== scrollPane1 ========
        {
            scrollPane1.setBorder(null);

            //---- list1 ----
            list1.setModel(new AbstractListModel<String>() {
                String[] values = {
                    "AZ Stadion",
                    "City Garden",
                    "Xhin Zhao",
                    "COOP",
                    "KSH Service Hotel"
                };
                @Override
                public int getSize() { return values.length; }
                @Override
                public String getElementAt(int i) { return values[i]; }
            });
            list1.setBorder(null);
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1, "cell 0 1 2 1,grow");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private JButton button3;
    private JButton button2;
    private JSeparator separator2;
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
    private JScrollPane scrollPane1;
    private JList<String> list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
