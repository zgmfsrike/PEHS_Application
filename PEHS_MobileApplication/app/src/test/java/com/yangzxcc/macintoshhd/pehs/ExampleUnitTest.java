package com.yangzxcc.macintoshhd.pehs;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
//     value = (0.08183 * ageValue) + (0.39499 * SexType) + (0.02084 * systolicValue)
//                    + (0.699741921871007 * isdiabetes) + (0.00212 * cholesterolValue) + (0.41916 * Smoked);
//    pFullScoreBuffer = 0.978296;
//    valueBuffer = value - 7.044233;
//
//    Pfullscore = 1- (Math.pow(pFullScoreBuffer,Math.exp(valueBuffer)));


        //Case 1
        assertEquals(7.302741921871008,0.08183 * 35 + 0.39499 * 1 + 0.02084 * 120
                + 0.699741921871007 * 1 + 0.00212 * 200 + 0.41916 * 1);
        assertEquals(0.25850892187100794,7.302741921871008-7.044233);
        assertEquals(2.801618875400913,(1- (Math.pow(0.978296,Math.exp(0.25850892187100794))))*100);

        //Case 2
        assertEquals(6.883581921871008,0.08183 * 35 + 0.39499 * 1 + 0.02084 * 120
                + 0.699741921871007 * 1 + 0.00212 * 200 + 0.41916 * 0);
        assertEquals(-0.16065107812899182,6.883581921871008-7.044233);
        assertEquals(1.8512909018161605,(1- (Math.pow(0.978296,Math.exp(-0.16065107812899182))))*100);

    }
}