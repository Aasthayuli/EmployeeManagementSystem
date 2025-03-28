package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Add extends JFrame implements ActionListener {

    Random ran = new Random();
    int num = ran.nextInt(999999);
    JTextField tname, tfname, taddress, tphone, taadhaar, temail, tsalary, tdesignation;
    JLabel tempid;
    JDateChooser tdob;
    JComboBox BoxEducation;
    JButton add, back;

    Add() {

        JLabel heading = new JLabel("Add Employee");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JTextField();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(129, 191, 218));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600, 150, 150, 30);
        tfname.setBackground(new Color(129, 191, 218));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setBackground(new Color(129, 191, 218));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 150, 30);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600, 200, 150, 30);
        tsalary.setBackground(new Color(129, 191, 218));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(50, 250, 150, 30);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200, 250, 150, 30);
        taddress.setBackground(new Color(129, 191, 218));
        add(taddress);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 150, 30);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600, 250, 150, 30);
        tphone.setBackground(new Color(129, 191, 218));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(200, 300, 150, 30);
        temail.setBackground(new Color(129, 191, 218));
        add(temail);

        JLabel education = new JLabel("Highest Education");
        education.setBounds(400, 300, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        String items[] = { "BBA", "B.Tech", "BCA", "BA", "BSC", "B.Com", "MBA", "MCA", "MA", "M.Tech", "MSC", "PHD" };
        BoxEducation = new JComboBox(items);
        BoxEducation.setBackground(new Color(129, 191, 218));
        BoxEducation.setBounds(600, 300, 150, 30);
        add(BoxEducation);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(129, 191, 218));
        add(tdesignation);

        JLabel aadhaar = new JLabel("Aadhar Number");
        aadhaar.setBounds(400, 350, 150, 30);
        aadhaar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhaar);

        taadhaar = new JTextField();
        taadhaar.setBounds(600, 350, 150, 30);
        taadhaar.setBackground(new Color(129, 191, 218));
        add(taadhaar);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel("" + num);
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        back = new JButton("BACK");
        back.setBounds(250, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        add = new JButton("ADD");
        add.setBounds(450, 550, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        setTitle("Add Employee");
        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Add();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dobText = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhaar = taadhaar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) BoxEducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empid = tempid.getText();

            if (name.equals("") || fname.equals("") || dobText.equals("") || salary.equals("") || address.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the details");
            } else {

                try {
                    DBConnection db = new DBConnection();
                    String query = "insert into employee values('" + name + "','" + fname + "','" + dobText + "','"
                            + salary
                            + "','" + address + "','" + phone + "','" + email + "','" + education + "','" + designation
                            + "','"
                            + aadhaar + "','" + empid + "')";
                    db.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Details Added Successfully !");
                    setVisible(false);
                    new HomePage();
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        } else {
            setVisible(false);
            new HomePage();
        }
    }
}
