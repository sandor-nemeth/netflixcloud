package io.github.sandornemeth.netflixcloud;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("book-store")
public interface BookStoreClient {

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    List<Book> books();

}
