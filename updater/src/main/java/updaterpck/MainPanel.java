/*
 * Created by JFormDesigner on Fri Mar 08 23:27:44 CET 2019
 */

package updaterpck;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Niels
 */
public class MainPanel extends JPanel {
    public MainPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        button3 = new JButton();
        button2 = new JButton();
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
            "filly,hidemode 3",
            // columns
            "[fill]" +
            "[221:188,fill]" +
            "[308,fill]",
            // rows
            "[min!,top]" +
            "[]"));

        //---- button3 ----
        button3.setText("Project toevoegen");
        button3.setIcon(new ImageIcon("C:\\work\\bag-java\\updater\\src\\main\\resources\\add.png"));
        add(button3, "cell 0 0,align left top,grow 0 0");

        //---- button2 ----
        button2.setText("Synchroniseren");
        button2.setIcon(new ImageIcon("C:\\work\\bag-java\\updater\\src\\main\\resources\\refresh.png"));
        button2.setEnabled(false);
        add(button2, "cell 1 0,align left top,grow 0 0");

        //======== scrollPane1 ========
        {

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
            scrollPane1.setViewportView(list1);
        }
        add(scrollPane1, "cell 0 1 2 1,growy");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private JButton button3;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JList<String> list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
