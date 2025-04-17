import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import repo.Repositories_SinhVien;
import model.SinhVien;

public class StudentManagementGUI {
    public static void main(String[] args) {
        // Tạo cửa sổ chính
        JFrame frame = new JFrame("Quản lý Sinh viên");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null); // Đặt cửa sổ vào giữa màn hình

        // Thiết lập layout
        frame.setLayout(new BorderLayout(10, 10));

        // Tạo panel chính
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10)); // Có 8 dòng, 2 cột
        panel.setBackground(new Color(240, 240, 240)); // Màu nền nhẹ nhàng

        // Tạo các Label và TextField
        JLabel lblMaSV = new JLabel("Mã Sinh viên:");
        JTextField txtMaSV = new JTextField();
        JLabel lblTenSV = new JLabel("Tên Sinh viên:");
        JTextField txtTenSV = new JTextField();
        JLabel lblLop = new JLabel("Lớp:");
        JTextField txtLop = new JTextField();
        JLabel lblNganh = new JLabel("Ngành:");
        JTextField txtNganh = new JTextField();
        JLabel lblKhoa = new JLabel("Khoa:");
        JTextField txtKhoa = new JTextField();

        // Thêm mục chọn giới tính (Nam/Nữ)
        JLabel lblGioiTinh = new JLabel("Giới tính:");
        JRadioButton rbNam = new JRadioButton("Nam");
        JRadioButton rbNu = new JRadioButton("Nữ");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbNam);
        genderGroup.add(rbNu);

        // Định dạng các Label cho đẹp
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        lblMaSV.setFont(labelFont);
        lblTenSV.setFont(labelFont);
        lblLop.setFont(labelFont);
        lblNganh.setFont(labelFont);
        lblKhoa.setFont(labelFont);
        lblGioiTinh.setFont(labelFont);

        // Tạo nút "Lưu" và "Làm mới"
        JButton btnLuu = new JButton("Lưu");
        JButton btnClear = new JButton("Làm mới");
        btnLuu.setBackground(new Color(70, 130, 180)); // Màu xanh dương đẹp cho nút
        btnLuu.setForeground(Color.WHITE);
        btnClear.setBackground(new Color(255, 99, 71)); // Màu đỏ cho nút làm mới
        btnClear.setForeground(Color.WHITE);

        // Tạo panel chứa các nút
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(new Color(240, 240, 240));
        buttonPanel.add(btnLuu);
        buttonPanel.add(btnClear);

        // Thêm các thành phần vào panel
        panel.add(lblMaSV);
        panel.add(txtMaSV);
        panel.add(lblTenSV);
        panel.add(txtTenSV);
        panel.add(lblLop);
        panel.add(txtLop);
        panel.add(lblNganh);
        panel.add(txtNganh);
        panel.add(lblKhoa);
        panel.add(txtKhoa);
        panel.add(lblGioiTinh);
        JPanel genderPanel = new JPanel();
        genderPanel.add(rbNam);
        genderPanel.add(rbNu);
        panel.add(genderPanel);

        // Thêm panel và buttonPanel vào frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Tạo đối tượng repository
        Repositories_SinhVien repo = new Repositories_SinhVien();

        // Thêm hành động cho nút Lưu
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maSV = txtMaSV.getText().trim();
                String tenSV = txtTenSV.getText().trim();
                String lop = txtLop.getText().trim();
                String nganh = txtNganh.getText().trim();
                String khoa = txtKhoa.getText().trim();

                // Kiểm tra nếu Mã Sinh viên là rỗng hoặc không hợp lệ
                if (maSV.isEmpty() || !maSV.matches("[A-Za-z0-9]+")) {
                    JOptionPane.showMessageDialog(frame, "Mã Sinh viên phải là chuỗi hợp lệ (có thể chứa chữ và số).");
                    return;
                }

                // Kiểm tra nếu Lớp có thể chứa chữ và số, và không rỗng
                if (lop.isEmpty() || !lop.matches("[A-Za-z0-9]+")) {
                    JOptionPane.showMessageDialog(frame, "Lớp phải chứa chữ và số hợp lệ.");
                    return;
                }

                // Kiểm tra các trường nhập liệu có rỗng hay không
                if (tenSV.isEmpty() || nganh.isEmpty() || khoa.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Tất cả các trường đều phải được điền đầy đủ.");
                    return;
                }

                // Xác định giới tính
                String gioiTinh = rbNam.isSelected() ? "Nam" : "Nữ";

                // Tạo đối tượng SinhVien từ dữ liệu nhập vào
                SinhVien sinhVien = new SinhVien(Integer.parseInt(maSV), "", "", tenSV, "", "", Integer.parseInt(lop), nganh, khoa, gioiTinh, 0, 0);

                // Gọi phương thức them từ Repository để lưu sinh viên
                int result = repo.them(sinhVien);

                // Hiển thị thông báo
                if (result > 0) {
                    JOptionPane.showMessageDialog(frame, "Sinh viên đã được lưu thành công!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Có lỗi xảy ra khi lưu sinh viên.");
                }

                // Làm sạch các trường nhập liệu sau khi lưu
                txtMaSV.setText("");
                txtTenSV.setText("");
                txtLop.setText("");
                txtNganh.setText("");
                txtKhoa.setText("");
                rbNam.setSelected(false);
                rbNu.setSelected(false);
            }
        });

        // Thêm hành động cho nút Làm mới
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Làm sạch tất cả các trường
                txtMaSV.setText("");
                txtTenSV.setText("");
                txtLop.setText("");
                txtNganh.setText("");
                txtKhoa.setText("");
                rbNam.setSelected(false);
                rbNu.setSelected(false);
            }
        });

        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}
