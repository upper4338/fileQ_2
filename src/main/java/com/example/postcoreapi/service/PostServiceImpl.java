package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    private static final HashMap<String, PostModel> postMap = new HashMap<>();

    static {
        PostModel p1 = new PostModel(
                UUID.randomUUID().toString(),
                "1",
                "2",
                "Post 1",
                "Status 1"
        );
        PostModel p2 = new PostModel(
                UUID.randomUUID().toString(),
                "1",
                "2",
                "Post 2",
                "Status 2"
        );
        PostModel p3 = new PostModel(
                UUID.randomUUID().toString(),
                "2",
                "1",
                "Post 3",
                "Status 3"
        );
        postMap.put(p1.getPostId(), p1);
        postMap.put(p2.getPostId(), p2);
        postMap.put(p3.getPostId(), p3);
    }

    @Override
    public void createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        postMap.put(postModel.getPostId(), postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return postMap.get(postId);
    }

    @Override
    public void updatePostById(String postId, PostModel postModel) {
        postModel.setPostId(postId);
        postMap.put(postId, postModel);
    }

    @Override
    public void deletePostById(String postId) {
        postMap.remove(postId);
    }
}
