package com.fanservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class FanficRequestDTO {
    private String title;
    private String author;
    private String authorComment;
    private String description;
    private double rating;
    private String status;
    private String text;
    private int views;
    private List<String> fandoms;
    private List<String> genres;
    private List<String> languages;
    private List<String> pairings;
}
