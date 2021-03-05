package com.example.junitmockitojdoc;

import com.example.junitmockitojdoc.model.Parent;
import com.example.junitmockitojdoc.repository.IParentRepo;

import java.util.List;

/**
 * ScoreSystemService class calculates Parent Score
 */

public class ParentScoreSystemService {

    final IParentRepo parentRepo;

    public ParentScoreSystemService(IParentRepo parentRepo) {
        this.parentRepo = parentRepo;
    }

    /**
     * Provides method for calculation of ParentScore, part of TotalScore
     * @param isEmployed boolean if true gives +1 point
     * @param hasEmployedSpouse boolean if true gives +1 point
     * @return int returns total ParentScore (min=0, max=2)
     */
    public int parentScore(final boolean isEmployed, final boolean hasEmployedSpouse) {
        int score = 0;
        List<Parent> parents = parentRepo.findAll();
        if (isEmployed == true) {
            score++;
        } if (hasEmployedSpouse == true) {
            score++;
        }
        return score;
    }

}
