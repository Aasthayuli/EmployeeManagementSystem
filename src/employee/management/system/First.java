package employee.management.system;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class First extends JFrame {
    First() {

        ImageIcon i1 = new ImageIcon(
                "icons/front.gif");
        Image i2 = i1.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1170, 650);
        add(image);

        JLabel title = new JLabel("Employee Management System");
        title.setBounds(340, 155, 400, 40);
        title.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(title);

        setTitle("Employee Management System");
        setSize(1170, 650);
        setLocation(200, 50);
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(5000);
            setVisible(false);
            new LoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new First();
    }
}
