package uia.run;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uia.sequence.SequenceGenerator;
import uia.sequence.XORSequenceGenerator;

import java.util.Arrays;


public class TrainingSequenceTest {

    TrainingSequence trainingSequence;

    @Before
    public void setUp() throws Exception {
        SequenceGenerator sequenceGenerator = new XORSequenceGenerator();
        trainingSequence= sequenceGenerator.generateSequence(4,4);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void trainData(){
        System.out.println("input");
        for (double[] d :trainingSequence.input)
        System.out.println(Arrays.toString(d));
        System.out.println("output");
        for (double[] d :trainingSequence.ideal)
        System.out.println(Arrays.toString(d));

    }
}
