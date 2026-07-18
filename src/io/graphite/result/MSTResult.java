package io.graphite.result;

import java.util.List;

public record MSTResult(int cost, List<MSTEdge> edges) implements Colors {
    public MSTResult {
        edges = List.copyOf(edges);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(Colors.CYAN)
                .append("═══════════════ Minimum Spanning Tree ═══════════════")
                .append(Colors.RESET)
                .append('\n');

        builder.append("Total Cost : ")
                .append(Colors.GREEN)
                .append(cost)
                .append(Colors.RESET)
                .append('\n');

        builder.append("Edges")
                .append(Colors.MAGENTA)
                .append(" (")
                .append(edges.size())
                .append(")")
                .append(Colors.RESET)
                .append('\n');


        if (!edges.isEmpty()) {
            int maxWeightWidth = edges.stream()
                    .map(MSTEdge::weight)
                    .map(String::valueOf)
                    .mapToInt(String::length)
                    .max()
                    .orElse(1);

            builder
                    .append("─────────────────────────────────────────────────────")
                    .append('\n');

            for (MSTEdge edge : edges) {
                builder.append("  ")
                        .append(Colors.YELLOW)
                        .append("• ")
                        .append(String.format(
                                "%d ──(%" + maxWeightWidth + "d)──> %d",
                                edge.source(),
                                edge.weight(),
                                edge.destination())
                        )
                        .append(Colors.RESET)
                        .append('\n');
            }
            builder.append("─────────────────────────────────────────────────────");
        }

        return builder.toString();
    }
}
