public class ElementMajoritaire {

    /**
     * Retourne l'élément majoritaire du tableau t s'il existe.
     * Un élément est majoritaire s'il apparaît plus de n/2 fois.
     *
     * @param t tableau d'entiers
     * @return élément majoritaire ou -1
     */
    public static int elementMajoritaire(int[] t) {

        // Cas du tableau vide
        if (t.length == 0) {
            return -1;
        }

        // Première passe : algorithme de Boyer-Moore
        int candidat = 0;
        int compteur = 0;

        for (int x : t) {

            if (compteur == 0) {
                candidat = x;
                compteur = 1;
            } else if (x == candidat) {
                compteur++;
            } else {
                compteur--;
            }
        }

        // Deuxième passe : vérification du candidat
        int occurrences = 0;

        for (int x : t) {
            if (x == candidat) {
                occurrences++;
            }
        }

        if (occurrences > t.length / 2) {
            return candidat;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] tests = {
            {3, 3, 4, 3, 5},
            {2, 2, 1, 2, 3, 2, 2},
            {1, 1, 1, 1},
            {7},
            {1, 2, 3, 4},
            {1, 2, 2, 3},
            {1, 1, 2, 2},
            {-1, -1, -1, 2, 3},
            {-2, -2, -2, -2, 1, 3},
            {},
            {10}
        };

        int[] resultatsAttendus = {
            3,
            2,
            1,
            7,
            -1,
            -1,
            -1,
            -1,
            -2,
            -1,
            10
        };

        for (int i = 0; i < tests.length; i++) {

            System.out.print("Test " + (i + 1) + " : ");

            int resultat = elementMajoritaire(tests[i]);

            System.out.println("Résultat = " + resultat
                    + " | Attendu = " + resultatsAttendus[i]);
        }
    }
}
