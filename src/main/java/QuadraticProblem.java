import org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QuadraticProblem
        implements DifferentiableMultivariateVectorFunction, Serializable {

    private List<Double> x;
    private List<Double> y;

    public QuadraticProblem() {
        x = new ArrayList<Double>();
        y = new ArrayList<Double>();
    }

    public void addPoint(double x, double y) {
        this.x.add(x);
        this.y.add(y);
    }

    public double[] calculateTarget() {
        double[] target = new double[y.size()];
        for (int i = 0; i < y.size(); i++) {
            target[i] = y.get(i).doubleValue();
        }
        return target;
    }

    private double[][] jacobian(double[] variables) {
        double[][] jacobian = new double[x.size()][3];
        for (int i = 0; i < jacobian.length; ++i) {
            jacobian[i][0] = x.get(i) * x.get(i);
            jacobian[i][1] = x.get(i);
            jacobian[i][2] = 1.0;
        }
        return jacobian;
    }

    public double[] value(double[] variables) {
        double[] values = new double[x.size()];
        for (int i = 0; i < values.length; ++i) {
            values[i] = (variables[0] * x.get(i) + variables[1]) * x.get(i) + variables[2];
        }
        return values;
    }

    public MultivariateMatrixFunction jacobian() {
        return new MultivariateMatrixFunction() {
            private static final long serialVersionUID = -8673650298627399464L;
            public double[][] value(double[] point) {
                return jacobian(point);
            }
        };
    }
}