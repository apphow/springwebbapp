package com.aprilsapps.springwebbapp.bootstrap;

import com.aprilsapps.springwebbapp.domain.Author;
import com.aprilsapps.springwebbapp.domain.Book;
import com.aprilsapps.springwebbapp.repositories.AuthorRepository;
import com.aprilsapps.springwebbapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
// when Spring implements this Component, it'll bring it into the Spring context
// it will do dependency injection into the constructor for an instance of the authorRepository and bookRepository.
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // set up a couple authors and books

        Author author1 = new Author("J.K.", "Rowling");
        Book bb1 = new Book("Harry Potter", "12345678");
        // add the book to author
        author1.getBooks().add(bb1);
        //add the author to book
        bb1.getAuthors().add(author1);
        // save both of these in the repository/H2 database
        authorRepository.save(author1);
        bookRepository.save(bb1);

        Author author2 = new Author("Toni", "Morrison");
        Book bb2 = new Book("Beloved", "12345678");

        author2.getBooks().add(bb2);
        bb2.getAuthors().add(author2);

        authorRepository.save(author2);
        bookRepository.save(bb2);

        System.out.println("Started Bootstrap successfully");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());

    }
}
