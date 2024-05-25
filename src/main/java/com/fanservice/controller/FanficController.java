package com.fanservice.controller;

import com.fanservice.dto.FanficRequestDTO;
import com.fanservice.dto.FanficResponseDTO;
import com.fanservice.dto.FanficsCardResponseDTO;
import com.fanservice.model.Fanfic;
import com.fanservice.service.FanficService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/fanfics")
public class FanficController {
    private FanficService fanficService;

    @Autowired
    public FanficController(FanficService fanficService) {
        this.fanficService = fanficService;
    }

    @GetMapping
    public ResponseEntity<?> getAllFanfics() {
        try {
            List<FanficsCardResponseDTO> fanfics = fanficService.getFanfics();
            return new ResponseEntity<>(fanfics, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFanfic(@PathVariable UUID id) {
        try {
            FanficResponseDTO fanfic = fanficService.getFanficById(id);
            return new ResponseEntity<>(fanfic, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Fanfic> createFanfic(@RequestBody FanficRequestDTO fanficRequestDTO) {
        try {
            Fanfic savedFanfic = fanficService.createFanfic(fanficRequestDTO);
            return new ResponseEntity<>(savedFanfic, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create Fanfic", e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFanfic(@PathVariable UUID id) {
        try {
            fanficService.deleteFanfic(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}