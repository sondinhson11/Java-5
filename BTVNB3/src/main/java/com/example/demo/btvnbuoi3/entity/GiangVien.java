package com.example.demo.btvnbuoi3.entity;

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

public class GiangVien {
    private String id;

    private String ma;

    private String ten;

    private Integer tuoi;

    private Boolean gioiTinh;

    private String diaChi;

}
