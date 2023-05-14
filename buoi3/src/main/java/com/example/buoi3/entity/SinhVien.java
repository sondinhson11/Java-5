package com.example.buoi3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class SinhVien {

    private String mssv;

    private String ten;

    private Integer tuoi;

    private String diaChi;

    private Boolean gioiTinh;
}
