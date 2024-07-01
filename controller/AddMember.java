package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DbConnection;
import dao.impl.MemberDaoImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import junit.runner.Version;
import model.Member;

import com.jgoodies.common.base.Objects;
import com.toedter.calendar.JDateChooser;

public class AddMember extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextField account;
    private JTextField address;
    private JPasswordField passwordField;
    private JTextField phone;
    private JTextField identity;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddMember frame = new AddMember();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AddMember() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 547, 456);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("姓名：");
        lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 16));
        lblNewLabel.setBounds(52, 96, 53, 20);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("帳號：");
        lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(52, 142, 53, 20);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("密碼：");
        lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 16));
        lblNewLabel_2.setBounds(52, 192, 53, 20);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("地址：");
        lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 16));
        lblNewLabel_3.setBounds(52, 241, 53, 20);
        contentPane.add(lblNewLabel_3);

        name = new JTextField();
        name.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        name.setBounds(114, 96, 140, 21);
        contentPane.add(name);
        name.setColumns(10);

        account = new JTextField();
        account.setFont(new Font("Verdana", Font.PLAIN, 14));
        account.setColumns(10);
        account.setBounds(114, 142, 140, 21);
        contentPane.add(account);

        address = new JTextField();
        address.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        address.setColumns(10);
        address.setBounds(114, 241, 140, 21);
        contentPane.add(address);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Verdana", Font.PLAIN, 14));
        passwordField.setBounds(114, 192, 140, 20);
        contentPane.add(passwordField);

        JLabel lblNewLabel_4 = new JLabel("註冊頁面");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("微軟正黑體", Font.PLAIN, 30));
        lblNewLabel_4.setBounds(152, 10, 187, 57);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_3_1 = new JLabel("電話：");
        lblNewLabel_3_1.setFont(new Font("新細明體", Font.PLAIN, 16));
        lblNewLabel_3_1.setBounds(52, 283, 53, 20);
        contentPane.add(lblNewLabel_3_1);

        phone = new JTextField();
        phone.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        phone.setColumns(10);
        phone.setBounds(114, 283, 140, 21);
        contentPane.add(phone);

        JLabel lblNewLabel_5 = new JLabel("身分證字號：");
        lblNewLabel_5.setFont(new Font("新細明體", Font.PLAIN, 16));
        lblNewLabel_5.setBounds(284, 96, 103, 20);
        contentPane.add(lblNewLabel_5);

        identity = new JTextField();
        identity.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        identity.setColumns(10);
        identity.setBounds(387, 95, 116, 21);
        contentPane.add(identity);

        JLabel lblNewLabel_6 = new JLabel("性別：");
        lblNewLabel_6.setFont(new Font("新細明體", Font.PLAIN, 16));
        lblNewLabel_6.setBounds(284, 142, 53, 20);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("生日：");
        lblNewLabel_7.setFont(new Font("新細明體", Font.PLAIN, 16));
        lblNewLabel_7.setBounds(284, 192, 53, 20);
        contentPane.add(lblNewLabel_7);

        JComboBox<String> gender = new JComboBox<String>();
        gender.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        gender.addItem("請選擇");
        gender.addItem("男");
        gender.addItem("女");
        gender.setBounds(347, 142, 72, 23);
        contentPane.add(gender);

        JDateChooser birthday = new JDateChooser();
        birthday.setBounds(347, 192, 136, 21);
        contentPane.add(birthday);

        JButton btnNewButton = new JButton("確定");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String Name = name.getText();
                String Account = account.getText();
                String Password = new String(passwordField.getPassword());
                String Address = address.getText();
                String Phone = phone.getText();
                String Identity = identity.getText();
                String Gender = (String) gender.getSelectedItem();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String Birthday = df.format(birthday.getDate());
                String Date = df.format(new Date());
                Member m = new Member(Identity, Account, Password, Name, Birthday, Gender, Date, Address, Phone);
                try {
                    Connection conn = DbConnection.getDb();
                    String SQL = "SELECT account FROM member WHERE account=?";
                    PreparedStatement ps = conn.prepareStatement(SQL);
                    ps.setString(1, Account);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(contentPane, "帳號重複", "錯誤訊息", JOptionPane.ERROR_MESSAGE);
                    } else {
                        new MemberDaoImpl().add(m);
                        AddSuccess s = new AddSuccess(m);
                        s.setVisible(true);
                        dispose();
                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
        btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        btnNewButton.setBounds(176, 328, 85, 23);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("回上一頁");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		LoginUI lu = new LoginUI();
                lu.setVisible(true);
                dispose();
        	}
        });
        btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        btnNewButton_1.setBounds(355, 384, 103, 23);
        contentPane.add(btnNewButton_1);
    }
}
