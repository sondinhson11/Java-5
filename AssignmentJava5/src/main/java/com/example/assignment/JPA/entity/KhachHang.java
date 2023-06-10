package com.example.assignment.JPA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "KhachHang")
@Entity
public class KhachHang {

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

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @NotBlank(message = "Khong de trong")
    @Column(name = "Sdt")
    private String sdt;

    @NotBlank(message = "Khong de trong")
    @Column(name = "DiaChi")
    private String diaChi;

    @NotBlank(message = "Khong de trong")
    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    @NotBlank(message = "Khong de trong")
    @Column(name = "MatKhau")
    private String matKhau;
}
