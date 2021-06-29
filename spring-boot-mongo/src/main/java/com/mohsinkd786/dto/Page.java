package com.mohsinkd786.dto;

import lombok.Data;

import javax.persistence.*;

@Table(name = "page")
@Data
@Entity
public class Page {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private int pageNumber;
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;
}
