import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementGUI {
    public static void main(String[] args) {
        // Tạo cửa sổ chính
        JFrame frame = new JFrame("Quản lý Sinh viên");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Thiết lập layout
        frame.setLayout(new GridLayout(7, 2, 10, 10));

        // Tạo các Label và TextField
        JLabel lblMaSV = new JLabel("Mã Sinh viên:");
        JTextField txtMaSV = new JTextField();
        JLabel lblTenSV = new JLabel("Tên Sinh viên:");
        JTextField txtTenSV = new JTextField();
        JLabel lblMonHoc = new JLabel("Môn Học:");
        JTextField txtMonHoc = new JTextField();
        JLabel lblLop = new JLabel("Lớp:");
        JTextField txtLop = new JTextField();
        JLabel lblNganh = new JLabel("Ngành:");
        JTextField txtNganh = new JTextField();
        JLabel lblKhoa = new JLabel("Khoa:");
        JTextField txtKhoa = new JTextField();

        // Tạo nút "Lưu" để nhập thông tin
        JButton btnLuu = new JButton("Lưu");

        // Thêm các thành phần vào cửa sổ
        frame.add(lblMaSV);
        frame.add(txtMaSV);
        frame.add(lblTenSV);
        frame.add(txtTenSV);
        frame.add(lblMonHoc);
        frame.add(txtMonHoc);
        frame.add(lblLop);
        frame.add(txtLop);
        frame.add(lblNganh);
        frame.add(txtNganh);
        frame.add(lblKhoa);
        frame.add(txtKhoa);
        frame.add(new JLabel()); // Dòng trống
        frame.add(btnLuu);

        // Thêm hành động cho nút Lưu
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maSV = txtMaSV.getText();
                String tenSV = txtTenSV.getText();
                String monHoc = txtMonHoc.getText();
                String lop = txtLop.getText();
                String nganh = txtNganh.getText();
                String khoa = txtKhoa.getText();
                
                // Xử lý lưu thông tin ở đây, ví dụ in ra console
                System.out.println("Mã Sinh viên: " + maSV);
                System.out.println("Tên Sinh viên: " + tenSV);
                System.out.println("Môn Học: " + monHoc);
                System.out.println("Lớp: " + lop);
                System.out.println("Ngành: " + nganh);
                System.out.println("Khoa: " + khoa);
                
                // Làm sạch các trường nhập liệu sau khi lưu
                txtMaSV.setText("");
                txtTenSV.setText("");
                txtMonHoc.setText("");
                txtLop.setText("");
                txtNganh.setText("");
                txtKhoa.setText("");
            }
        });

        // Hiển thị cửa sổ
        frame.setVisible(true);
    }
}
