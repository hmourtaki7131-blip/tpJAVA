public class MaxRectangle {

    static class Rectangle {
        int top;
        int left;
        int bottom;
        int right;
        int area;
    }

    /**
     * Retourne l'aire du plus grand rectangle de 1.
     */
    public static int maxRectangle(int[][] m) {
        return trouverMaxRectangle(m).area;
    }

    /**
     * Trouve le plus grand rectangle de 1
     * et retourne ses coordonnées.
     */
    public static Rectangle trouverMaxRectangle(int[][] m) {

        int R = m.length;

        if (R == 0) {
            Rectangle r = new Rectangle();
            r.area = 0;
            return r;
        }

        int C = m[0].length;

        if (C == 0) {
            Rectangle r = new Rectangle();
            r.area = 0;
            return r;
        }

        int[] heights = new int[C];

        Rectangle meilleur = new Rectangle();
        meilleur.area = 0;

        // Parcours ligne par ligne
        for (int i = 0; i < R; i++) {

            // Construire les hauteurs
            for (int j = 0; j < C; j++) {

                if (m[i][j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            // Plus grand rectangle dans l'histogramme
            for (int right = 0; right < C; right++) {

                int minHeight = heights[right];

                for (int left = right; left >= 0; left--) {

                    minHeight = Math.min(minHeight, heights[left]);

                    int width = right - left + 1;
                    int area = minHeight * width;

                    if (area > meilleur.area) {

                        meilleur.area = area;
                        meilleur.left = left;
                        meilleur.right = right;
                        meilleur.bottom = i;
                        meilleur.top = i - minHeight + 1;
                    }
                }
            }
        }

        return meilleur;
    }

    public static void main(String[] args) {

        int[][] m1 = {
            {0}
        };

        int[][] m2 = {
            {1}
        };

        int[][] m3 = {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        int[][] m4 = {
            {1, 1, 0, 1},
            {1, 1, 0, 1},
            {0, 0, 1, 1}
        };

        int[][] m5 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] m6 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        tester(m1, "Test 1");
        tester(m2, "Test 2");
        tester(m3, "Test 3");
        tester(m4, "Test 4");
        tester(m5, "Test 5");
        tester(m6, "Test 6");
    }

    public static void tester(int[][] m, String nom) {

        Rectangle r = trouverMaxRectangle(m);

        System.out.println(nom);
        System.out.println("Aire maximale : " + r.area);

        if (r.area > 0) {
            System.out.println(
                "Coordonnées : top=" + r.top +
                ", left=" + r.left +
                ", bottom=" + r.bottom +
                ", right=" + r.right
            );
        } else {
            System.out.println("Aucun rectangle de 1");
        }

        System.out.println();
    }
}