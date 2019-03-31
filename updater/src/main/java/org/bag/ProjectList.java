/*
 * Created by JFormDesigner on Fri Mar 08 23:27:44 CET 2019
 */

package org.bag;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import com.intellij.uiDesigner.core.*;
import net.miginfocom.swing.*;
import org.bag.dto.UpdaterProjectListItem;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


/**
 * @author Niels
 */
public class ProjectList extends JPanel {

    private final UpdaterApp updaterApp;
    private DefaultListModel<UpdaterProjectListItem> items = new DefaultListModel<>();

    public ProjectList(UpdaterApp updaterApp) {
        initComponents();
        this.updaterApp = updaterApp;
        list1.setModel(items);
    }

    private void addButtonMouseClicked(MouseEvent e) {
        // TODO add your code here

    }

    public UpdaterProjectListItem refresh(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<UpdaterProjectListItem>> response = restTemplate.exchange(
                UpdaterApp.getWebsiteUrl() + "/updaterProjectList",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UpdaterProjectListItem>>(){});

        items.clear();
        List<UpdaterProjectListItem> updaterProjectListItems = response.getBody();
        for (UpdaterProjectListItem updaterProjectListItem : updaterProjectListItems) {
            items.addElement(updaterProjectListItem);
        }

        if(items.size() > 0)
            return items.get(0);
        else
            return null;

    }

    private void btProjectToevoegenActionPerformed(ActionEvent e) {
        items.addElement(new UpdaterProjectListItem(1,"Test2"));
    }

    private void list1ValueChanged(ListSelectionEvent e) {
        int selectedIndex = list1.getSelectedIndex();
        UpdaterProjectListItem updaterProjectListItem = items.get(selectedIndex);
        updaterApp.viewProject(updaterProjectListItem);
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
            list1.addListSelectionListener(e -> list1ValueChanged(e));
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
