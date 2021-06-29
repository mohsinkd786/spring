package com.mohsinkd786.repository.mysql;

import com.mohsinkd786.dto.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
