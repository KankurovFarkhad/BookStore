package com.halyk.bookstore.data.representation;

import com.halyk.bookstore.data.request.AuthorRequest;
import com.halyk.bookstore.data.request.GenreRequest;
import com.halyk.bookstore.data.request.PublisherRequest;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BookRepresentation {
    private double cost;
    private String name;
    private int numberOfPages;
    private LocalDate releaseDate;
    private PublisherRequest publisher;
    private Long countOfSameBooks;
    private List<AuthorRepresentation> authors;
    private List<GenreRepresentation> genres;
}

