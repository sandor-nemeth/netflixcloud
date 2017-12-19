package io.github.sandornemeth.netflixcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BookController {

    private static final Logger LOG = LoggerFactory.getLogger(BookController.class);

    private Map<Long, Book> bookStore;

    public BookController() {
        bookStore = new HashMap<>();
        bookStore.put(1L, new Book(1L, "Don Quixote", "Miguel de Cervantes"));
        bookStore.put(2L, new Book(2L, "Moby Dick", "Herman Melville"));
        bookStore.put(3L, new Book(3L, "In Search of Lost Time", "Marcel Proust"));
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection<Book> listBooks() {
        LOG.info("Returning books");
        return bookStore.values();
    }

}
