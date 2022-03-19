package com.librarymanagmentsytem.librarymanagmentsytem.service;

import com.librarymanagmentsytem.librarymanagmentsytem.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

  private static final List<Book> BOOKS;

  static {
    BOOKS = new ArrayList<>();
    BOOKS.add(new Book("1", "Design Patterns", "Head First"));
    BOOKS.add(new Book("2", "Spring boot in action", "Head First"));
  }

  public List<Book> retrieveAllBooks() {
    return BOOKS;
  }

  public Book retrieveBook(final String id) {
    Optional<Book> optionalBook = BOOKS.stream()
      .filter(book -> book.getId().equals(id))
      .findFirst();

    return optionalBook.get();
  }
}
