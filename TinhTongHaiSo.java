import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TinhTongHaiSo extends JFrame implements ActionListener {
    private JTextField txtSo1, txtSo2, txtKetQua;
    private JButton btnTinh, btnXoa;
    private JRadioButton rdTong, rdHieu, rdTich, rdThuong;
    private ButtonGroup group;

    public TinhTongHaiSo() {
        setTitle("Two-number Calculator - GridBagLayout");
        setSize(450, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ===== Main layout =====
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 15, 10, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== Row 0: Title =====
        JLabel lblTitle = new JLabel("TWO-NUMBER CALCULATOR", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lblTitle, gbc);

        // ===== Row 1: First number =====
        JLabel lblSo1 = new JLabel("First number:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblSo1, gbc);

        txtSo1 = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtSo1, gbc);

        // ===== Row 2: Second number =====
        JLabel lblSo2 = new JLabel("Second number:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(lblSo2, gbc);

        txtSo2 = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(txtSo2, gbc);

        // ===== Row 3: Result =====
        JLabel lblKetQua = new JLabel("Result:");
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

        // ===== Row 4: Radio buttons =====
        JPanel pnlRadios = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        rdTong = new JRadioButton("Sum", true);
        rdHieu = new JRadioButton("Subtract");
        rdTich = new JRadioButton("Multiply");
        rdThuong = new JRadioButton("Divide");

        group = new ButtonGroup();
        group.add(rdTong);
        group.add(rdHieu);
        group.add(rdTich);
        group.add(rdThuong);

        pnlRadios.add(rdTong);
        pnlRadios.add(rdHieu);
        pnlRadios.add(rdTich);
        pnlRadios.add(rdThuong);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(pnlRadios, gbc);

        // ===== Row 5: Buttons =====
        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
        btnTinh = new JButton("Calculate");
        btnXoa = new JButton("Reset");

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

                if (rdTong.isSelected()) {
                    kq = so1 + so2;
                } else if (rdHieu.isSelected()) {
                    kq = so1 - so2;
                } else if (rdTich.isSelected()) {
                    kq = so1 * so2;
                } else if (rdThuong.isSelected()) {
                    if (so2 == 0) {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero!", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    kq = so1 / so2;
                }

                txtKetQua.setText(String.valueOf(kq));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers!", "Input error",
                        JOptionPane.ERROR_MESSAGE);
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
