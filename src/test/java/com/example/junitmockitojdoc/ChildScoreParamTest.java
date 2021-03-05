package com.example.junitmockitojdoc;

import com.example.junitmockitojdoc.model.Child;
import com.example.junitmockitojdoc.repository.ChildScoreSystemService;
import com.example.junitmockitojdoc.repository.IChildRepo;
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
 * Parametrized test for {@link ChildScoreSystemService} class
 */

@RunWith(Parameterized.class)
public class ChildScoreParamTest {
    @Parameters(name = "{index}: with childName={0}, " +
                                     "hasDisability={1}, " +
                                     "hasTwin={2}, " +
                                     "hasOtherSibling={3}, " +
                                     "expectedChildScore={4}" )
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Иван", true, true, true, 4},
                {"Мария", true, false, true, 3},
                {"Петър", true, true, false, 3},
                {"Димитър", false, true, true, 2},
                {"Владимир", false, true, false, 1},
                {"Валентина", false, false, true, 1},
                {"Невена", false, false, false, 0},
        });
    }

    @Parameter(0)
    public String childName;
    @Parameter(1)
    public boolean hasDisability;
    @Parameter(2)
    public boolean hasTwin;
    @Parameter(3)
    public boolean hasOtherSibling;
    @Parameter(4)
    public int expectedChildScore;

    private ChildScoreSystemService childScoreSystemService;
    private IChildRepo childRepo;

    @Before
    public void Setup() {
        childRepo = mock(IChildRepo.class);
        Child child = new Child();
        child.setChildName("childName");
        child.setHasDisability(true);
        child.setHasTwin(true);
        child.setHasOtherSibling(true);
        List<Child> children = Arrays.asList(child);
        doReturn(children).when(childRepo).findAll();
        childScoreSystemService = new ChildScoreSystemService(childRepo);
    }

    @Test
    public void testChildScore() {
        final int score = childScoreSystemService.childScore(hasDisability,hasTwin,hasOtherSibling);
        assertEquals(expectedChildScore, score);
    }

}
