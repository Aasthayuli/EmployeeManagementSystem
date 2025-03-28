package employee.management.system;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomePage extends JFrame {

    HomePage() {

        ImageIcon i1 = new ImageIcon("icons/home.jpg");
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(100, 10, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(100, 80, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Add();
            }
        });
        image.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(300, 80, 200, 40);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        view.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new View();
            }
        });
        image.add(view);

        JButton remove = new JButton("Remove Employee");
        remove.setBounds(600, 80, 200, 40);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Remove();
            }
        });
        image.add(remove);

        setTitle("Home");
        setSize(1120, 630);
        setLocation(250, 100);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
