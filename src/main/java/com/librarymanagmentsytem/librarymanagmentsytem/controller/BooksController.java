package com.librarymanagmentsytem.librarymanagmentsytem.controller;

import com.librarymanagmentsytem.librarymanagmentsytem.model.Book;
import com.librarymanagmentsytem.librarymanagmentsytem.service.BooksService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ApiOperation("Below are all the API endpoints to query the Books resource")
public class BooksController {

  private final BooksService booksService;

  @Autowired
  public BooksController(final BooksService booksService) {
    this.booksService = booksService;
  }

  @ApiOperation(value = "Retrieve all the books", notes = "Notes go here")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Successfully retrieved all the books"),
    @ApiResponse(code = 401, message = "Not an authenticated user"),
    @ApiResponse(code = 403, message = "Not an authorized user"),
    @ApiResponse(code = 500, message = "Error on the application side")
  }
  )
  @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> books = booksService.retrieveAllBooks();
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  @ApiOperation(value = "Retrieve a book by ID", notes = "Notes go here too")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Successfully retrieved the book by ID"),
    @ApiResponse(code = 401, message = "Not an authenticated user"),
    @ApiResponse(code = 403, message = "Not an authorized user"),
    @ApiResponse(code = 500, message = "Error on the application side")
  }
  )
  @GetMapping(value = "/books/{bookID}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Book> getBookById(
    @PathVariable
    @ApiParam(name = "bookID", example = "df435gdfg34gdfg434ber")
    final String bookID) {
    Book book = booksService.retrieveBook(bookID);
    return new ResponseEntity<>(book, HttpStatus.OK);
  }

  @ApiOperation(value = "Add a book", notes = "Notes go here too")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Successfully added the book"),
    @ApiResponse(code = 401, message = "Not an authenticated user"),
    @ApiResponse(code = 403, message = "Not an authorized user"),
    @ApiResponse(code = 500, message = "Error on the application side")
  }
  )
  @PostMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Book> addBook(@RequestBody final Book book) {
    booksService.retrieveBook("1");
    return new ResponseEntity<>(booksService.retrieveBook("1"), HttpStatus.CREATED);
  }
}
