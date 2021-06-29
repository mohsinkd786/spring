package com.mohsinkd786.controller;

import com.mohsinkd786.dto.Book;
import com.mohsinkd786.dto.Page;
import com.mohsinkd786.service.PublishingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/publish")
@RestController
public class PublishingController {

    @Autowired
    private PublishingService publishingService;

    @GetMapping
    public List<Book> findBooks(){
        return publishingService.findBooks();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.ok(publishingService.createBook(book));
    }

    @PostMapping("{bookId}")
    public ResponseEntity<Boolean> createPagesForBook(@RequestBody Page page,@PathVariable Long bookId){
        return ResponseEntity.ok(publishingService.createPages(page,bookId));
    }
}
