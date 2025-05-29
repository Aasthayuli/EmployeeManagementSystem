package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Update extends JFrame implements ActionListener {

    JTextField taddress, tphone, temail, tsalary, teducation, tdesignation;
    JLabel tname, tfname, tdob, taadhaar, tempid;
    JButton update, back;
    String number;

    public Update(String number) {
        this.number = number;

        JLabel heading = new JLabel("Update Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 150, 30);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(name);

        tname = new JLabel();
        tname.setBounds(200, 150, 150, 30);
        tname.setBackground(new Color(129, 191, 218));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 150, 150, 30);
        fname.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(fname);

        tfname = new JLabel();
        tfname.setBounds(650, 150, 150, 30);
        tfname.setBackground(new Color(129, 191, 218));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 200, 150, 30);
        dob.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dob);

        tdob = new JLabel();
        tdob.setBounds(200, 200, 150, 30);
        tdob.setFont(new Font("Tahoma", Font.BOLD, 15));
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

        JLabel Phone = new JLabel("Phone No.");
        Phone.setBounds(400, 250, 150, 30);
        Phone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(Phone);

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
        education.setBounds(400, 300, 180, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(600, 300, 150, 30);
        teducation.setBackground(new Color(129, 191, 218));
        add(teducation);

        JLabel aadhar = new JLabel("Aadhaar No.");
        aadhar.setBounds(400, 350, 150, 30);
        aadhar.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(aadhar);

        taadhaar = new JLabel();
        taadhaar.setBounds(600, 350, 150, 30);
        taadhaar.setBackground(new Color(129, 191, 218));
        add(taadhaar);

        JLabel designation = new JLabel("Designation");
        designation.setBounds(50, 350, 150, 30);
        designation.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200, 350, 150, 30);
        tdesignation.setBackground(new Color(129, 191, 218));
        add(tdesignation);

        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(50, 400, 150, 30);
        empid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(empid);

        tempid = new JLabel();
        tempid.setBounds(200, 400, 150, 30);
        tempid.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        tempid.setForeground(Color.RED);
        add(tempid);

        try {
            DBConnection c = new DBConnection();
            String query = "SELECT * FROM employee WHERE empid=?";
            PreparedStatement pst = c.connection.prepareStatement(query);
            pst.setString(1, number);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("father_name"));
                tdob.setText(rs.getString("dob"));
                tsalary.setText(rs.getString("salary"));
                taddress.setText(rs.getString("address"));
                taadhaar.setText(rs.getString("aadhaar"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                teducation.setText(rs.getString("education"));
                tdesignation.setText(rs.getString("designation"));
                tempid.setText(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("UPDATE");
        update.setBounds(250, 550, 150, 40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setTitle("Update Employee Details");
        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            String salary = tsalary.getText();
            String address = taddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String designation = tdesignation.getText();

            if (salary.equals("") || address.equals("") || phone.equals("") || email.equals("")
                    || designation.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill all the details");
            } else {
                try {
                    DBConnection c = new DBConnection();
                    String query = "UPDATE employee SET salary=?, address=?, phone=?, email=?, education=?, designation=? WHERE empid=?";
                    PreparedStatement pst = c.connection.prepareStatement(query);
                    pst.setString(1, salary);
                    pst.setString(2, address);
                    pst.setString(3, phone);
                    pst.setString(4, email);
                    pst.setString(5, education);
                    pst.setString(6, designation);
                    pst.setString(7, number);

                    int rowsAffected = pst.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                        setVisible(false);
                        new HomePage();
                    } else {
                        JOptionPane.showMessageDialog(null, "Update Failed");
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } else {
            setVisible(false);
            new View();
        }
    }

    public static void main(String[] args) {
        new Update("");
    }
}
