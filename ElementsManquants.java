 public class ElementsManquants {

    /**
     * Affiche tous les entiers entre 1 et n
     * qui ne sont pas présents dans le tableau t.
     *
     * @param t tableau d'entiers
     */
    public static void afficherElementsManquants(int[] t) {

        int n = t.length;

        boolean[] vu = new boolean[n + 1];

        // Marquer les valeurs présentes
        for (int x : t) {
            if (x >= 1 && x <= n) {
                vu[x] = true;
            }
        }

        boolean trouve = false;

        System.out.print("Éléments manquants : ");

        // Chercher les valeurs manquantes
        for (int k = 1; k <= n; k++) {
            if (!vu[k]) {
                System.out.print(k + " ");
                trouve = true;
            }
        }

        if (!trouve) {
            System.out.print("Aucun élément manquant");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] t1 = {1, 2, 3, 4};

        int[] t2 = {3, 3, 3};

        int[] t3 = {1, 1, 1, 1};

        int[] t4 = {4, 2, 2, 1, 5};

        int[] t5 = {1};

        int[] t6 = {1, 2, 3, 6};

        System.out.println("Test 1 :");
        afficherElementsManquants(t1);

        System.out.println("Test 2 :");
        afficherElementsManquants(t2);

        System.out.println("Test 3 :");
        afficherElementsManquants(t3);

        System.out.println("Test 4 :");
        afficherElementsManquants(t4);

        System.out.println("Test 5 :");
        afficherElementsManquants(t5);

        System.out.println("Test 6 :");
        afficherElementsManquants(t6);
    }
}
