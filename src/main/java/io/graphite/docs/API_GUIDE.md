# Graphite API Guide

## Philosophy

Graphite aims to provide a clean, fluent and intuitive API for creating graphs
and executing graph algorithms.

The API should read naturally and minimize boilerplate while remaining explicit.

---

# Creating Graphs

## Undirected Graph

```java
Graph graph = GraphBuilder
        .undirected()
        .vertices(5)
        .build();
```

---

## Directed Graph

```java
Graph graph = GraphBuilder
        .directed()
        .vertices(5)
        .build();
```

---

## Weighted Graph

```java
Graph graph = GraphBuilder
        .undirected()
        .vertices(10)
        .weighted()
        .build();
```

---

## Custom Weight Range

```java
Graph graph = GraphBuilder
        .undirected()
        .vertices(100)
        .weighted()
        .weightRange(5,50)
        .build();
```

---

# Adding Edges

```java
graph.addEdge(0,1);

graph.addEdge(1,2);

graph.addEdge(2,3);
```

Weighted

```java
graph.addEdge(0,1,7);
```

---

# Graph Generation

Simple

```java
Graph graph = RandomGraphGenerator
        .undirected()
        .vertices(100)
        .edges(250)
        .build();
```

---

Connected

```java
.property(CONNECTED)
```

---

Tree

```java
.property(TREE)
```

---

Bipartite

```java
.property(BIPARTITE)
```

---

DAG

```java
.property(DAG)
```

---

Euler Circuit

```java
.property(EULER_CIRCUIT)
```

---

Euler Path

```java
.property(EULER_PATH)
```

---

Complete Graph

```java
.property(COMPLETE)
```

---

Sparse Graph

```java
.property(SPARSE)
```

---

Dense Graph

```java
.property(DENSE)
```

---

# Traversal

Breadth First Search

```java
TraversalResult result =
        new BFS()
                .traverse(graph,0);
```

---

Depth First Search

```java
TraversalResult result =
        new DFS()
                .traverse(graph,0);
```

---

# Shortest Path

Dijkstra

```java
ShortestPathResult result =
        new Dijkstra()
                .shortestPath(graph,0);
```

---

Bellman Ford

```java
ShortestPathResult result =
        new BellmanFord()
                .shortestPath(graph,0);
```

---

Floyd Warshall

```java
FloydWarshallResult result =
        new FloydWarshall()
                .shortestPath(graph);
```

---

# Minimum Spanning Tree

Prim

```java
MSTResult result =
        new Prim()
                .findMST(graph,0);
```

---

Kruskal

```java
MSTResult result =
        new Kruskal()
                .findMST(graph);
```

---

# Topological Sorting

```java
new DFSTopologicalSort()

new KahnTopologicalSort()
```

---

# Connectivity

Strongly Connected Components

```java
new Kosaraju()
```

---

Bridges

```java
new BridgeFinder()
```

---

Articulation Points

```java
new ArticulationPointFinder()
```

---

Biconnected Components

```java
new BiconnectedComponents()
```

---

# Euler

Euler Path

```java
new Hierholzer()
        .findEulerPath(graph);
```

---

Euler Circuit

```java
new Hierholzer()
        .findEulerCircuit(graph);
```

---

# Cycle Detection

Directed

```java
new DirectedCycleDetector()
```

---

Undirected

```java
new UndirectedCycleDetector()
```

---

# Graph Properties

```java
new BipartiteChecker()
```

---

# Results

Every algorithm returns an immutable result object.

Example

```java
TraversalResult

ShortestPathResult

MSTResult

EulerResult

SCCResult
```

Result objects never expose mutable internal collections.

---

# Printing

Graph

```java
GraphPrinter.print(graph);
```

Result

```java
System.out.println(result);
```

---

# Benchmark

Every algorithm should have a benchmark.

Example

```java
StressRunner.run(
    "Prim",
    config,
    GraphFactory::mstGraph,
    prim::findMST
);
```

---

# Examples

Every algorithm should provide at least one runnable example.

```
examples/

    traversal/

    shortestpath/

    mst/

    topology/

    connectivity/

    euler/
```

---

# Best Practices

✔ Prefer GraphBuilder over constructors.

✔ Prefer immutable result objects.

✔ Never modify the graph inside an algorithm.

✔ Validate graph preconditions before execution.

✔ Keep algorithms stateless.

✔ Use GraphPrinter instead of embedding print logic.

✔ Keep helper methods inside GraphUtils.

---

# API Stability

Classes inside

```
internal/
```

are not public API.

Only the following packages are guaranteed stable.

```
graph/

builder/

algorithm/

generator/

result/

validation/

util/
```

Applications should depend only on these packages.
