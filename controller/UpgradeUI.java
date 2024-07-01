package controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.DbConnection;
import dao.impl.ManagerDaoImpl;
import dao.impl.MemberDaoImpl;
import model.Member;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class UpgradeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField member_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new UpgradeUI().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpgradeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setBounds(64, 25, 572, 227);
		contentPane.add(table);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 62, 794, 291);
		contentPane.add(scrollPane);

		member_id = new JTextField();
		member_id.setBounds(169, 414, 104, 35);
		contentPane.add(member_id);
		member_id.setColumns(10);

		JLabel lblNewLabel = new JLabel("欲升等會員:");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 416, 123, 33);
		contentPane.add(lblNewLabel);

		loadTableData();
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						Object value = table.getValueAt(selectedRow, 1);
						member_id.setText(value != null ? value.toString() : "");
					}
				}
			}
		});

		
		
		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManagerUI mu=new ManagerUI();
				mu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(297, 490, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("會員等級:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(33, 459, 123, 33);
		contentPane.add(lblNewLabel_1);
		
		JComboBox level = new JComboBox();
		level.addItem("請選擇");
		level.addItem("gold");
		level.addItem("silver");
		level.addItem("bronze");
		level.setBounds(169, 459, 104, 23);
		contentPane.add(level);

		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String Member_id=member_id.getText();
					String Level=(String)level.getSelectedItem();
					Connection conn = DbConnection.getDb();
					String SQL = "update member set level =? where member_id=?";
					PreparedStatement ps = conn.prepareStatement(SQL);
					ps.setString(1, Level);
					ps.setString(2, Member_id);
					ps.executeUpdate();
							JOptionPane.showMessageDialog(null, "修改成功", "成功", JOptionPane.PLAIN_MESSAGE);
							loadTableData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(297, 457, 87, 23);
		contentPane.add(btnNewButton);
	}

	private void loadTableData() {
		List<String> columnNames = new ManagerDaoImpl().getMemberColumnNames();
		List<Object[]> data = new ManagerDaoImpl().getMember();

		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // can not be modified
			}
		};

		for (String columnName : columnNames) {
			model.addColumn(columnName);
		}

		for (Object[] rowData : data) {
			model.addRow(rowData);
		}

		table.setModel(model);
	}
}
