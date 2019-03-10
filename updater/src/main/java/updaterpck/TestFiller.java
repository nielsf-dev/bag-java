/*
 * Created by JFormDesigner on Sun Mar 10 12:04:31 CET 2019
 */

package updaterpck;

import java.awt.*;
import javax.swing.*;
import net.miginfocom.swing.*;

/**
 * @author Niels
 */
public class TestFiller extends JPanel {
    public TestFiller() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Niels
        button1 = new JButton();

        //======== this ========
        setBackground(new Color(88, 88, 88));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new MigLayout(
            "fill,hidemode 3",
            // columns
            "[fill]",
            // rows
            "[]"));

        //---- button1 ----
        button1.setText("text");
        add(button1, "cell 0 0");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Niels
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
