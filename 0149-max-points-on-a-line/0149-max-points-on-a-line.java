class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 2) return points.length;

        Map<String, Integer> koeffCountMap = new HashMap<>();

        // fp - first point
        for(int fp = 0; fp < points.length - 1; fp++) {
            // we don`t need to add another points with the same coefficient
            Set<String> visitedKeys = new HashSet<>();

            // sp - second point
            for(int sp = fp + 1; sp < points.length; sp++) {
                int x1 = points[fp][0];
                int x2 = points[sp][0];
                int y1 = points[fp][1];                  
                int y2 = points[sp][1];

                String koeffKey = "";

                // x`s are, we just get one of them as key
                if(x1 == x2) {
                    koeffKey = Integer.toString(x1);
                } else {  
                    // calculate linear coefficients       
                    double k = ((double)y1 - y2) / (x1 - x2);
                    //  b = y1 - kx1 doesn`t work because double has precision problem
                    double b = (x2 * y1 - x1 * y2) / (x2 - x1);
                    // dirty hack. we have unique combination k and b for map key
                    koeffKey = k + "!" + b;
                }

                // if we doesn`t add current coefficient for this point, add them
                if(!visitedKeys.contains(koeffKey)) {
                    // one count for the first point
                    koeffCountMap.putIfAbsent(koeffKey, 1);

                    // one count for others
                    koeffCountMap.put(koeffKey, koeffCountMap.get(koeffKey) + 1);
                    visitedKeys.add(koeffKey);
                }
            }
        }

        return Collections.max(koeffCountMap.values());
    }
}