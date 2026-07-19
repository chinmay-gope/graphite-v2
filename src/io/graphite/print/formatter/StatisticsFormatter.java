package io.graphite.print.formatter;

import io.graphite.api.analysis.GraphAnalysis;
import io.graphite.exception.GraphException;
import io.graphite.graph.IGraph;
import io.graphite.print.GraphFormatter;

import java.util.function.BooleanSupplier;

import static io.graphite.result.Colors.*;

public final class StatisticsFormatter implements GraphFormatter {


    @Override
    public String format(IGraph graph) {
        GraphAnalysis analysis = graph.analysis();
        StringBuilder out = new StringBuilder();

        // Title
        out.append(BOLD).append(CYAN)
                .append("GRAPH SUMMARY")
                .append(RESET).append("\n\n");

        // Basic stats
        append(out, "Vertices", graph.vertexCount(), GREEN);
        append(out, "Edges", graph.edgeCount(), GREEN);

        out.append('\n');

        // Properties
        append(out, "Directed", yesNo(graph.isDirected()), BLUE);
        append(out, "Weighted", yesNo(graph.isWeighted()), BLUE);
        append(out, "Graph Type", graph.asImmutable().getClass().getSimpleName(), MAGENTA);

        out.append('\n');

        // Analysis
        // Analysis
        append(out, "Connected", safe(analysis::isConnected), YELLOW);
        append(out, "Tree", safe(analysis::isTree), YELLOW);
        append(out, "Forest", safe(analysis::isForest), YELLOW);
        append(out, "Cyclic", safe(analysis::isCyclic), YELLOW);
        append(out, "Bipartite", safe(analysis::isBipartite), YELLOW);
        append(out, "Eulerian", safe(analysis::isEulerian), YELLOW);

        out.append('\n');

        // Degrees & density
        append(out, "Max Degree", analysis.maxDegree(), RED);
        append(out, "Min Degree", analysis.minDegree(), RED);
        append(out, "Avg Degree", String.format("%.2f", analysis.averageDegree()), CYAN);
        append(out, "Density", String.format("%.4f", analysis.density()), CYAN);

        return out.toString();
    }

    private static void append(StringBuilder out, String key, Object value, String color) {
        out.append(BOLD).append(WHITE)
                .append(String.format("%-15s", key))
                .append(RESET).append(" : ")
                .append(color).append(value).append(RESET)
                .append('\n');
    }

    private static String yesNo(boolean value) {
        return value ? GREEN + "Yes" + RESET : RED + "No" + RESET;
    }

    private String safe(BooleanSupplier property) {

        try {

            return property.getAsBoolean()
                    ? GREEN + "Yes" + RESET
                    : RED + "No" + RESET;

        } catch (GraphException e) {

            return YELLOW + e.getMessage() + RESET;
        }
    }
}
