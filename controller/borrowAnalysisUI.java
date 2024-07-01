package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import dao.impl.RecordDaoImpl;

public class borrowAnalysisUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    borrowAnalysisUI frame = new borrowAnalysisUI();
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
    public borrowAnalysisUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        Map<String, Integer> borrowCounts = new RecordDaoImpl().getBorrowCounts();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : borrowCounts.entrySet()) {
            dataset.addValue(entry.getValue(), "Borrow Counts", entry.getKey());
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Book Borrow Counts",
                "Book ID",
                "Counts",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(770, 570));
        contentPane.add(chartPanel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        contentPane.add(panel, BorderLayout.SOUTH);

        JButton backButton = new JButton("回上一頁");
        backButton.addActionListener(e -> {
        	ManagerUI mu = new ManagerUI();
            mu.setVisible(true);
            dispose();
        });
        panel.add(backButton);
    }

}
