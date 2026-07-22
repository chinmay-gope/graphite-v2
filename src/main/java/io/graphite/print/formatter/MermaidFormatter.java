package io.graphite.print.formatter;

import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.print.GraphFormatter;
import io.graphite.print.GraphPrinter;
import io.graphite.result.Colors;

/**
 * Formats a graph using Mermaid diagram syntax.
 *
 * <p>The generated representation can be embedded directly into Markdown
 * documents and rendered by Mermaid-compatible editors and documentation
 * platforms.</p>
 *
 * @author Chinmay
 * @version 2.0
 * @see GraphPrinter
 * @since 2.0
 */
public final class MermaidFormatter
        implements GraphFormatter, Colors {

    @Override
    public String format(IGraph graph) {

        StringBuilder out = new StringBuilder();

        out.append(BOLD)
                .append(CYAN)
                .append(graph.isDirected()
                        ? "flowchart TD"
                        : "graph TD")
                .append(RESET)
                .append("\n\n");

        String connector =
                graph.isDirected()
                        ? " --> "
                        : " --- ";

        for (Edge edge : graph.edges()) {

            out.append("    ")
                    .append(YELLOW)
                    .append(edge.source())
                    .append(RESET)
                    .append(connector);

            if (graph.isWeighted()) {

                out.append("|")
                        .append(MAGENTA)
                        .append(edge.weight())
                        .append(RESET)
                        .append("| ");
            }

            out.append(GREEN)
                    .append(edge.destination())
                    .append(RESET)
                    .append("\n");
        }

        return out.toString();
    }
}
