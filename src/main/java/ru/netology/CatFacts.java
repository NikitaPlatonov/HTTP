package ru.netology;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CatFacts {
    private final int id;
    private final String text;
    private final String user;
    private final int upvotes;

    public CatFacts(
            @JsonProperty("id") int id,
            @JsonProperty("text") String text,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") int upvotes
    ) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.upvotes = upvotes;
    }

    @Override
    public String toString() {
        return "CatFacts" +
                "\n id: " + id +
                "\n text: " + text +
                "\n user: " + user +
                "\n upvotes: " + upvotes;
    }
}
