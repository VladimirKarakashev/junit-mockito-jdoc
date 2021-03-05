package com.example.junitmockitojdoc.repository;

import com.example.junitmockitojdoc.model.Child;
import com.example.junitmockitojdoc.repository.IChildRepo;

import java.util.List;

/**
 * ScoreSystemService class calculates Child score and combined score
 */

public class ChildScoreSystemService {

    final IChildRepo childRepo;

    public ChildScoreSystemService(IChildRepo childRepo) {
        this.childRepo = childRepo;
    }


    /**
     * Provides method for calculation of ChildScore, part of TotalScore
     * @param hasDisability boolean if true gives +2 points
     * @param hasTwin boolean if true gives +1 points
     * @param hasOtherSibling boolean if true gives +1 points
     * @return int returns ChildScore (min=0, max=4)
     */
    public int childScore(final boolean hasDisability,
                          final boolean hasTwin,final boolean hasOtherSibling) {
        int score = 0;
        List<Child> children = childRepo.findAll();
        if (hasDisability == true) {
            score = score + 2;
        } if (hasTwin == true) {
            score++;
        } if (hasOtherSibling == true) {
            score++;
        }
        return score;
    }
}
