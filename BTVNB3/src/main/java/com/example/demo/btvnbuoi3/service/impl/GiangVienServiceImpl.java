package com.example.demo.btvnbuoi3.service.impl;

import com.example.demo.btvnbuoi3.entity.GiangVien;
import com.example.demo.btvnbuoi3.service.GiangVienService;

import java.util.ArrayList;
import java.util.List;

public class GiangVienServiceImpl implements GiangVienService {
    List<GiangVien>giangViens = new ArrayList<>();
    public GiangVienServiceImpl(){
        giangViens.add(new GiangVien("1","HangNT169","Táo",3,false,"Đồng Bằng"));
        giangViens.add(new GiangVien("2","NguyenVV4","Cam",4,true,"Trung Du Miền Núi"));
        giangViens.add(new GiangVien("3","PhongTT35","Sầu Riêng",5,true,"Miền Nam"));
        giangViens.add(new GiangVien("4","KhanhPG","Vải",7,true,"Bắc Giang"));
        giangViens.add(new GiangVien("5","TienNH21","Mít",10,true,"Miền Bắc"));
    }
    @Override
    public List<GiangVien> getAll() {
        return giangViens;
    }

    @Override
    public List<GiangVien> getByName(String name) {
        List<GiangVien>list = new ArrayList<>();
        for (GiangVien gv:giangViens) {
            if(gv.getTen().startsWith(name)){
                list.add(gv);
            }
        }
        return list;
    }

    @Override
    public List<GiangVien> getByGioiTinh() {
        List<GiangVien>list = new ArrayList<>();
        for (GiangVien gv:giangViens) {
            if(gv.getGioiTinh()==false){
                list.add(gv);
            }
        }
        return list;
    }

}
