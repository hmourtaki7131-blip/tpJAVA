public class MaxSubarray {

    /**
     * Retourne la somme maximale d'une sous-suite contiguë
     * dans le tableau t.
     *
     * @param t tableau d'entiers
     * @return somme maximale
     */
    public static int maxSubarraySum(int[] t) {

        if (t.length == 0) {
            return 0;
        }

        int currentSum = t[0];
        int maxSum = t[0];

        for (int i = 1; i < t.length; i++) {

            currentSum = Math.max(t[i], currentSum + t[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    /**
     * Affiche la sous-suite contiguë de somme maximale
     * avec ses indices.
     */
    public static void afficherMaxSubarray(int[] t) {

        if (t.length == 0) {
            System.out.println("Tableau vide");
            return;
        }

        int currentSum = t[0];
        int maxSum = t[0];

        int start = 0;
        int bestStart = 0;
        int bestEnd = 0;

        for (int i = 1; i < t.length; i++) {

            if (t[i] > currentSum + t[i]) {
                currentSum = t[i];
                start = i;
            } else {
                currentSum += t[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                bestStart = start;
                bestEnd = i;
            }
        }

        System.out.println("Somme maximale = " + maxSum);

        System.out.print("Sous-suite : ");

        for (int i = bestStart; i <= bestEnd; i++) {
            System.out.print(t[i] + " ");
        }

        System.out.println();
        System.out.println("Indice début = " + bestStart);
        System.out.println("Indice fin = " + bestEnd);
    }

    public static void main(String[] args) {

        int[][] tests = {
            {-2, 1, -3, 4, -1, 2, 1, -5, 4},
            {1, 2, 3, 4},
            {-1, -2, -3},
            {5},
            {-7},
            {-2, -1, 3, 4, -5},
            {1, -1, 1, -1, 1}
        };

        int[] resultatsAttendus = {
            6,
            10,
            -1,
            5,
            -7,
            7,
            1
        };

        for (int i = 0; i < tests.length; i++) {

            System.out.print("Test " + (i + 1) + " : ");

            int resultat = maxSubarraySum(tests[i]);

            System.out.println("Résultat = " + resultat
                    + " | Attendu = " + resultatsAttendus[i]);
        }

        System.out.println();
        System.out.println("=== Sous-suite maximale de l'exemple ===");

        int[] exemple = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        afficherMaxSubarray(exemple);
    }
}