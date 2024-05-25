package com.fanservice.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class FanficsCardResponseDTO {
    private UUID id;
    private String title;
    private String author;
    private String description;
    private double rating;
    private String status;
    private int views;
    private List<String> fandoms;
    private List<String> genres;
    private List<String> languages;
    private List<String> pairings;
}
