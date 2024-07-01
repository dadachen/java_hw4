package controller;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddSuccess extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member Member = null;
					AddSuccess frame = new AddSuccess(Member);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public AddSuccess(Member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI LoginUI = new LoginUI();
				LoginUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(183, 392, 85, 23);
		contentPane.add(btnNewButton);
		
		JLabel show2 = new JLabel("");
		show2.setFont(new Font("新細明體", Font.PLAIN, 20));
		show2.setVerticalAlignment(SwingConstants.TOP);
		show2.setBounds(93, 67, 311, 247);
		contentPane.add(show2);
				
			String show="<html><body>"+m.getName()+" 您好,歡迎加入,"+
					"<br>帳號: "+m.getAccount()+
					"已建立，請重新登入"+"</body></html>";
					show2.setText(show);
	}
}