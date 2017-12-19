## Deployment
 
### Eureka

```bash
docker service create --detach=true \
    --name=eureka \
    --network=clusternet \
    --publish=18761:8761 \
    -e EUREKA_SERVER_RENEWAL_PERCENT_THRESHOLD=0.49 \
    sandornemeth/eureka-app
```

### Config server

```bash
docker service create --detach=true \
    --name=configserver \
    --network=clusternet \
    -e SPRING_CLOUD_CONFIG_SERVER_GIT_URI=https://github.com/sandor-nemeth/netflixcloud-config.git \
    sandornemeth/config-server
```

### Example application

```bash
docker service create --detach=true \
    --name=book-store \
    --network=clusternet \
    --publish=18080:8080 \
    sandornemeth/book-store
```

### Zuul

```bash
docker service create --detach=true \
    --name=zuul \
    --network=clusternet \
    --publish=19000:8080 \
    sandornemeth/zuul-app
```

### Zipkin

```bash
docker service create --detach=true \
    --name=zipkin \
    --network=clusternet \
    --publish=19001:8080 \
    sandornemeth/zipkin-app
```

### Service apps

```bash
docker service create --detach=true \
    --name=book-store \
    --network=clusternet \
    sandornemeth/book-store
docker service create --detach=true \
    --name=rating-store \
    --network=clusternet \
    sandornemeth/rating-store
docker service create --detach=true \
    --name=book-rating-aggregator \
    --publish=19080:8080 \
    --network=clusternet \
    sandornemeth/book-rating-aggregator
```
