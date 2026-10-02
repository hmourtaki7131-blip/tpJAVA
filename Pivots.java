public class Pivots {

    /**
     * Affiche tous les pivots du tableau t.
     *
     * @param t tableau d'entiers
     */
    public static void afficherPivots(int[] t) {

        int n = t.length;

        // Si le tableau contient moins de 3 éléments,
        // il n'y a pas de position intermédiaire.
        if (n < 3) {
            System.out.println("Aucun pivot");
            return;
        }

        // Tableau des maximums préfixés
        int[] prefixMax = new int[n];

        prefixMax[0] = t[0];

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], t[i]);
        }

        // Tableau des minimums suffixés
        int[] suffixMin = new int[n];

        suffixMin[n - 1] = t[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], t[i]);
        }

        // Affichage des pivots
        boolean trouve = false;

        System.out.print("Pivots : ");

        for (int i = 1; i <= n - 2; i++) {

            if (prefixMax[i - 1] <= t[i]
                    && suffixMin[i + 1] >= t[i]) {

                System.out.print(t[i] + " ");
                trouve = true;
            }
        }

        if (!trouve) {
            System.out.println("Aucun pivot");
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] t1 = {2, 4, 3, 5, 6};
        int[] t2 = {1, 2, 3, 4, 5};
        int[] t3 = {5, 4, 3, 2, 1};
        int[] t4 = {3, 3, 3, 3};
        int[] t5 = {7, 1, 5, 2, 6, 3, 4};

        System.out.println("Test 1 :");
        afficherPivots(t1);

        System.out.println("Test 2 :");
        afficherPivots(t2);

        System.out.println("Test 3 :");
        afficherPivots(t3);

        System.out.println("Test 4 :");
        afficherPivots(t4);

        System.out.println("Test 5 :");
        afficherPivots(t5);
    }
}

