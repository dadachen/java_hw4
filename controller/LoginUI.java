package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import dao.impl.MemberDaoImpl;
import model.Member;

public class LoginUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField account;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginUI frame = new LoginUI();
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
    public LoginUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("超微型圖書館");
        lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 26));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(105, 10, 208, 49);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("帳號:");
        lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(104, 83, 62, 31);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("密碼:");
        lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(104, 136, 62, 31);
        contentPane.add(lblNewLabel_1_1);
        
        account = new JTextField();
        account.setBounds(159, 88, 100, 21);
        contentPane.add(account);
        account.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(159, 141, 100, 21);
        contentPane.add(passwordField);
        
        JButton btnNewButton = new JButton("登入");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String Account = account.getText();
                Member m = new MemberDaoImpl().checkAccount(Account);
                if (m != null) {
                    String Password = new String(passwordField.getPassword());
                    if (m.getPassword().equals(Password)) {
                        String level = "";
                        switch (m.getLevel()) {
                            case "gold":
                                level = "金級會員";
                                break;
                            case "silver":
                                level = "銀級會員";
                                break;
                            case "bronze":
                                level = "銅級會員";
                                break;
                            default:
                                level = "普通會員";
                                break;
                        }
                        
                        JOptionPane.showMessageDialog(null, level + ": " + Account + " 您好!\n歡迎登入", "登入成功", JOptionPane.PLAIN_MESSAGE);
                        MainUI mu = new MainUI(m);
                        mu.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "密碼不正確", "登入失敗", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "帳號不存在", "登入失敗", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(105, 193, 87, 23);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("註冊");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddMember am = new AddMember();
                am.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setBounds(226, 193, 87, 23);
        contentPane.add(btnNewButton_1);
        
        JLabel time = new JLabel("");
        time.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
        time.setBounds(262, 237, 174, 26);
        time.setForeground(Color.GRAY);
        contentPane.add(time);
        setTimer(time);
        
        JButton btnNewButton_2 = new JButton("管理者登入");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ManagerLoginUI mlu = new ManagerLoginUI();
                mlu.setVisible(true);
                dispose();
            }
        });
        btnNewButton_2.setBounds(10, 237, 117, 23);
        contentPane.add(btnNewButton_2);
    }
    
    private void setTimer(JLabel time) {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long currentTime = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                time.setText("現在時間：" + sdf.format(new Date(currentTime)));
            }
        });
        timer.start();
    }
}
