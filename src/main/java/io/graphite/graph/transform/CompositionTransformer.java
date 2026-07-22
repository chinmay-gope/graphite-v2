package main.java.io.graphite.graph.transform;

import main.java.io.graphite.builder.GraphConfiguration;
import main.java.io.graphite.graph.GraphFactory;
import main.java.io.graphite.graph.IGraph;
import main.java.io.graphite.model.Edge;

public final class CompositionTransformer extends GraphTransformer {

    public IGraph transform(IGraph first,
                            IGraph second) {

        validate(first, second);

        int gVertices = first.vertexCount();
        int hVertices = second.vertexCount();

        GraphConfiguration configuration =
                configuration(first);

        configuration.setVertices(
                gVertices * hVertices
        );

        IGraph composition =
                GraphFactory.create(configuration);

        //------------------------------------------
        // Rule 1
        //------------------------------------------

        for (Edge edge : first.edges()) {

            for (int v1 = 0; v1 < hVertices; v1++) {

                for (int v2 = 0; v2 < hVertices; v2++) {

                    int source =
                            edge.source() * hVertices + v1;

                    int destination =
                            edge.destination() * hVertices + v2;

                    if (composition.isWeighted()) {

                        composition.addEdge(
                                source,
                                destination,
                                edge.weight());

                    } else {

                        composition.addEdge(
                                source,
                                destination);
                    }
                }
            }
        }

        //------------------------------------------
        // Rule 2
        //------------------------------------------

        for (int u = 0; u < gVertices; u++) {

            for (Edge edge : second.edges()) {

                int source =
                        u * hVertices + edge.source();

                int destination =
                        u * hVertices + edge.destination();

                if (composition.isWeighted()) {

                    composition.addEdge(
                            source,
                            destination,
                            edge.weight());

                } else {

                    composition.addEdge(
                            source,
                            destination);
                }
            }
        }

        return composition;
    }
}
