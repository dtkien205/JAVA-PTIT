import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FontDialog extends JDialog implements ActionListener {
    private JComboBox<String> cbFont;
    private JComboBox<String> cbStyle;
    private JComboBox<Integer> cbSize;
    private JButton btnOK, btnCancel;
    private JLabel lblPreview;
    private JLabel targetLabel; // JLabel từ JFrame chính

    public FontDialog(JFrame parent, JLabel labelToChange) {
        super(parent, "Chọn font chữ", true); // true = modal dialog
        this.targetLabel = labelToChange;

        setSize(450, 450);
        setLocationRelativeTo(parent);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // ===== Dòng 1: Chọn font =====
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Font:"), gbc);

        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        cbFont = new JComboBox<>(fonts);
        cbFont.setSelectedItem(labelToChange.getFont().getFamily());
        gbc.gridx = 1;
        add(cbFont, gbc);

        // ===== Dòng 2: Chọn kiểu =====
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Kiểu chữ:"), gbc);

        cbStyle = new JComboBox<>(new String[] { "Bình thường", "Đậm", "Nghiêng", "Đậm & Nghiêng" });
        int style = labelToChange.getFont().getStyle();
        cbStyle.setSelectedIndex(style);
        gbc.gridx = 1;
        add(cbStyle, gbc);

        // ===== Dòng 3: Cỡ chữ =====
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        add(new JLabel("Cỡ chữ:"), gbc);

        Integer[] sizes = { 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 48 };
        cbSize = new JComboBox<>(sizes);
        cbSize.setSelectedItem(labelToChange.getFont().getSize());
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(cbSize, gbc);

        // ===== Dòng 4: Xem trước =====
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        lblPreview = new JLabel("Tôi yêu PTIT", JLabel.CENTER);
        lblPreview.setFont(labelToChange.getFont());
        add(lblPreview, gbc);

        // Thay đổi preview khi chọn khác
        cbFont.addActionListener(e -> updatePreview());
        cbStyle.addActionListener(e -> updatePreview());
        cbSize.addActionListener(e -> updatePreview());

        // ===== Dòng 5: Nút =====
        JPanel pnlButtons = new JPanel(new FlowLayout());
        btnOK = new JButton("OK");
        btnCancel = new JButton("Hủy");
        btnOK.addActionListener(this);
        btnCancel.addActionListener(this);
        pnlButtons.add(btnOK);
        pnlButtons.add(btnCancel);

        gbc.gridy = 4;
        add(pnlButtons, gbc);

        setVisible(true);
    }

    private void updatePreview() {
        String fontName = (String) cbFont.getSelectedItem();
        int style = cbStyle.getSelectedIndex();
        int Size = (Integer) cbSize.getSelectedItem();
        lblPreview.setFont(new Font(fontName, style, Size));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnOK) {
            // Gửi font được chọn về JLabel chính
            String fontName = (String) cbFont.getSelectedItem();
            int style = cbStyle.getSelectedIndex();
            int Size = (Integer) cbSize.getSelectedItem();
            Font newFont = new Font(fontName, style, Size);
            targetLabel.setFont(newFont);
            dispose();
        } else if (e.getSource() == btnCancel) {
            dispose();
        }
    }
}