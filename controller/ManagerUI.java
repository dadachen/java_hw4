package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerUI frame = new ManagerUI();
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
	public ManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("會員升等");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpgradeUI uu = new UpgradeUI();
				uu.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 30));
		btnNewButton.setBounds(150, 39, 232, 105);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("出借統計");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrowAnalysisUI ba = new borrowAnalysisUI();
				ba.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.PLAIN, 30));
		btnNewButton_1.setBounds(150, 174, 232, 105);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("登出");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagerLoginUI mlu=new ManagerLoginUI();
				mlu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnNewButton_2.setBounds(439, 375, 101, 40);
		contentPane.add(btnNewButton_2);
	}
}
