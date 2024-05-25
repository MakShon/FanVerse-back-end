package com.fanservice.service;

import com.fanservice.dto.FanficRequestDTO;
import com.fanservice.dto.FanficResponseDTO;
import com.fanservice.dto.FanficsCardResponseDTO;
import com.fanservice.model.Fanfic;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface FanficService {
    Fanfic createFanfic(FanficRequestDTO fanficRequestDTO);

    List<FanficsCardResponseDTO> getFanfics();

    FanficResponseDTO getFanficById(UUID id);

    ResponseEntity<?> deleteFanfic(UUID id);
}
