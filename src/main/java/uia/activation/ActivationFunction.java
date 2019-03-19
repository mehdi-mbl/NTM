package uia.activation;

public interface ActivationFunction {

    double getValue(final double x);
    double getValue(final double x, final double alpha);

    double value(double x);
    double derivative(double y);

    double derivative(double grad, double value);
}


