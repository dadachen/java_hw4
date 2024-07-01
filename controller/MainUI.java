package controller;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Member;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI(new Member());
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
	public MainUI(Member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBorrow = new JButton("借書");
		btnBorrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LibraryUI lu=new LibraryUI(m);
				lu.setVisible(true);
				dispose();
			}
		});
		btnBorrow.setFont(new Font("新細明體", Font.PLAIN, 30));
		btnBorrow.setBounds(113, 36, 242, 95);
		contentPane.add(btnBorrow);
		
		JButton btnReturn = new JButton("還書");
		btnReturn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ReturnUI ru=new ReturnUI(m);
				ru.setVisible(true);
				dispose();
			}
		});
		btnReturn.setFont(new Font("新細明體", Font.PLAIN, 30));
		btnReturn.setBounds(113, 180, 242, 95);
		contentPane.add(btnReturn);
		
		JButton btnLogout = new JButton("登出");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI lu = new LoginUI();
				lu.setVisible(true);
				dispose();
			}
		});
		btnLogout.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnLogout.setBounds(406, 409, 94, 33);
		contentPane.add(btnLogout);
		
		JButton btnQuery = new JButton("查詢");
		btnQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QueryUI qu=new QueryUI(m);
				qu.setVisible(true);
				dispose();
			}
		});
		btnQuery.setFont(new Font("新細明體", Font.PLAIN, 30));
		btnQuery.setBounds(113, 317, 242, 95);
		contentPane.add(btnQuery);
	}
}
