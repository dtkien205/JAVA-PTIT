import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bai2DoiFont extends JFrame implements ActionListener {
    private JLabel lblText;
    private JButton btnChangeFont;

    public Bai2DoiFont() {
        setTitle("Demo JFrame & JDialog - Đổi font chữ");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        lblText = new JLabel("Tôi yêu PTIT");
        lblText.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblText);

        btnChangeFont = new JButton("Đổi font");
        btnChangeFont.addActionListener(this);
        add(btnChangeFont);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Mở dialog và gửi JLabel để cập nhật font
        new FontDialog(this, lblText);
    }

    public static void main(String[] args) {
        new Bai2DoiFont();
    }
}