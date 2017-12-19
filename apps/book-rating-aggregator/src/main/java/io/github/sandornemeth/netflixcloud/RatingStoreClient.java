package io.github.sandornemeth.netflixcloud;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("rating-store")
public interface RatingStoreClient {



}
