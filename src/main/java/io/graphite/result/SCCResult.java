package main.java.io.graphite.result;

import java.util.List;


public record SCCResult(List<List<Integer>> components) implements Colors {

    public SCCResult {
        components = List.copyOf(components);
    }

    @Override
    public List<List<Integer>> components() {
        return components.stream().map(List::copyOf).toList();
    }

    public int size() {
        return components.size();
    }

    public int largestComponentSize() {
        return components.stream()
                .mapToInt(List::size)
                .max()
                .orElse(0);
    }

    public int smallestComponentSize() {
        return components.stream()
                .mapToInt(List::size)
                .min()
                .orElse(0);
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
