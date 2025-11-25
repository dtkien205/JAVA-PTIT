package view;

import javax.swing.*;
import java.awt.*;

/**
 * PanelMonHoc - Giao diện quản lý môn học
 */
public class PanelMonHoc extends JPanel {
    private JTextField txtTenMon, txtSoTiet;
    private JComboBox<String> cboLoaiMon;
    private JButton btnThem, btnXoa, btnLamMoi;
    private JTextArea txtDanhSach;
    private JScrollPane scrollPane;

    public PanelMonHoc() {
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
                BorderFactory.createLineBorder(Color.BLACK, 2),
                "THÊM MÔN HỌC MỚI",
                0, 0, new Font("Arial", Font.BOLD, 14), Color.BLACK));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Tên môn học
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Tên môn học:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtTenMon = new JTextField(30);
        panel.add(txtTenMon, gbc);

        // Tổng số tiết
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        panel.add(new JLabel("Tổng số tiết:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtSoTiet = new JTextField(30);
        panel.add(txtSoTiet, gbc);

        // Loại môn học
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        panel.add(new JLabel("Loại môn học:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        String[] loaiMon = { "Đại cương", "Cơ sở ngành", "Chuyên ngành bắt buộc", "Chuyên ngành tự chọn" };
        cboLoaiMon = new JComboBox<>(loaiMon);
        panel.add(cboLoaiMon, gbc);

        // Panel buttons
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnThem = new JButton("Thêm môn học");
        btnThem.setBackground(new Color(76, 175, 80));
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
                BorderFactory.createLineBorder(Color.BLACK, 2),
                "DANH SÁCH MÔN HỌC",
                0, 0, new Font("Arial", Font.BOLD, 14), Color.BLACK));

        txtDanhSach = new JTextArea();
        txtDanhSach.setEditable(false);
        txtDanhSach.setFont(new Font("Consolas", Font.PLAIN, 12));

        scrollPane = new JScrollPane(txtDanhSach);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Getters
    public JTextField getTxtTenMon() {
        return txtTenMon;
    }

    public JTextField getTxtSoTiet() {
        return txtSoTiet;
    }

    public JComboBox<String> getCboLoaiMon() {
        return cboLoaiMon;
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
