package view;

import javax.swing.*;
import java.awt.*;

/**
 * PanelSapXep - Giao diện sắp xếp danh sách đăng ký
 */
public class PanelSapXep extends JPanel {
    private JButton btnSapXepTheoTen, btnSapXepTheoThoiGian;
    private JTextArea txtDanhSach;
    private JScrollPane scrollPane;

    public PanelSapXep() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        initComponents();
    }

    private void initComponents() {
        // Panel buttons
        JPanel panelButtons = createButtonPanel();

        // Panel danh sách
        JPanel panelList = createListPanel();

        add(panelButtons, BorderLayout.NORTH);
        add(panelList, BorderLayout.CENTER);
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(156, 39, 176), 2),
                "TÙY CHỌN SẮP XẾP",
                0, 0, new Font("Arial", Font.BOLD, 14), new Color(156, 39, 176)));

        btnSapXepTheoTen = new JButton("Sắp xếp theo Tên sinh viên");
        btnSapXepTheoTen.setBackground(new Color(156, 39, 176));
        btnSapXepTheoTen.setForeground(Color.BLACK);
        btnSapXepTheoTen.setFocusPainted(false);
        btnSapXepTheoTen.setPreferredSize(new Dimension(220, 35));

        btnSapXepTheoThoiGian = new JButton("Sắp xếp theo Thời gian đăng ký");
        btnSapXepTheoThoiGian.setBackground(new Color(156, 39, 176));
        btnSapXepTheoThoiGian.setForeground(Color.BLACK);
        btnSapXepTheoThoiGian.setFocusPainted(false);
        btnSapXepTheoThoiGian.setPreferredSize(new Dimension(220, 35));

        panel.add(btnSapXepTheoTen);
        panel.add(btnSapXepTheoThoiGian);

        return panel;
    }

    private JPanel createListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(156, 39, 176), 2),
                "KẾT QUẢ SẮP XẾP",
                0, 0, new Font("Arial", Font.BOLD, 14), new Color(156, 39, 176)));

        txtDanhSach = new JTextArea();
        txtDanhSach.setEditable(false);
        txtDanhSach.setFont(new Font("Consolas", Font.PLAIN, 12));

        scrollPane = new JScrollPane(txtDanhSach);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Getters
    public JButton getBtnSapXepTheoTen() {
        return btnSapXepTheoTen;
    }

    public JButton getBtnSapXepTheoThoiGian() {
        return btnSapXepTheoThoiGian;
    }

    public JTextArea getTxtDanhSach() {
        return txtDanhSach;
    }
}
