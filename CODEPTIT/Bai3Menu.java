import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bai3Menu extends JFrame {
    private JTextField txtFile;
    private JTextArea txtContent;

    public Bai3Menu() {
        super("Bài 3");
        initUI();
    }

    private void initUI() {
        // ====== MENU BAR ======
        JMenuBar menuBar = new JMenuBar();

        JMenu mnFormat = new JMenu("Format");
        JMenuItem miFont = new JMenuItem("Font");
        JMenuItem miColor = new JMenuItem("Color");
        mnFormat.add(miFont);
        mnFormat.add(miColor);

        JMenu mnExit = new JMenu("Exit");
        JMenuItem miExit = new JMenuItem("Exit");
        mnExit.add(miExit);

        menuBar.add(mnFormat);
        menuBar.add(mnExit);
        setJMenuBar(menuBar);

        // ====== GIAO DIỆN CHÍNH ======
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel lblFile = new JLabel("File:");
        txtFile = new JTextField(25);
        JButton btnBrowse = new JButton("Browse");

        JLabel lblContent = new JLabel("Nội dung:");
        txtContent = new JTextArea(10, 30);
        txtContent.setLineWrap(true);
        txtContent.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(txtContent);

        JButton btnShow = new JButton("Hiển thị nội dung");

        // ====== SẮP XẾP LAYOUT ======
        // Dòng 1: File + textfield + Browse
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panel.add(lblFile, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        panel.add(txtFile, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panel.add(btnBrowse, gbc);

        // Dòng 2: label Nội dung
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panel.add(lblContent, gbc);

        // Dòng 2: vùng text
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(scroll, gbc);

        // Dòng 3: nút Hiển thị nội dung
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnShow, gbc);

        add(panel);

        // ====== XỬ LÝ SỰ KIỆN ======
        btnBrowse.addActionListener(this::onBrowse);
        btnShow.addActionListener(this::onShowContent);
        miColor.addActionListener(this::onChangeColor);
        miFont.addActionListener(this::onChangeFont);
        miExit.addActionListener(e -> System.exit(0));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    // Chọn file
    private void onBrowse(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            txtFile.setText(f.getAbsolutePath());
        }
    }

    // Đọc và hiển thị nội dung file
    private void onShowContent(ActionEvent e) {
        String path = txtFile.getText().trim();
        if (path.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn file!");
            return;
        }
        try {
            String content = Files.readString(Paths.get(path), StandardCharsets.UTF_8);
            txtContent.setText(content);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Không đọc được file:\n" + ex.getMessage(),
                    "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Đổi màu chữ cho nội dung
    private void onChangeColor(ActionEvent e) {
        Color c = JColorChooser.showDialog(this, "Chọn màu chữ",
                txtContent.getForeground());
        if (c != null) {
            txtContent.setForeground(c);
        }
    }

    // Đổi font cho nội dung (chỉ đổi size cho đơn giản)
    private void onChangeFont(ActionEvent e) {
        Font old = txtContent.getFont();
        String sizeStr = JOptionPane.showInputDialog(
                this,
                "Nhập cỡ chữ (ví dụ 14):",
                old.getSize());
        if (sizeStr == null)
            return; // bấm Cancel

        try {
            int size = Integer.parseInt(sizeStr);
            Font newFont = new Font(old.getFamily(), old.getStyle(), size);
            txtContent.setFont(newFont);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Cỡ chữ không hợp lệ!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai3Menu().setVisible(true));
    }
}
