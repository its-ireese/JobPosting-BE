package com.techwright.joblisting.repository;

import com.techwright.joblisting.model.PostModel;

import java.util.List;

public interface SearchRepo {

    List<PostModel> findByFilter(String filter);
}
