package com.techwright.joblisting.repository;

import com.techwright.joblisting.model.PostModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepo extends MongoRepository<PostModel, String> {
}
