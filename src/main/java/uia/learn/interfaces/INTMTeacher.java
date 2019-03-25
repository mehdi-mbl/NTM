package uia.learn.interfaces;

import uia.ntm.NeuralTuringMachine;

import java.util.ArrayList;
import java.util.List;

public interface INTMTeacher {

    default List<double[]> trainAndGetOutput(double[][] input, double[][] knownOutput) {

        NeuralTuringMachine[] machines = trainInternal(input, knownOutput);
        return getMachineOutputs(machines);

    }

    default NeuralTuringMachine[] train(double[][] input, double[][] knownOutput) {
        return trainInternal(input, knownOutput);
    }

    NeuralTuringMachine[] trainInternal(double[][] input, double[][] knownOutput);

    static List<double[]> getMachineOutputs(NeuralTuringMachine[] machines) {
        List<double[]> realOutputs = new ArrayList<>(machines.length);
        for (NeuralTuringMachine machine : machines) {
            realOutputs.add(machine.getOutput());
        }
        return realOutputs;
    }
}


