package com.example.assignment.JPA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "NhanVien")
@Entity
public class NhanVien {

@Id
@Column(name = "Id")
@GeneratedValue(strategy = GenerationType.UUID)
private UUID id;

    @NotBlank(message = "Khong de trong")
    @Column(name = "Ma")
    private String ma;

    @NotBlank(message = "Khong de trong")
    @Column(name = "Ten")
    private String ten;

    @NotBlank(message = "Khong de trong")
    @Column(name = "TenDem")
    private String tenDem;

    @NotBlank(message = "Khong de trong")
    @Column(name = "Ho")
    private String ho;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @NotBlank(message = "Khong de trong")
    @Column(name = "DiaChi")
    private String diaChi;

    @NotBlank(message = "Khong de trong")
    @Column(name = "Sdt")
    private String sdt;


    @NotBlank(message = "Khong de trong")
    @Column(name = "MatKhau")
    private String matKhau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCH",referencedColumnName = "id")
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV",referencedColumnName = "id")
    private ChucVu chucVu;

    @Column(name = "IdGuiBC")
    private UUID idGuiBC;

    @Column(name = "TrangTHai")
    private Integer trangThai;
}
