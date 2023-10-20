package com.reeyanto.antaranews.models;

import java.util.List;

public class Data {

    List<Post> posts;

    public Data(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
