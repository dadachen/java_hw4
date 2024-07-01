package controller;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dao.DbConnection;
import dao.impl.BookDaoImpl;
import dao.impl.MemberDaoImpl;
import model.Book;
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
import java.text.SimpleDateFormat;

public class QueryUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new QueryUI(new Member()).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QueryUI(Member m) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 552);
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

		loadTableData(m);

		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainUI mu = new MainUI(m);
				mu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(375, 416, 87, 23);
		contentPane.add(btnNewButton_1);
		// List<Book> bookList=new BookDaoImpl().selectAll();
	}

	private void loadTableData(Member m) {
		List<String> columnNames = new BookDaoImpl().getRecordColumnNames();
		List<Object[]> data = new BookDaoImpl().getRecordByMember_id(m.getMember_id());

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
