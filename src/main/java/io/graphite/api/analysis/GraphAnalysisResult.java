package io.graphite.api.analysis;

import io.graphite.result.Colors;

public record GraphAnalysisResult(

        int vertices,
        int edges,

        boolean directed,
        boolean weighted,

        boolean connected,
        boolean tree,
        boolean forest,
        boolean bipartite,
        boolean eulerian,
        boolean cyclic,

        double density,
        double averageDegree,

        int maxDegree,
        int minDegree

) implements Colors {

    private static String status(boolean value) {
        return value
                ? GREEN + "✓ Yes" + RESET
                : RED + "✗ No" + RESET;
    }

    @Override
    public String toString() {
        return """
                %s%sGraph Analysis%s
                %s──────────────────────────%s
                %s Vertices       :%s %d
                %s Edges          :%s %d
                
                %s Directed       :%s %s
                %s Weighted       :%s %s
                
                %s Connected      :%s %s
                %s Tree           :%s %s
                %s Forest         :%s %s
                %s Cyclic         :%s %s
                %s Bipartite      :%s %s
                %s Eulerian       :%s %s
                
                %s Max Degree     :%s %d
                %s Min Degree     :%s %d
                %s Avg Degree     :%s %.2f
                %s Density        :%s %.4f
                """.formatted(
                BOLD, CYAN, RESET,
                BLUE, RESET,
                YELLOW, RESET, vertices,
                YELLOW, RESET, edges,

                MAGENTA, RESET, status(directed),
                MAGENTA, RESET, status(weighted),

                GREEN, RESET, status(connected),
                GREEN, RESET, status(tree),
                GREEN, RESET, status(forest),
                RED, RESET, status(cyclic),
                CYAN, RESET, status(bipartite),
                BLUE, RESET, status(eulerian),

                WHITE, RESET, maxDegree,
                WHITE, RESET, minDegree,
                WHITE, RESET, averageDegree,
                WHITE, RESET, density
        );
    }

}
