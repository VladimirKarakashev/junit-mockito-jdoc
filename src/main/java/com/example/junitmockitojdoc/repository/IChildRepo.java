package com.example.junitmockitojdoc.repository;

import com.example.junitmockitojdoc.model.Child;

import java.util.List;

public interface IChildRepo {
    List<Child> findAll();
}
