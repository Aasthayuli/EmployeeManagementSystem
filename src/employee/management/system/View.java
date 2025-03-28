package employee.management.system;

import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;

public class View extends JFrame implements ActionListener {
    Choice choiceEMP;
    JTable table;
    JButton searchbtn, print, update, back;

    public View() {

        getContentPane().setBackground(new Color(129, 191, 218));
        JLabel search = new JLabel("Search by employee id");
        search.setBounds(20, 20, 150, 20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180, 20, 150, 20);
        add(choiceEMP);

        try {
            DBConnection c = new DBConnection();
            ResultSet resultset = c.statement.executeQuery("select * from employee");
            while (resultset.next()) {
                choiceEMP.add(resultset.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        try {
            DBConnection c = new DBConnection();
            ResultSet resultset = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultset));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 600);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20, 70, 80, 20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn) {
            String query = "select * from employee where empid='" + choiceEMP.getSelectedItem() + "'";
            try {
                DBConnection c = new DBConnection();
                ResultSet resultset = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultset));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (e.getSource() == update) {
            setVisible(false);
            new Update(choiceEMP.getSelectedItem());
            try {

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            setVisible(false);
            new HomePage();
        }
    }

    public static void main(String[] args) {
        new View();
    }
}
