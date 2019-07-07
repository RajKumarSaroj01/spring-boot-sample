package com.example.demo.service;

import com.example.demo.dto.GenderDTO;

import java.util.List;

/**
 * Created by sarojraj on 6/29/2019.
 */
public interface GenderService {

    List<GenderDTO> getAll();
    GenderDTO getGender(Long id);
}
