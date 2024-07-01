package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.ManagerDaoImpl;
import model.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManagerLoginUI extends JFrame {

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
					ManagerLoginUI frame = new ManagerLoginUI();
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
	public ManagerLoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("管理者登入");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 26));
		lblNewLabel.setBounds(173, 34, 151, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(144, 107, 62, 31);
		contentPane.add(lblNewLabel_1);
		
		account = new JTextField();
		account.setColumns(10);
		account.setBounds(199, 112, 100, 21);
		contentPane.add(account);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼:");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(144, 160, 62, 31);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(199, 165, 100, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Account=account.getText();
				Manager m=new ManagerDaoImpl().checkAccount(Account);
				if(m!=null)
				{
					String Password=new String(passwordField.getPassword());
					if(m.getPassword().equals(Password))
					{					
						JOptionPane.showMessageDialog(null, Account+" 您好!\n歡迎登入", "登入成功", JOptionPane.PLAIN_MESSAGE);
						ManagerUI mu=new ManagerUI();
						mu.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "密碼不正確", "登入失敗", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "帳號不存在", "登入失敗", JOptionPane.ERROR_MESSAGE);
				}
				//new MemberDaoImpl().checkLoginInfo(Username,Password);
			}
		});
		btnNewButton.setBounds(145, 217, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI lu=new LoginUI();
				lu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(266, 217, 87, 23);
		contentPane.add(btnNewButton_1);
	}

}
