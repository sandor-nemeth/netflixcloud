package io.github.sandornemeth.netflixcloud;

import com.google.common.collect.Lists;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class RatingController {

    private List<Rating> ratings;

    public RatingController() {
        this.ratings = Lists.newArrayList(
                new Rating(1, "book", 3),
                new Rating(1, "book", 4),
                new Rating(1, "book", 3),
                new Rating(2, "book", 3),
                new Rating(2, "book", 4),
                new Rating(3, "book", 3),
                new Rating(3, "book", 4),
                new Rating(3, "book", 1),
                new Rating(3, "book", 5),
                new Rating(2, "movie", 3),
                new Rating(4, "movie", 4),
                new Rating(8, "movie", 3)
        );
    }

    @GetMapping(value = {"/books/{bookId}"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Rating> findBookRatings(@PathVariable("bookId") long bookId) {
        return this.ratings.stream()
                .filter(rating -> Objects.equals("book", rating.getType()))
                .filter(rating -> bookId == rating.getObjectId())
                .collect(Collectors.toList());
    }

    @GetMapping(value = {"/books/{bookId}/average"}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Double findBookAverageRating(@PathVariable("bookId") long bookId) {
        return this.ratings.stream()
                .filter(rating -> Objects.equals("book", rating.getType()))
                .filter(rating -> bookId == rating.getObjectId())
                .mapToInt(Rating::getRating)
                .average()
                .orElseGet(() -> 0.0);
    }

}
