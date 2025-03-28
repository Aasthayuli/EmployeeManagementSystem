package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    LoginPage() {

        ImageIcon img11 = new ImageIcon(
                "icons/login.png");
        Image img22 = img11.getImage().getScaledInstance(200, 180, Image.SCALE_DEFAULT);
        ImageIcon img33 = new ImageIcon(img22);
        JLabel img = new JLabel(img33);
        img.setBounds(200, 20, 200, 180);
        add(img);

        JLabel username = new JLabel("Username");
        username.setBounds(40, 230, 100, 30);
        username.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 230, 400, 35);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 280, 100, 30);
        password.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 280, 400, 35);
        add(tpassword);

        back = new JButton("BACK");
        back.setBounds(100, 350, 150, 40);
        back.setFont(new Font("Tahoma", Font.PLAIN, 18));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        login = new JButton("LOGIN");
        login.setBounds(330, 350, 150, 40);
        login.setFont(new Font("Verdana", Font.PLAIN, 18));
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        ImageIcon i11 = new ImageIcon(
                "icons/bglogin.jpg");
        Image i22 = i11.getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image = new JLabel(i33);
        image.setBounds(0, 0, 600, 500);
        add(image);

        setTitle("Login");
        setSize(600, 480);
        setLocation(450, 200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tusername.getText();
                char[] password = tpassword.getPassword();
                String pass = String.valueOf(password);

                DBConnection db = new DBConnection();
                String query = "select * from login where username= '" + username + "' and password= '" + pass + "'";
                ResultSet rs = db.statement.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new HomePage();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == back) {
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
