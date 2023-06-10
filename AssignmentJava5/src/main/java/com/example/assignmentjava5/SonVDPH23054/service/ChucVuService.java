package com.example.assignmentjava5.SonVDPH23054.service;

import com.example.assignmentjava5.SonVDPH23054.entity.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu>getAll();

    void addCV(ChucVu chucVu);

    Page<ChucVu> phanTrang(Pageable pageable);

    void remove(UUID id);

    void update(ChucVu chucVu);

    ChucVu detail(UUID id);
}
