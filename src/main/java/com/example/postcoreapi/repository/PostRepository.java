package com.example.postcoreapi.repository;


import com.example.postcoreapi.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, String> {
}
