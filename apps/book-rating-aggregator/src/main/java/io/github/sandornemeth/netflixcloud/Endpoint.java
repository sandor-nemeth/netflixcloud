package io.github.sandornemeth.netflixcloud;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint {

    private BookStoreClient books;
    private RatingStoreClient ratings;

    @Autowired
    public Endpoint(final BookStoreClient books, final RatingStoreClient ratings) {
        this.books = books;
        this.ratings = ratings;
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection<BookWithRatings> getBooks() {
        return books.books().stream()
                .map(book -> new BookWithRatings(book, ratings.averageRatingOf(book.getId()), ratings.findBookRatings(book.getId())))
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unused")
    public static class BookWithRatings {
        private Book book;
        private Double averageRating;
        private Collection<Rating> ratings;

        BookWithRatings(final Book book, final Double averageRating, final Collection<Rating> ratings) {
            this.book = book;
            this.averageRating = averageRating;
            this.ratings = ratings;
        }

        public Book getBook() {
            return book;
        }

        public Double getAverageRating() {
            return averageRating;
        }

        public Collection<Rating> getRatings() {
            return ratings;
        }
    }
}
