package com.aprilsapps.springwebbapp.bootstrap;

import com.aprilsapps.springwebbapp.domain.Author;
import com.aprilsapps.springwebbapp.domain.Book;
import com.aprilsapps.springwebbapp.domain.Publisher;
import com.aprilsapps.springwebbapp.repositories.AuthorRepository;
import com.aprilsapps.springwebbapp.repositories.BookRepository;
import com.aprilsapps.springwebbapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// when Spring implements this Component, it'll bring it into the Spring context
// it will do dependency injection into the constructor for an instance of the authorRepository and bookRepository.
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // set up a couple authors and books

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setName("St. Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        Author author1 = new Author("J.K.", "Rowling");
        Book bb1 = new Book("Harry Potter", "12345678");
        Publisher pub1 = new Publisher();
        // add the book to author
        author1.getBooks().add(bb1);
        //add the author to book
        bb1.getAuthors().add(author1);
        // save both of these in the repository/H2 database
        authorRepository.save(author1);
        bookRepository.save(bb1);

        bb1.setPublisher(publisher);
        publisher.getBooks().add(bb1);
        publisherRepository.save(publisher);



        Author author2 = new Author("Toni", "Morrison");
        Book bb2 = new Book("Beloved", "12345678");

        author2.getBooks().add(bb2);
        bb2.getAuthors().add(author2);

        bb2.setPublisher(publisher);
        publisher.getBooks().add(bb2);

        authorRepository.save(author2);
        bookRepository.save(bb2);
        publisherRepository.save(publisher);

        System.out.println("Started Bootstrap successfully");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Books per Publisher: " + publisher.getBooks().size());

    }
}
