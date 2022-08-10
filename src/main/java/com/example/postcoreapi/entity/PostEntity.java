package com.example.postcoreapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    @Id
    private String postId;

    private String clientId;
    private String postRecipientId;

    private String postItem;
    private String status;

}
