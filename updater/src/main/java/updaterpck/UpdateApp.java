package updaterpck;

import org.bag.domain.Image;
import org.bag.domain.Project;
import com.bulenkov.darcula.DarculaLaf;
import javax.swing.*;
import java.util.ArrayList;

public class UpdateApp
{
    public static void main(String[] args) throws Exception {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("test.png"));
        Project p = new Project("test","locatie","", images,0,0);
        System.out.println(p.getTitle("nl"));


        UIManager.setLookAndFeel(new DarculaLaf());

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(400, 400);
        MainPanel panel = new MainPanel();
        jFrame.setContentPane(panel);
        jFrame.setVisible(true);

//        MainFrame mainFrame = new MainFrame();
//        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainFrame.setVisible(true);
    }
}