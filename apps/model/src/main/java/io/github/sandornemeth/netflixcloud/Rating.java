package io.github.sandornemeth.netflixcloud;

public class Rating {
    private long objectId;
    private String type;
    private int rating;

    public Rating() {
    }

    public Rating(long objectId, String type, int rating) {
        this.objectId = objectId;
        this.type = type;
        this.rating = rating;
    }

    public long getObjectId() {
        return objectId;
    }

    public String getType() {
        return type;
    }

    public int getRating() {
        return rating;
    }
}
