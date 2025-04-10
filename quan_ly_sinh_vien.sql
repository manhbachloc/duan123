-- Tạo cơ sở dữ liệu Duan1
CREATE DATABASE Duan1;
USE Duan1;

-- Tạo bảng SinhVien (sinh viên)
CREATE TABLE SinhVien (
    id INT PRIMARY KEY IDENTITY(1,1),  -- Sử dụng IDENTITY thay cho AUTO_INCREMENT
    ten_dang_nhap VARCHAR(50) NOT NULL UNIQUE,
    mat_khau VARCHAR(255) NOT NULL,
    ho_ten VARCHAR(100) NOT NULL,
    vai_tro VARCHAR(20) NOT NULL,  -- Thay thế ENUM bằng VARCHAR
    ma_sinh_vien VARCHAR(20),
    lop_id INT,
    nganh VARCHAR(100),
    khoa VARCHAR(100),
    gioi_tinh NVARCHAR(3)  -- Thêm trường giới tính
);

-- Tạo bảng lớp học
CREATE TABLE lop (
    id INT PRIMARY KEY IDENTITY(1,1),  -- Sử dụng IDENTITY thay cho AUTO_INCREMENT
    ma_lop VARCHAR(20) NOT NULL UNIQUE,
    ten_lop VARCHAR(100) NOT NULL,
    co_van_id INT,
    FOREIGN KEY (co_van_id) REFERENCES SinhVien(id)  -- Khóa ngoại từ SinhVien
);

-- Tạo bảng môn học
CREATE TABLE mon_hoc (
    id INT PRIMARY KEY IDENTITY(1,1),  -- Sử dụng IDENTITY thay cho AUTO_INCREMENT
    ma_mon VARCHAR(20) NOT NULL UNIQUE,
    ten_mon VARCHAR(100) NOT NULL,
    so_tin_chi INT NOT NULL
);

-- Tạo bảng điểm rèn luyện
CREATE TABLE diem_ren_luyen (
    id INT PRIMARY KEY IDENTITY(1,1),  -- Sử dụng IDENTITY thay cho AUTO_INCREMENT
    sinh_vien_id INT NOT NULL,
    hoc_ky VARCHAR(10) NOT NULL,
    diem INT,
    ghi_chu TEXT,
    duyet_boi INT,
    FOREIGN KEY (sinh_vien_id) REFERENCES SinhVien(id)  -- Khóa ngoại từ SinhVien
);

-- Thêm khóa ngoại vào bảng SinhVien
ALTER TABLE SinhVien
ADD mon_hoc_id INT,  -- Khóa ngoại từ SinhVien đến môn học
    diem_ren_luyen_id INT;  -- Khóa ngoại từ SinhVien đến điểm rèn luyện

-- Cập nhật khóa ngoại
ALTER TABLE SinhVien
ADD CONSTRAINT FK_MonHoc FOREIGN KEY (mon_hoc_id) REFERENCES mon_hoc(id),  -- Khóa ngoại từ SinhVien đến mon_hoc
    CONSTRAINT FK_DiemRenLuyen FOREIGN KEY (diem_ren_luyen_id) REFERENCES diem_ren_luyen(id);  -- Khóa ngoại từ SinhVien đến diem_ren_luyen
	INSERT INTO SinhVien (ten_dang_nhap, mat_khau, ho_ten, vai_tro, ma_sinh_vien, lop_id, nganh, khoa, gioi_tinh)
VALUES
('user1', 'password1', 'Nguyen Van A', 'SINH_VIEN', 'SV001', 1, 'Công nghệ thông tin', '2021', 'Nam'),
('user2', 'password2', 'Nguyen Thi B', 'SINH_VIEN', 'SV002', 2, 'Kinh tế', '2021', 'Nữ'),
('user3', 'password3', 'Le Thi C', 'SINH_VIEN', 'SV003', 3, 'Quản trị kinh doanh', '2021', 'Nữ'),
('user4', 'password4', 'Tran Quoc D', 'SINH_VIEN', 'SV004', 4, 'Cơ khí', '2021', 'Nam'),
('user5', 'password5', 'Pham Thi E', 'SINH_VIEN', 'SV005', 5, 'Kỹ thuật phần mềm', '2021', 'Nữ'),
('user6', 'password6', 'Hoang Thi F', 'SINH_VIEN', 'SV006', 6, 'Kinh tế quốc tế', '2021', 'Nữ'),
('user7', 'password7', 'Nguyen Minh G', 'SINH_VIEN', 'SV007', 7, 'Vật lý', '2021', 'Nam'),
('user8', 'password8', 'Truong Thi H', 'SINH_VIEN', 'SV008', 8, 'Điện tử', '2021', 'Nữ'),
('user9', 'password9', 'Duong Thi I', 'SINH_VIEN', 'SV009', 9, 'Tài chính ngân hàng', '2021', 'Nữ'),
('user10', 'password10', 'Nguyen Thi J', 'SINH_VIEN', 'SV010', 10, 'Ngoại ngữ', '2021', 'Nữ');
select*from lop
INSERT INTO lop (ma_lop, ten_lop, co_van_id)
VALUES
('L001', 'Lớp 1', 1),
('L002', 'Lớp 2', 2),
('L003', 'Lớp 3', 3),
('L004', 'Lớp 4', 4),
('L005', 'Lớp 5', 5),
('L006', 'Lớp 6', 6),
('L007', 'Lớp 7', 7),
('L008', 'Lớp 8', 8),
('L009', 'Lớp 9', 9),
('L010', 'Lớp 10', 10);
INSERT INTO mon_hoc (ma_mon, ten_mon, so_tin_chi)
VALUES
('MH001', 'Toán 1', 3),
('MH002', 'Lý 1', 3),
('MH003', 'Hóa 1', 3),
('MH004', 'Tin học đại cương', 3),
('MH005', 'Kinh tế học', 3),
('MH006', 'Quản trị học', 3),
('MH007', 'Kỹ thuật phần mềm', 3),
('MH008', 'Vật lý đại cương', 3),
('MH009', 'Hóa học đại cương', 3),
('MH010', 'Nhập môn lập trình', 3);
INSERT INTO diem_ren_luyen (sinh_vien_id, hoc_ky, diem, ghi_chu, duyet_boi)
VALUES
(1, 'HK1', 8, 'Tốt', 2),
(2, 'HK1', 7, 'Khá', 3),
(3, 'HK1', 9, 'Xuất sắc', 4),
(4, 'HK1', 6, 'Trung bình', 5),
(5, 'HK1', 7, 'Khá', 6),
(6, 'HK1', 8, 'Tốt', 7),
(7, 'HK1', 9, 'Xuất sắc', 8),
(8, 'HK1', 7, 'Khá', 9),
(9, 'HK1', 6, 'Trung bình', 10),
(10, 'HK1', 8, 'Tốt', 1);



