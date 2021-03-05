package com.example.junitmockitojdoc.repository;

import com.example.junitmockitojdoc.ParentScoreSystemService;
import com.example.junitmockitojdoc.model.Parent;

import java.util.List;

/**
 * Interface for {@link ParentScoreSystemService}
 */

public interface IParentRepo {
    List<Parent> findAll();
}
