package com.example.assignmentjava5.SonVDPH23054.service;

import com.example.assignmentjava5.SonVDPH23054.entity.DongSP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DongSPService {
    List<DongSP> getAll();

    void add(DongSP dongSP);

    Page<DongSP> phanTrang(Pageable pageable);

    void remove(UUID id);

    DongSP detail(UUID id);

    void update(DongSP dongSP);
}
