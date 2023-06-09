package com.example.assignment.JPA.service;

import com.example.assignment.JPA.entity.NSX;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NSXService {
    List<NSX> getAll();

    void add(NSX nsx);

    Page<NSX> phanTrang(Pageable pageable);

    void remove(UUID id);

    NSX detail(UUID id);

    void update(NSX nsx);
}
