package updaterpck;

import com.bulenkov.iconloader.IconLoader;
import org.bag.domain.Image;
import org.bag.domain.Project;
import com.bulenkov.darcula.DarculaLaf;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UpdateApp
{
    public static void main(String[] args) throws Exception {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("test.png"));
        Project p = new Project("test","locatie","", images,0,0);
        System.out.println(p.getTitle("nl"));

       // Icon asd = IconLoader.findIcon("asd");

        Icon icon = IconLoader.getIcon("/com/bulenkov/darcula/icons/treeNodeCollapsed.png");
        UIManager.setLookAndFeel(new DarculaLaf());

        setUIFont (new javax.swing.plaf.FontUIResource("Segoe UI",Font.PLAIN,13));

        JFrame jFrame = new JFrame();
      //  Font font = jFrame.getFont();
    //    jFrame.setFont(new Font("Arial",0,12));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1024, 800);
        MainPanel panel = new MainPanel();
        jFrame.setContentPane(panel);
        jFrame.setVisible(true);

//        MainFrame mainFrame = new MainFrame();
//        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainFrame.setVisible(true);
    }

    public static void setUIFont (javax.swing.plaf.FontUIResource f){
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put (key, f);
        }
    }
}