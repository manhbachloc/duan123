import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuanLySinhVienGUI {

    private JFrame frame;
    private JTextField txtMaSV, txtHoTen, txtKhoa, txtNganh, txtGioiTinh;
    private JButton btnSearch, btnNew, btnSave, btnDelete, btnUpdate;
    private JTable table;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                QuanLySinhVienGUI window = new QuanLySinhVienGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    // Constructor to initialize the frame
    public QuanLySinhVienGUI() {
        initialize();
    }

    // Initialize the contents of the frame
    private void initialize() {
        // Setting up the frame
        frame = new JFrame("Quản Lý Sinh Viên");
        frame.setBounds(100, 100, 900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(10, 10));
        frame.setResizable(false);

        // Panel for Search functionality
        JPanel panelSearch = new JPanel();
        panelSearch.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblMaSV = new JLabel("Mã SV:");
        txtMaSV = new JTextField(15);
        btnSearch = new JButton("Search");
        panelSearch.add(lblMaSV);
        panelSearch.add(txtMaSV);
        panelSearch.add(btnSearch);

        // Panel for Student Information
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new GridLayout(5, 2, 10, 10));
        panelInfo.setBorder(BorderFactory.createTitledBorder("Thông Tin Sinh Viên"));

        JLabel lblHoTen = new JLabel("Họ tên:");
        txtHoTen = new JTextField();
        JLabel lblKhoa = new JLabel("Khoa:");
        txtKhoa = new JTextField();
        JLabel lblNganh = new JLabel("Ngành:");
        txtNganh = new JTextField();
        JLabel lblGioiTinh = new JLabel("Giới tính:");
        txtGioiTinh = new JTextField();

        panelInfo.add(lblHoTen);
        panelInfo.add(txtHoTen);
        panelInfo.add(lblKhoa);
        panelInfo.add(txtKhoa);
        panelInfo.add(lblNganh);
        panelInfo.add(txtNganh);
        panelInfo.add(lblGioiTinh);
        panelInfo.add(txtGioiTinh);

        // Panel for buttons
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        btnNew = new JButton("+ New");
        btnSave = new JButton("Save");
        btnDelete = new JButton("Delete");
        btnUpdate = new JButton("Update");

        panelButtons.add(btnNew);
        panelButtons.add(btnSave);
        panelButtons.add(btnDelete);
        panelButtons.add(btnUpdate);

        // Table to display student data
        String[] columnNames = {"Mã SV", "Họ tên", "Khoa", "Ngành", "Giới tính"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Adding components to the frame
        frame.getContentPane().add(panelSearch, BorderLayout.NORTH);
        frame.getContentPane().add(panelInfo, BorderLayout.CENTER);
        frame.getContentPane().add(panelButtons, BorderLayout.SOUTH);
        frame.getContentPane().add(scrollPane, BorderLayout.EAST);

        // Add action listeners to buttons (for later implementation)
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Search functionality here
            }
        });

        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle New Student functionality here
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Save functionality here
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Delete functionality here
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Update functionality here
            }
        });
    }
}
