package com.fanservice.service.impl;

import com.fanservice.dto.FanficRequestDTO;
import com.fanservice.dto.FanficResponseDTO;
import com.fanservice.dto.FanficsCardResponseDTO;
import com.fanservice.model.Fanfic;
import com.fanservice.repository.FanficRepository;
import com.fanservice.service.FanficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FanficServiceImpl implements FanficService {
    private FanficRepository fanficRepository;

    @Autowired
    public FanficServiceImpl(FanficRepository fanficRepository) {
        this.fanficRepository = fanficRepository;
    }

    public Fanfic createFanfic(FanficRequestDTO fanficRequestDTO) {
        Fanfic fanfic = new Fanfic();
        fanfic.setTitle(fanficRequestDTO.getTitle());
        fanfic.setAuthor(fanficRequestDTO.getAuthor());
        fanfic.setAuthorComment(fanficRequestDTO.getAuthorComment());
        fanfic.setStatus(fanficRequestDTO.getStatus());
        fanfic.setViews(fanficRequestDTO.getViews());
        fanfic.setRating(fanficRequestDTO.getRating());
        fanfic.setDescription(fanficRequestDTO.getDescription());
        fanfic.setText(fanficRequestDTO.getText());
        fanfic.setFandoms(fanficRequestDTO.getFandoms());
        fanfic.setPairings(fanficRequestDTO.getPairings());
        fanfic.setLanguages(fanficRequestDTO.getLanguages());
        fanfic.setGenres(fanficRequestDTO.getGenres());
        fanfic.setCreationDate(new Date());
        return fanficRepository.save(fanfic);
    }

    @Override
    public List<FanficsCardResponseDTO> getFanfics() {
        List<Fanfic> fanfics = fanficRepository.findAll();
        List<FanficsCardResponseDTO> fanficCardResponseDTOs = new ArrayList<>();
        for (Fanfic fanfic : fanfics) {
            FanficsCardResponseDTO fanficCardResponseDTO = new FanficsCardResponseDTO();
            fanficCardResponseDTO.setId(fanfic.getId());
            fanficCardResponseDTO.setTitle(fanfic.getTitle());
            fanficCardResponseDTO.setAuthor(fanfic.getAuthor());
            fanficCardResponseDTO.setDescription(fanfic.getDescription());
            fanficCardResponseDTO.setRating(fanfic.getRating());
            fanficCardResponseDTO.setViews(fanfic.getViews());
            fanficCardResponseDTO.setFandoms(fanfic.getFandoms());
            fanficCardResponseDTO.setPairings(fanfic.getPairings());
            fanficCardResponseDTO.setLanguages(fanfic.getLanguages());
            fanficCardResponseDTO.setGenres(fanfic.getGenres());
            fanficCardResponseDTO.setStatus(fanfic.getStatus());
            fanficCardResponseDTOs.add(fanficCardResponseDTO);
        }
        return fanficCardResponseDTOs;
    }

    public FanficResponseDTO getFanficById(UUID id) {
        Fanfic fanfic = fanficRepository.findById(id).orElse(null);
        if (fanfic != null) {
            FanficResponseDTO fanficResponseDTO = new FanficResponseDTO();
            fanficResponseDTO.setId(fanfic.getId());
            fanficResponseDTO.setTitle(fanfic.getTitle());
            fanficResponseDTO.setAuthor(fanfic.getAuthor());
            fanficResponseDTO.setAuthorComment(fanfic.getAuthorComment());
            fanficResponseDTO.setText(fanfic.getText());
            fanficResponseDTO.setCreationDate(fanfic.getCreationDate());
            return fanficResponseDTO;
        } else {
            return null;
        }
    }

    public ResponseEntity<?> deleteFanfic(UUID id) {
        Optional<Fanfic> fanficOptional = fanficRepository.findById(id);
        if (fanficOptional.isPresent()) {
            fanficRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}