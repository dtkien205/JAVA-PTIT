package view;

import javax.swing.*;
import java.awt.*;

/**
 * PanelSinhVien - Giao diện quản lý sinh viên
 */
public class PanelSinhVien extends JPanel {
    private JTextField txtHoTen, txtDiaChi, txtSoDT;
    private JButton btnThem, btnLamMoi;
    private JTextArea txtDanhSach;
    private JScrollPane scrollPane;

    public PanelSinhVien() {
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
                BorderFactory.createLineBorder(new Color(244, 67, 54), 2),
                "THÊM SINH VIÊN MỚI",
                0, 0, new Font("Arial", Font.BOLD, 14), new Color(244, 67, 54)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Họ tên
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Họ và tên:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtHoTen = new JTextField(30);
        panel.add(txtHoTen, gbc);

        // Địa chỉ
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        panel.add(new JLabel("Địa chỉ:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtDiaChi = new JTextField(30);
        panel.add(txtDiaChi, gbc);

        // Số điện thoại
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        panel.add(new JLabel("Số điện thoại:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtSoDT = new JTextField(30);
        panel.add(txtSoDT, gbc);

        // Panel buttons
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnThem = new JButton("Thêm sinh viên");
        btnThem.setBackground(new Color(244, 67, 54));
        btnThem.setForeground(Color.BLACK);
        btnThem.setFocusPainted(false);

        btnLamMoi = new JButton("Làm mới");
        btnLamMoi.setBackground(new Color(33, 150, 243));
        btnLamMoi.setForeground(Color.BLACK);
        btnLamMoi.setFocusPainted(false);

        panelButtons.add(btnThem);
        panelButtons.add(btnLamMoi);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(panelButtons, gbc);

        return panel;
    }

    private JPanel createListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(244, 67, 54), 2),
                "DANH SÁCH SINH VIÊN",
                0, 0, new Font("Arial", Font.BOLD, 14), new Color(244, 67, 54)));

        txtDanhSach = new JTextArea();
        txtDanhSach.setEditable(false);
        txtDanhSach.setFont(new Font("Consolas", Font.PLAIN, 12));

        scrollPane = new JScrollPane(txtDanhSach);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Getters
    public JTextField getTxtHoTen() {
        return txtHoTen;
    }

    public JTextField getTxtDiaChi() {
        return txtDiaChi;
    }

    public JTextField getTxtSoDT() {
        return txtSoDT;
    }

    public JButton getBtnThem() {
        return btnThem;
    }

    public JButton getBtnLamMoi() {
        return btnLamMoi;
    }

    public JTextArea getTxtDanhSach() {
        return txtDanhSach;
    }
}
