package io.graphite.result;

import java.util.List;

import static io.graphite.result.Colors.*;

public record SCCResult(List<List<Integer>> components) {

    public SCCResult {
        components = List.copyOf(components);
    }

    @Override
    public List<List<Integer>> components() {
        return components.stream().map(List::copyOf).toList();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < components.size(); i++) {
            builder.append(CYAN)
                    .append("Component ")
                    .append(i + 1)
                    .append(": ")
                    .append(RESET)
                    .append(MAGENTA)
                    .append(components.get(i))
                    .append(RESET)
                    .append('\n');
        }
        return builder.toString();
    }
}
