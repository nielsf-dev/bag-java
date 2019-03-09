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
        scrollPane1 = new JScrollPane();
        list1 = new JList<>();

        //======== this ========
        setBackground(new Color(255, 102, 204));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "filly,hidemode 3",
            // columns
            "[223,fill]" +
            "[fill]",
            // rows
            "[]"));

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
        add(scrollPane1, "cell 0 0,growy");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private JScrollPane scrollPane1;
    private JList<String> list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
