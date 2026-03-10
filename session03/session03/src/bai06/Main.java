package bai06;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Post> posts = new ArrayList<>();

        List<String> tags1 = new ArrayList<>();
        tags1.add("java");
        tags1.add("backend");

        List<String> tags2 = new ArrayList<>();
        tags2.add("python");
        tags2.add("data");

        posts.add(new Post(tags1));
        posts.add(new Post(tags2));

        List<String> result = posts.stream()
                .flatMap(post -> post.getTags().stream())
                .toList();

        System.out.println(result);
    }
}