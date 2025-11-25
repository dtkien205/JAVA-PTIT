package view;

import javax.swing.*;
import java.awt.*;

/**
 * PanelLopHoc - Giao diện lập lớp học
 */
public class PanelLopHoc extends JPanel {
    private JTextField txtMaMon;
    private JButton btnLapLopTheoMon, btnLapToanBoLop;
    private JTextArea txtDanhSach;
    private JScrollPane scrollPane;

    public PanelLopHoc() {
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
                BorderFactory.createLineBorder(new Color(0, 150, 136), 2),
                "LẬP DANH SÁCH LỚP HỌC",
                0, 0, new Font("Arial", Font.BOLD, 14), new Color(0, 150, 136)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Mã môn học
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Mã môn học:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        txtMaMon = new JTextField(30);
        panel.add(txtMaMon, gbc);

        // Panel buttons
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        btnLapLopTheoMon = new JButton("Lập lớp theo môn học");
        btnLapLopTheoMon.setBackground(new Color(0, 150, 136));
        btnLapLopTheoMon.setForeground(Color.BLACK);
        btnLapLopTheoMon.setFocusPainted(false);

        btnLapToanBoLop = new JButton("Lập toàn bộ lớp học");
        btnLapToanBoLop.setBackground(new Color(0, 150, 136));
        btnLapToanBoLop.setForeground(Color.BLACK);
        btnLapToanBoLop.setFocusPainted(false);

        panelButtons.add(btnLapLopTheoMon);
        panelButtons.add(btnLapToanBoLop);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(panelButtons, gbc);

        return panel;
    }

    private JPanel createListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 150, 136), 2),
                "DANH SÁCH LỚP HỌC",
                0, 0, new Font("Arial", Font.BOLD, 14), new Color(0, 150, 136)));

        txtDanhSach = new JTextArea();
        txtDanhSach.setEditable(false);
        txtDanhSach.setFont(new Font("Consolas", Font.PLAIN, 12));

        scrollPane = new JScrollPane(txtDanhSach);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // Getters
    public JTextField getTxtMaMon() {
        return txtMaMon;
    }

    public JButton getBtnLapLopTheoMon() {
        return btnLapLopTheoMon;
    }

    public JButton getBtnLapToanBoLop() {
        return btnLapToanBoLop;
    }

    public JTextArea getTxtDanhSach() {
        return txtDanhSach;
    }
}
