import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class Main {

    public static void main(String[] args) {
        // Collect data.
        final WeightedObservedPoints obs = new WeightedObservedPoints();
        obs.add(1,	34.234064369);
        obs.add(2,	68.2681162306108);
        obs.add(3,	118.615899084602);
        obs.add(4,	184.138197238557);
        obs.add(5,	266.599877916276);
        obs.add(6,	364.147735251579);
        obs.add(7,	478.019226091914);
        obs.add(8,	608.140949270688);
        obs.add(9,	754.598868667148);
        obs.add(10,	916.128818085883);

// Instantiate a third-degree polynomial fitter.
        final PolynomialCurveFitter fitter = PolynomialCurveFitter.create(3);

// Retrieve fitted parameters (coefficients of the polynomial function).
        final double[] coeff = fitter.fit(obs.toList());
        for (Double co : coeff){
            System.out.println(co);
        }
    }

}