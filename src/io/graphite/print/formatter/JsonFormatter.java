package io.graphite.print.formatter;

import io.graphite.api.analysis.GraphAnalysis;
import io.graphite.exception.GraphException;
import io.graphite.graph.IGraph;
import io.graphite.model.Edge;
import io.graphite.print.GraphFormatter;
import io.graphite.result.*;

import java.util.List;
import java.util.function.Supplier;

public final class JsonFormatter
        implements GraphFormatter, Colors {

    @Override
    public String format(IGraph graph) {

        StringBuilder out = new StringBuilder();

        out.append("{\n");

        appendGraph(out, graph);
        out.append(",\n");

        appendAnalysis(out, graph);
        out.append(",\n");

        appendConnectivity(out, graph);
        out.append(",\n");

        appendEdges(out, graph);

        out.append("\n}");

        return out.toString();
    }

    private void appendEdges(
            StringBuilder out,
            IGraph graph) {

        out.append("  \"edges\": [\n");

        List<Edge> edges = graph.edges();

        for (int i = 0; i < edges.size(); i++) {

            Edge edge = edges.get(i);

            out.append("    {\n");

            property(out,
                    "source",
                    edge.source(),
                    true,
                    6);

            property(out,
                    "destination",
                    edge.destination(),
                    graph.isWeighted(),
                    6);

            if (graph.isWeighted()) {

                property(out,
                        "weight",
                        edge.weight(),
                        false,
                        6);
            }

            out.append("    }");

            if (i != edges.size() - 1) {
                out.append(",");
            }

            out.append("\n");
        }

        out.append("  ]");
    }

    private void appendGraph(
            StringBuilder out,
            IGraph graph) {

        out.append("  \"graph\": {\n");

        property(out, "implementation",
                quote(graph.getClass().getSimpleName()), true);

        property(out, "vertices",
                graph.vertexCount(), true);

        property(out, "edges",
                graph.edgeCount(), true);

        property(out, "directed",
                graph.isDirected(), true);

        property(out, "weighted",
                graph.isWeighted(), false);

        out.append("  }");
    }

    private void appendAnalysis(
            StringBuilder out,
            IGraph graph) {

        GraphAnalysis analysis = graph.analysis();

        out.append("  \"analysis\": {\n");

        property(out, "density",
                safe(analysis::density), true);

        property(out, "averageDegree",
                safe(analysis::averageDegree), true);

        property(out, "maximumDegree",
                safe(analysis::maxDegree), true);

        property(out, "minimumDegree",
                safe(analysis::minDegree), true);

        property(out, "connected",
                safe(analysis::isConnected), true);

        property(out, "tree",
                safe(analysis::isTree), true);

        property(out, "forest",
                safe(analysis::isForest), true);

        property(out, "cyclic",
                safe(analysis::isCyclic), true);

        property(out, "bipartite",
                safe(analysis::isBipartite), true);

        property(out, "eulerian",
                safe(analysis::isEulerian), false);

        out.append("  }");
    }

    private void property(
            StringBuilder out,
            String key,
            Object value,
            boolean comma) {

        out.append("    ")
                .append(quote(key))
                .append(": ")
                .append(value);

        if (comma) {
            out.append(",");
        }

        out.append("\n");
    }

    private String safe(Supplier<?> supplier) {

        try {

            Object value = supplier.get();

            if (value == null) {
                return "null";
            }

            if (value instanceof Number
                    || value instanceof Boolean) {

                return value.toString();
            }

            return quote(value.toString());

        } catch (GraphException e) {

            return quote(e.getMessage());
        }
    }

    private String quote(String text) {
        return "\"" + text + "\"";
    }

    private void appendConnectivity(
            StringBuilder out,
            IGraph graph) {

        out.append("  \"connectivity\": {\n");

        appendBridges(out, graph);
        out.append(",\n");

        appendArticulationPoints(out, graph);
        out.append(",\n");

        appendStronglyConnectedComponents(out, graph);
        out.append(",\n");

        appendBiConnectedComponents(out, graph);

        out.append("\n");
        out.append("  }");
    }

    private void appendBridges(
            StringBuilder out,
            IGraph graph) {

        out.append("    \"bridges\": ");

        try {

            BridgeResult result =
                    graph.connectivity().bridges();

            out.append("[\n");

            for (int i = 0; i < result.bridges().size(); i++) {

                Edge edge = result.bridges().get(i);

                out.append("      {\n");

                property(out, "source",
                        edge.source(), true, 8);

                property(out, "destination",
                        edge.destination(), false, 8);

                out.append("      }");

                if (i != result.bridges().size() - 1) {
                    out.append(",");
                }

                out.append("\n");
            }

            out.append("    ]");

        } catch (Exception e) {

            out.append(quote(e.getMessage()));
        }
    }

    private void appendArticulationPoints(
            StringBuilder out,
            IGraph graph) {

        out.append("    \"articulationPoints\": ");

        try {

            APResult result =
                    graph.connectivity().articulationPoints();

            out.append(result.articulationPoints());

        } catch (Exception e) {

            out.append(quote(e.getMessage()));
        }
    }

    private void appendStronglyConnectedComponents(
            StringBuilder out,
            IGraph graph) {

        out.append("    \"stronglyConnectedComponents\": ");

        try {

            SCCResult result =
                    graph.connectivity().stronglyConnectedComponents();

            out.append(result.components());

        } catch (Exception e) {

            out.append(quote(e.getMessage()));
        }
    }

    private void appendBiConnectedComponents(
            StringBuilder out,
            IGraph graph) {

        out.append("    \"biconnectedComponents\": ");

        try {

            BiConnectedResult result =
                    graph.connectivity().biconnectedComponents();

            out.append("[\n");

            for (int i = 0; i < result.components().size(); i++) {

                List<Edge> component =
                        result.components().get(i);

                out.append("      [\n");

                for (int j = 0; j < component.size(); j++) {

                    Edge edge = component.get(j);

                    out.append("        {\n");

                    property(out, "source",
                            edge.source(), true, 10);

                    property(out, "destination",
                            edge.destination(), true, 10);

                    property(out, "weight",
                            edge.weight(), false, 10);

                    out.append("        }");

                    if (j != component.size() - 1) {
                        out.append(",");
                    }

                    out.append("\n");
                }

                out.append("      ]");

                if (i != result.components().size() - 1) {
                    out.append(",");
                }

                out.append("\n");
            }

            out.append("    ]");

        } catch (Exception e) {

            out.append(quote(e.getMessage()));
        }
    }


    private void property(
            StringBuilder out,
            String key,
            Object value,
            boolean comma,
            int indent) {

        out.repeat(" ", indent)
                .append(quote(key))
                .append(": ")
                .append(value);

        if (comma) {
            out.append(",");
        }

        out.append("\n");
    }
}
