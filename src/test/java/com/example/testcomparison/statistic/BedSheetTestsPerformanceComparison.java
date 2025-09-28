package com.example.testcomparison.statistic;
import org.apache.commons.math3.stat.inference.TTest;
public class BedSheetTestsPerformanceComparison {

    public static void main(String[] args) {
        // tempos simulados (ns) de duas execuções repetidas
        double[] junitTimes = {5157635.12, 5228354.98, 5303516.60, 5113273.63, 5028936.37, 5387006.05, 5172549.73, 5181829.98, 4962872.13, 5055560.07};
        double[] springTimes = {19364285.69, 18672266.57, 18911425.62, 18319226.90, 18612767.23, 19475899.70, 18966646.29, 18794101.25, 18710004.59, 18882473.51};

        TTest tTest = new TTest();

        // Teste t para duas amostras independentes
        double pValue = tTest.tTest(junitTimes, springTimes);

        System.out.println("p-value = " + pValue);

        // Interpretação (nível de significância 0.05 = 95%)
        if (pValue < 0.05) {
            System.out.println("✅ Diferença significativa entre as médias.");
        } else {
            System.out.println("⚠️ Diferença NÃO significativa entre as médias.");
        }
    }
}
