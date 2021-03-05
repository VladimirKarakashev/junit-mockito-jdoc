package com.example.junitmockitojdoc;

import com.example.junitmockitojdoc.model.Parent;
import com.example.junitmockitojdoc.repository.IParentRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


/**
 * Parametrized test for {@link ParentScoreSystemService} class
 */


@RunWith(Parameterized.class)
public class ParentScoreParamTest {
    @Parameters(name = "{index}: with parentName={0}, " +
                                    "isEmployed={1}, " +
                                    "hasEmployedSpouse={2}, " +
                                    "expected parentScore={3}" )
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"Иван Иванов", true, true, 2},
            {"Тодор Тодоров", true, false, 1},
            {"Йордан Йрданов", false, true, 1},
            {"Мария Маринова", false, false, 0},
        });
    }

    @Parameter(0)
    public String parentName;
    @Parameter(1)
    public boolean isEmployed;
    @Parameter(2)
    public boolean hasEmployedSpouse;
    @Parameter(3)
    public int expectedParentScore;

    private ParentScoreSystemService parentScoreSystemService;
    private IParentRepo parentRepo;

    @Before
    public void Setup() {
        parentRepo = mock(IParentRepo.class);
        Parent parent = new Parent();
        parent.setParentName("parentName");
        parent.setEmployed(true);
        parent.setHasEmployedSpouse(true);
        List<Parent> parents = Arrays.asList(parent);
        doReturn(parents).when(parentRepo).findAll();
        parentScoreSystemService = new ParentScoreSystemService(parentRepo);
    }

    @Test
    public void testParentScore() {
        final int score = parentScoreSystemService.parentScore(isEmployed, hasEmployedSpouse);
        assertEquals(expectedParentScore, score);
    }


}
