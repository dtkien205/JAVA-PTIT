
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TinhTongHaiSo extends JFrame implements ActionListener {
    private JTextField txtSo1, txtSo2, txtKetQua;
    private JButton btnTinh, btnXoa;
    private JRadioButton rdTong, rdHieu, rdTich, rdThuong;
    private ButtonGroup group;

    public TinhTongHaiSo() {
        setTitle("Tính toán hai số - GridBagLayout + Border");
        setSize(480, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ===== Layout chính =====
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== Dòng 0: Tiêu đề =====
        JLabel lblTitle = new JLabel("TÍNH TOÁN HAI SỐ", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lblTitle, gbc);

        // ===== Dòng 1: Số thứ nhất =====
        JLabel lblSo1 = new JLabel("Số thứ nhất:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblSo1, gbc);

        txtSo1 = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipady = 8;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtSo1, gbc);

        // ===== Dòng 2: Số thứ hai =====
        JLabel lblSo2 = new JLabel("Số thứ hai:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblSo2, gbc);

        txtSo2 = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtSo2, gbc);

        // ===== Dòng 3: Kết quả =====
        JLabel lblKetQua = new JLabel("Kết quả:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblKetQua, gbc);

        txtKetQua = new JTextField(15);
        txtKetQua.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtKetQua, gbc);

        // ===== Dòng 4: Panel radio có Border + GridBagLayout =====
        JPanel pnlRadios = new JPanel(new GridBagLayout());
        pnlRadios.setBorder(BorderFactory.createTitledBorder("Chọn phép toán"));
        pnlRadios.setBackground(new Color(250, 250, 250));

        GridBagConstraints gbcRadio = new GridBagConstraints();
        gbcRadio.insets = new Insets(5, 15, 5, 15);

        rdTong = new JRadioButton("Tổng", true);
        rdHieu = new JRadioButton("Hiệu");
        rdTich = new JRadioButton("Tích");
        rdThuong = new JRadioButton("Thương");

        group = new ButtonGroup();
        group.add(rdTong);
        group.add(rdHieu);
        group.add(rdTich);
        group.add(rdThuong);

        gbcRadio.gridx = 0;
        pnlRadios.add(rdTong, gbcRadio);
        gbcRadio.gridx = 1;
        pnlRadios.add(rdHieu, gbcRadio);
        gbcRadio.gridx = 2;
        pnlRadios.add(rdTich, gbcRadio);
        gbcRadio.gridx = 3;
        pnlRadios.add(rdThuong, gbcRadio);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(pnlRadios, gbc);

        // ===== Dòng 5: Hai nút chức năng =====
        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 10));
        btnTinh = new JButton("Tính");
        btnXoa = new JButton("Làm mới");

        btnTinh.addActionListener(this);
        btnXoa.addActionListener(this);

        pnlButtons.add(btnTinh);
        pnlButtons.add(btnXoa);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(pnlButtons, gbc);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnTinh) {
            try {
                double so1 = Double.parseDouble(txtSo1.getText());
                double so2 = Double.parseDouble(txtSo2.getText());
                double kq = 0;

                if (rdTong.isSelected())
                    kq = so1 + so2;
                else if (rdHieu.isSelected())
                    kq = so1 - so2;
                else if (rdTich.isSelected())
                    kq = so1 * so2;
                else if (rdThuong.isSelected()) {
                    if (so2 == 0) {
                        JOptionPane.showMessageDialog(this, "Không thể chia cho 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    kq = so1 / so2;
                }

                txtKetQua.setText(String.valueOf(kq));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi nhập", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnXoa) {
            txtSo1.setText("");
            txtSo2.setText("");
            txtKetQua.setText("");
        }
    }

    public static void main(String[] args) {
        new TinhTongHaiSo();
    }
}