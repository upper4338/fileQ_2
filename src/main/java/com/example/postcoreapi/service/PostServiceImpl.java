package com.example.postcoreapi.service;

import com.example.postcoreapi.entity.PostEntity;
import com.example.postcoreapi.model.PostModel;
import com.example.postcoreapi.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private HashMap<String, PostModel> postMap = new HashMap<>();

    @Autowired
    private PostRepository postRepository;

    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public void createPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        PostEntity postEntity = modelMapper.map(postModel, PostEntity.class);
        postRepository.save(postEntity);
    }

    @Override
    public List<PostModel> getAllPosts() {
        List<PostModel> postModels = new ArrayList<>();
        postRepository.findAll().forEach(postEntity -> {
            postModels.add(modelMapper.map(postEntity, PostModel.class));
        });
        return postModels;
    }

    @Override
    public PostModel getPostById(String postId) {
        PostEntity postEntity =  postRepository.findById(postId).get();
        return modelMapper.map(postEntity, PostModel.class);
    }

    @Override
    public void updatePostById(String postId, PostModel postModel) {
        postModel.setPostId(postId);
        PostEntity postEntity = modelMapper.map(postModel, PostEntity.class);
        postRepository.save(postEntity);
    }

    @Override
    public void deletePostById(String postId) {
        postRepository.deleteById(postId);
    }
}
