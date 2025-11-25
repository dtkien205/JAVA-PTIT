package view;

import javax.swing.*;
import java.awt.*;

/**
 * PanelDangKy - Giao diện đăng ký môn học
 */
public class PanelDangKy extends JPanel {
    private JTextField txtMaSV, txtMaMon;
    private JButton btnDangKy, btnLamMoi;
    private JTextArea txtDanhSach;
    private JScrollPane scrollPane;

    public PanelDangKy() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        initComponents();
    }

    private void initComponents() {
        // Panel nhập liệu
        JPanel panelInput = createInputPanel();

        // Panel danh sách
        JPanel panelList = createListPanel();

        add(panelInput, BorderLayout.NORTH);
        add(panelList, BorderLayout.CENTER);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(255, 152, 0), 2),
                "ĐĂNG KÝ MÔN HỌC",
                0, 0, new Font("Arial", Font.BOLD, 14), new Color(255, 152, 0)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Mã sinh viên
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Mã sinh viên:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtMaSV = new JTextField(30);
        panel.add(txtMaSV, gbc);

        // Mã môn học
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        panel.add(new JLabel("Mã môn học:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtMaMon = new JTextField(30);
        panel.add(txtMaMon, gbc);

        // Panel buttons
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnDangKy = new JButton("Đăng ký");
        btnDangKy.setBackground(new Color(255, 152, 0));
        btnDangKy.setForeground(Color.BLACK);
        btnDangKy.setFocusPainted(false);

        btnLamMoi = new JButton("Làm mới");
        btnLamMoi.setBackground(new Color(33, 150, 243));
        btnLamMoi.setForeground(Color.BLACK);
        btnLamMoi.setFocusPainted(false);

        panelButtons.add(btnDangKy);
        panelButtons.add(btnLamMoi);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(panelButtons, gbc);

        return panel;
    }

    private JPanel createListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(255, 152, 0), 2),
                "DANH SÁCH ĐĂNG KÝ",
                0, 0, new Font("Arial", Font.BOLD, 14), new Color(255, 152, 0)));

        txtDanhSach = new JTextArea();
        txtDanhSach.setEditable(false);
        txtDanhSach.setFont(new Font("Consolas", Font.PLAIN, 12));

        scrollPane = new JScrollPane(txtDanhSach);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Getters
    public JTextField getTxtMaSV() {
        return txtMaSV;
    }

    public JTextField getTxtMaMon() {
        return txtMaMon;
    }

    public JButton getBtnDangKy() {
        return btnDangKy;
    }

    public JButton getBtnLamMoi() {
        return btnLamMoi;
    }

    public JTextArea getTxtDanhSach() {
        return txtDanhSach;
    }
}
