public class Repositories_SinhVien {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    // Thêm sinh viên
    public int them(SinhVien sinhVien) {
        // Không chèn giá trị vào cột identity 'id'
        sql = "INSERT INTO SinhVien (ten_dang_nhap, mat_khau, ho_ten, vai_tro, ma_sinh_vien, lop_id, nganh, khoa, gioi_tinh, mon_hoc_id, diem_ren_luyen_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = DBConnectConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sinhVien.getTenDangNhap());
            ps.setString(2, sinhVien.getMatKhau());
            ps.setString(3, sinhVien.getHoTen());
            ps.setString(4, sinhVien.getVaiTro());
            ps.setString(5, sinhVien.getMaSinhVien());
            ps.setInt(6, sinhVien.getLopId());
            ps.setString(7, sinhVien.getNganh());
            ps.setString(8, sinhVien.getKhoa());
            ps.setString(9, sinhVien.getGioiTinh());
            ps.setInt(10, sinhVien.getMonHocId());
            ps.setInt(11, sinhVien.getDiemRenLuyenId());
            return ps.executeUpdate();  // Trả về số dòng bị ảnh hưởng
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Sửa thông tin sinh viên
    public int sua(SinhVien sinhVien) {
        sql = "UPDATE SinhVien SET ten_dang_nhap = ?, mat_khau = ?, ho_ten = ?, vai_tro = ?, ma_sinh_vien = ?, lop_id = ?, nganh = ?, khoa = ?, gioi_tinh = ?, "
                + "mon_hoc_id = ?, diem_ren_luyen_id = ? WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sinhVien.getTenDangNhap());
            ps.setString(2, sinhVien.getMatKhau());
            ps.setString(3, sinhVien.getHoTen());
            ps.setString(4, sinhVien.getVaiTro());
            ps.setString(5, sinhVien.getMaSinhVien());
            ps.setInt(6, sinhVien.getLopId());
            ps.setString(7, sinhVien.getNganh());
            ps.setString(8, sinhVien.getKhoa());
            ps.setString(9, sinhVien.getGioiTinh());
            ps.setInt(10, sinhVien.getMonHocId());
            ps.setInt(11, sinhVien.getDiemRenLuyenId());
            ps.setInt(12, sinhVien.getId());
            return ps.executeUpdate();  // Trả về số dòng bị ảnh hưởng
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Xoá sinh viên
    public int xoa(int id) {
        sql = "DELETE FROM SinhVien WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();  // Trả về số dòng bị ảnh hưởng
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Lấy tất cả sinh viên
    public ArrayList<SinhVien> getAll_SinhVien() {
        ArrayList<SinhVien> list_SinhVien = new ArrayList<>();
        sql = "SELECT id, ten_dang_nhap, mat_khau, ho_ten, vai_tro, ma_sinh_vien, lop_id, nganh, khoa, gioi_tinh, mon_hoc_id, diem_ren_luyen_id FROM SinhVien";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String tenDangNhap = rs.getString(2);
                String matKhau = rs.getString(3);
                String hoTen = rs.getString(4);
                String vaiTro = rs.getString(5);
                String maSinhVien = rs.getString(6);
                int lopId = rs.getInt(7);
                String nganh = rs.getString(8);
                String khoa = rs.getString(9);
                String gioiTinh = rs.getString(10);
                int monHocId = rs.getInt(11);
                int diemRenLuyenId = rs.getInt(12);
                SinhVien sinhVien = new SinhVien(id, tenDangNhap, matKhau, hoTen, vaiTro, maSinhVien, lopId, nganh, khoa, gioiTinh, monHocId, diemRenLuyenId);
                list_SinhVien.add(sinhVien);
            }
            return list_SinhVien;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
