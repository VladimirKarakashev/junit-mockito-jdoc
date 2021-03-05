package com.example.junitmockitojdoc.repository;

import com.example.junitmockitojdoc.model.Parent;

import java.util.Collections;
import java.util.List;

/**
 * Repository class for {@link Parent} class
 */

public class ParentRepo implements IParentRepo {

    /**
     * Return all parents from the data base.
     * @return not null {@link List<Parent>}
     */
    public List<Parent> findAll() {
        return Collections.emptyList();
    }
}
