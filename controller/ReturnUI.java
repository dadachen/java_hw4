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

public class ReturnUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField book_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ReturnUI(new Member()).setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReturnUI(Member m) {
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

		book_id = new JTextField();
		book_id.setBounds(150, 416, 104, 35);
		contentPane.add(book_id);
		book_id.setColumns(10);

		JLabel lblNewLabel = new JLabel("想還的書:");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(50, 416, 90, 33);
		contentPane.add(lblNewLabel);

		loadTableData(m);
		/*
		 * 多選 table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		 * table.getSelectionModel().addListSelectionListener(new
		 * ListSelectionListener() {
		 * 
		 * @Override public void valueChanged(ListSelectionEvent event) { if
		 * (!event.getValueIsAdjusting()) { int[] selectedRows =
		 * table.getSelectedRows(); if (selectedRows.length > 0) { StringBuilder values
		 * = new StringBuilder(); for (int selectedRow : selectedRows) { Object value =
		 * table.getValueAt(selectedRow, 0); values.append(value != null ?
		 * value.toString() : "").append(", "); } textField.setText(values.toString());
		 * } else { textField.setText(""); } } } });
		 */
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) {
						Object value = table.getValueAt(selectedRow, 1);
						book_id.setText(value != null ? value.toString() : "");
					}
				}
			}
		});

		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Member_id = m.getMember_id();
				String Book_id = book_id.getText();
				new BookDaoImpl().returnBook(Member_id, Book_id);
				JOptionPane.showMessageDialog(null, " 還書成功", "成功", JOptionPane.PLAIN_MESSAGE);
				loadTableData(m);

			}
		});
		btnNewButton.setBounds(278, 422, 87, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainUI mu = new MainUI(m);
				mu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(278, 488, 87, 23);
		contentPane.add(btnNewButton_1);
		// List<Book> bookList=new BookDaoImpl().selectAll();
	}

	private void loadTableData(Member m) {
		List<String> columnNames = new BookDaoImpl().getBookColumnNames();
		List<Object[]> data = new BookDaoImpl().getBookByMember_id(m.getMember_id());

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
