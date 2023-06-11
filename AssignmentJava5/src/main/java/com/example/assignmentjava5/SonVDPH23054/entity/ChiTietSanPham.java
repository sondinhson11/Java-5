package com.example.assignmentjava5.SonVDPH23054.entity;

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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ChiTietSP")
@Entity
public class ChiTietSanPham {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdSP",referencedColumnName = "Id")
    private SanPham sanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNsx",referencedColumnName = "Id")
    private NSX nsx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMauSac",referencedColumnName = "Id")
    private MauSac mauSac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdDongSP",referencedColumnName = "Id")
    private DongSP dongSP;

    @NotNull(message = "Khong de trong")
    @Column(name = "NamBH")
    private Integer namBH;

    @NotBlank(message = "Khong de trong")
    @Column(name = "MoTa")
    private String moTa;

    @NotNull(message = "Khong de trong")
    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @NotNull(message = "Khong de trong")
    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @NotNull(message = "Khong de trong")
    @Column(name = "GiaBan")
    private BigDecimal giaBan;
}
