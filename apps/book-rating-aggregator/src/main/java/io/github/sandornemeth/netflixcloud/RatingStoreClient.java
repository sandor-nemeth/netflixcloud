package io.github.sandornemeth.netflixcloud;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("rating-store")
public interface RatingStoreClient {

    @RequestMapping(value = "/books/{bookId}", method = RequestMethod.GET)
    List<Rating> findBookRatings(@PathVariable("bookId") long bookId);

    @RequestMapping(value = "/books/{bookId}/average", method = RequestMethod.GET)
    Double averageRatingOf(@PathVariable("bookId") long bookId);

}
