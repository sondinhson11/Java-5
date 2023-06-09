package com.example.assignment.JPA.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "CuaHang")
@Entity
public class CuaHang {
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
    @Column(name = "DiaChi")
    private String diaChi;

    @NotBlank(message = "Khong de trong")
    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;
}
