package com.techwright.joblisting.repository;

import com.mongodb.client.*;
import com.techwright.joblisting.model.PostModel;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImpl implements SearchRepo{

    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter convert;

    @Override
    public List<PostModel> findByFilter(String filter) {

        final List<PostModel> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("youtube");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                new Document("query", filter).append("path", Arrays.asList("tech", "desc", "profile")))),
                new Document("$sort",
                new Document("exp", 1L)),
                new Document("$limit", 5L)));

        result.forEach(doc -> posts.add(convert.read(PostModel.class, doc)));

        return posts;
    }
}
