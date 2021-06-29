package com.mohsinkd786.service;

import com.mohsinkd786.dto.Book;
import com.mohsinkd786.dto.Page;
import com.mohsinkd786.repository.mysql.BookRepository;
import com.mohsinkd786.repository.mysql.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class PublishingService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PageRepository pageRepository;

    public List<Book> findBooks(){
        Iterable<Book> iterable = bookRepository.findAll();
        Stream<Book> bookStream = StreamSupport.stream(iterable.spliterator(),false);
        return bookStream.collect(Collectors.toList());
    }

    public Book createBook(Book book){
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }
    public boolean createPages(Page page,Long bookId){
         bookRepository.findById(bookId).map(book -> {
                page.setBook(book);
                pageRepository.save(page);
            return null;
        });
         return true;
    }
}
