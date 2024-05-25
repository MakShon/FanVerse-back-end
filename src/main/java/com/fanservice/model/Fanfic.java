package com.fanservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "fanfics")
@Data
public class Fanfic {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "fanfic_id")
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "author_comment", columnDefinition = "text")
    private String authorComment;

    @Column(name = "status")
    private String status;

    @Column(name = "views")
    private int views;

    @Column(name = "rating")
    private double rating;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "text", columnDefinition = "text")
    private String text;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @ElementCollection
    @CollectionTable(name = "fandoms", joinColumns = @JoinColumn(name = "fanfic_id"))
    @Column(name = "fandom")
    private List<String> fandoms;

    @ElementCollection
    @CollectionTable(name = "pairings", joinColumns = @JoinColumn(name = "fanfic_id"))
    @Column(name = "pairing")
    private List<String> pairings;

    @ElementCollection
    @CollectionTable(name = "languages", joinColumns = @JoinColumn(name = "fanfic_id"))
    @Column(name = "language")
    private List<String> languages;

    @ElementCollection
    @CollectionTable(name = "genres", joinColumns = @JoinColumn(name = "fanfic_id"))
    @Column(name = "genre")
    private List<String> genres;
}
