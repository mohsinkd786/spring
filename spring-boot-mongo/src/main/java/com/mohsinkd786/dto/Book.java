package com.mohsinkd786.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Table(name = "book")
@Entity
@Data
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;
    private String author;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Page> pages;
}
