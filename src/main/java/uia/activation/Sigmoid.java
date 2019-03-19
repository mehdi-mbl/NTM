package uia.activation;

public class Sigmoid  implements ActivationFunction{

    private final double _alpha;

    public Sigmoid() {
        this(1.0);
    }

    public Sigmoid(double alpha) {
        _alpha = alpha;
    }

    @Override
    public double getValue(final double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    @Override
    public double getValue(final double x, final double alpha) {
        return 1.0 / (1.0 + Math.exp(-x * alpha));

        //return 1.0 / (1.0 + expFast(-x * alpha));
    }

    public static double expFast(final double val) {
        final long tmp = (long) (1512775 * val + (1072693248 - 60801));
        return Double.longBitsToDouble(tmp << 32);
    }

    @Override
    public double value(double x) {
        return getValue(x, _alpha);
    }

    @Override
    public double derivative(double y) {
        return (_alpha * y * (1.0 - y));
    }


    public double derivative(double grad, double y) {
        return (grad * y * (1.0 - y));
    }

}
