package uia.ntm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uia.ntm.run.RunSequenceLearner;
import uia.ntm.run.sequence.XORSequenceGenerator;

import java.util.Arrays;

public class NeuralTuringMachineTest {

    RunSequenceLearner sequenceLearner;

    @Before
    public void setUp() throws Exception {
        /*
        Here set the parameters of the NTM:
        1st parameter: Size of you input data vector
        2nd parameter: number of column in the memory. Should match the input data vector size.
        3rd parameter: number of raws in the memory. usually matches your data size.
        4th parameter: number of heads you want to have.
        5th parameter: The number of nodes in the hidden layer of the controller
        6th parameter: The training data. I have some examples. You can generate your own data.
            To do that create a class tha implements uia.ntm.run.sequence.SequenceGenerator.java
            interface and implement the generateSequence function. There you can generate any random
            data or import data from a file.
        7th parameter: Set the error bellow which the learning process stops.
         */
        sequenceLearner= new RunSequenceLearner(8,8, 32,
                1, 64, new XORSequenceGenerator(),0.01);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void trainNTM() throws Exception{
        /*
        Here is the function that trains the NTM
        To print the memory and head, set verbose to True
         */
        sequenceLearner.runNTM(false);
    }

    @Test
    public void trainAndTestNTM() throws Exception{
        /*
        Here is the function that trains and test the NTM
         */

        // First train the NTM
       sequenceLearner.runNTM(false);
       NeuralTuringMachine ntm= sequenceLearner.machine;

       // Get your test data. Same here as explained in 6th parameter
        XORSequenceGenerator test= new XORSequenceGenerator();
        test.generateSequence(1,8);

        // Get your output
       ntm.process(test.getInput()[0]);
       double[] output =ntm.getOutput();

       //Print output
       System.out.println(Arrays.toString(output));

    }
}