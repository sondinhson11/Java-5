USE master
GO
DROP DATABASE FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041
GO
CREATE DATABASE FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041
GO
USE FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041
GO
-- ChucVu
CREATE TABLE ChucVu(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(50) DEFAULT NULL
)
insert into ChucVu(Ma,Ten) Values
('CV1',N'Nhân Viên'),
('CV2',N'Quản Lý');
GO
-- CuaHang
CREATE TABLE CuaHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
ThanhPho NVARCHAR(50) DEFAULT NULL,
QuocGia NVARCHAR(50) DEFAULT NULL
)
insert into CuaHang(Ma,Ten,DiaChi,ThanhPho,QuocGia) Values
('CH1','Shop 1',N'Đống Đa',N'Hà Nội',N'Việt Nam'),
('CH2','Shop 2',N'Cầu Giấy',N'Hà Nội',N'Việt Nam');
GO
-- NhanVien
CREATE TABLE NhanVien(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30) DEFAULT NULL,
TenDem NVARCHAR(30) DEFAULT NULL,
Ho NVARCHAR(30) DEFAULT NULL,
GioiTinh NVARCHAR(10) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
MatKhau VARCHAR(MAX) DEFAULT NULL,
IdCH UNIQUEIDENTIFIER,
IdCV UNIQUEIDENTIFIER,
IdGuiBC UNIQUEIDENTIFIER,
TrangThai INT DEFAULT 0
)
INSERT INTO [dbo].[NhanVien]
           ([Ma]
           ,[Ten]
           ,[TenDem]
           ,[Ho]
           ,[GioiTinh]
           ,[NgaySinh]
           ,[DiaChi]
           ,[Sdt]
           ,[MatKhau]
           ,[IdCH]
           ,[IdCV]
           ,[IdGuiBC]
           ,[TrangThai])
     VALUES
           ('NV1'
           ,N'Sơn'
           ,N'Đình'
           ,N'Văn'
           ,N'Nam'
           ,'12/12/2002'
           ,N'Sầm Sơn'
           ,'0862521305'
           ,'123456'
           ,'918CBF55-B1B8-40BD-B19B-E482AAA4C2DF'
           ,'8681CD6F-D023-4975-8195-127D1410157F'
           ,null
           ,1),
		    ('NV2'
           ,N'Sơn'
           ,N'Đình'
           ,N'Văn'
           ,N'Nam'
           ,'12/12/2002'
           ,N'Sầm Sơn'
           ,'0862521305'
           ,'123456'
           ,'918CBF55-B1B8-40BD-B19B-E482AAA4C2DF'
           ,'8681CD6F-D023-4975-8195-127D1410157F'
           ,null
           ,1);

GO
-- KhachHang
CREATE TABLE KhachHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30),
TenDem NVARCHAR(30) DEFAULT NULL,
Ho NVARCHAR(30) DEFAULT NULL,
NgaySinh DATE DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
ThanhPho NVARCHAR(50) DEFAULT NULL,
QuocGia NVARCHAR(50) DEFAULT NULL,
MatKhau VARCHAR(MAX) DEFAULT NULL
)

INSERT INTO [dbo].[KhachHang]
           ([Ma]
           ,[Ten]
           ,[TenDem]
           ,[Ho]
           ,[NgaySinh]
           ,[Sdt]
           ,[DiaChi]
           ,[ThanhPho]
           ,[QuocGia]
           ,[MatKhau])
     VALUES
           ('KH1'
           ,N'Sơn'
           ,N'Đình'
           ,N'Văn'
           ,'12/12/2002'
           ,'0862521305'
           ,N'Sầm Sơn'
           ,N'Thanh Hóa'
           ,'Việt Nam'
           ,'123456')
GO
--HoaDon
CREATE TABLE HoaDon(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdKH UNIQUEIDENTIFIER,
IdNV UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
NgayTao DATE DEFAULT NULL,
NgayThanhToan DATE DEFAULT NULL,
NgayShip DATE DEFAULT NULL,
NgayNhan DATE DEFAULT NULL,
TinhTrang INT DEFAULT 0,
TenNguoiNhan NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
)
GO
CREATE TABLE GioHang(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdKH UNIQUEIDENTIFIER,
IdNV UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
NgayTao DATE DEFAULT NULL,
NgayThanhToan DATE DEFAULT NULL,
TenNguoiNhan NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
TinhTrang INT DEFAULT 0
)
GO
-- SanPham
CREATE TABLE SanPham(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
insert into SanPham(Ma,Ten) Values
('SP1',N'Sản Phẩm 1'),
('SP2',N'Sản Phẩm 2');
GO

-- NSX
CREATE TABLE NSX(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
insert into NSX(Ma,Ten) Values
('NSX1',N'Nhà Sản Xuất 1'),
('NSX2',N'Nhà Sản Xuất 2');
GO
-- MauSac
CREATE TABLE MauSac(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
insert into MauSac(Ma,Ten) Values
('MS1',N'Màu Sắc 1'),
('MS2',N'Màu Sắc 2');
GO
-- DongSP
CREATE TABLE DongSP(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Ma VARCHAR(20) UNIQUE,
Ten NVARCHAR(30)
)
insert into DongSP(Ma,Ten) Values
('DSP1',N'Dòng Sản Phẩm 1'),
('DSP2',N'Dòng Sản Phẩm 2');
GO
-- ChiTietSP
CREATE TABLE ChiTietSP(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IdSP UNIQUEIDENTIFIER,
IdNsx UNIQUEIDENTIFIER,
IdMauSac UNIQUEIDENTIFIER,
IdDongSP UNIQUEIDENTIFIER,
NamBH INT DEFAULT NULL,
MoTa NVARCHAR(50) DEFAULT NULL,
SoLuongTon INT,
GiaNhap DECIMAL(20,0) DEFAULT 0,
GiaBan DECIMAL(20,0) DEFAULT 0,
)

INSERT INTO [dbo].[ChiTietSP]
           ([IdSP]
           ,[IdNsx]
           ,[IdMauSac]
           ,[IdDongSP]
           ,[NamBH]
           ,[MoTa]
           ,[SoLuongTon]
           ,[GiaNhap]
           ,[GiaBan])
     VALUES
           ('A3B45654-F4DC-416D-B087-333F00A200D7'
           ,'a92eb68b-e0d7-47fb-8cba-138c40ec77bf'
           ,'A066B7EA-CE27-4D34-87DB-8B37C4B2E966'
           ,'d57c2e8e-56eb-4e87-bf5e-cfa7e519ad5b'
           ,1
           ,'Không Có Đâu'
           ,100
           ,10000
           ,100000)
GO




GO
-- HoaDonChiTiet
CREATE TABLE HoaDonChiTiet(
IdHoaDon UNIQUEIDENTIFIER,
IdChiTietSP UNIQUEIDENTIFIER,
SoLuong INT,
DonGia DECIMAL(20,0) DEFAULT 0,
CONSTRAINT PK_HoaDonCT PRIMARY KEY (IdHoaDon,IdChiTietSP),
CONSTRAINT FK1 FOREIGN KEY(IdHoaDon) REFERENCES HoaDon(Id),
CONSTRAINT FK2 FOREIGN KEY(IdChiTietSP) REFERENCES ChiTietSP(Id),
)
GO
CREATE TABLE GioHangChiTiet(
IdGioHang UNIQUEIDENTIFIER,
IdChiTietSP UNIQUEIDENTIFIER,
SoLuong INT,
DonGia DECIMAL(20,0) DEFAULT 0,
DonGiaKhiGiam DECIMAL(20,0) DEFAULT 0,
CONSTRAINT PK_GioHangCT PRIMARY KEY (IdGioHang,IdChiTietSP),
CONSTRAINT FK1_IdGioHang FOREIGN KEY(IdGioHang) REFERENCES GioHang(Id),
CONSTRAINT FK2_IdChiTietSP FOREIGN KEY(IdChiTietSP) REFERENCES ChiTietSP(Id),
)
GO
--TẠO QUAN HỆ GIỮA CÁC BẢNG
--NhanVien - CuaHang
ALTER TABLE NhanVien ADD FOREIGN KEY (IdCH) REFERENCES CuaHang(Id)
--NhanVien - ChucVu
ALTER TABLE NhanVien ADD FOREIGN KEY (IdCV) REFERENCES ChucVu(Id)
--NhanVien - GuiBaoCao
ALTER TABLE NhanVien ADD FOREIGN KEY (IdGuiBC) REFERENCES NhanVien(Id)
-- HoaDon - KhachHang
ALTER TABLE HoaDon ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id)
-- GioHang - KhachHang
ALTER TABLE GioHang ADD FOREIGN KEY (IdKH) REFERENCES KhachHang(Id)
-- HoaDon - NhanVien
ALTER TABLE HoaDon ADD FOREIGN KEY (IdNV) REFERENCES NhanVien(Id)
-- ChiTietSP - SanPham
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdSP) REFERENCES SanPham(Id)
-- ChiTietSP - NSX
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdNsx) REFERENCES Nsx(Id)
-- ChiTietSP - MauSac
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdMauSac) REFERENCES MauSac(Id)
-- ChiTietSP - DongSP
ALTER TABLE ChiTietSP ADD FOREIGN KEY(IdDongSP) REFERENCES DongSP(Id)