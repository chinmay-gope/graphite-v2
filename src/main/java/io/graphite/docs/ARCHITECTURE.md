# Graphite Architecture

## Overview

Graphite is a lightweight Java library for graph creation, graph algorithms, benchmarking, and visualization.

The project is organized around one primary goal:

> Separate graph representation, graph algorithms, graph generation, validation, and utilities into independent modules.

The library follows a feature-oriented package structure instead of a layer-based structure.

---

# High-Level Architecture

```
                    +--------------------+
                    |      Builder       |
                    +---------+----------+
                              |
                              v
                    +--------------------+
                    |      Graph         |
                    +---------+----------+
                              |
               +--------------+--------------+
               |                             |
               v                             v
      DirectedGraph                 UndirectedGraph
               |                             |
               +--------------+--------------+
                              |
                              v
                    +--------------------+
                    |    Algorithms      |
                    +---------+----------+
                              |
          +-------------------+------------------+
          |                   |                  |
          v                   v                  v
     Traversal          Shortest Path      Connectivity
          |                   |                  |
          +-------------------+------------------+
                              |
                              v
                    +--------------------+
                    |      Results       |
                    +--------------------+
```

---

# Core Components

## Graph

The graph package is the foundation of Graphite.

Responsibilities

- Store graph structure
- Store adjacency lists
- Edge insertion/removal
- Vertex validation
- Graph metadata

The graph package **does not implement algorithms**.

---

## Builder

Responsible for constructing graphs.

The builder performs:

- Validation
- Graph configuration
- Graph creation

Example

```java
Graph graph = GraphBuilder
        .undirected()
        .vertices(10)
        .weighted(true)
        .build();
```

Builders should never execute graph algorithms.

---

## Algorithms

Algorithms never modify the original graph.

They operate on the graph and return immutable result objects.

Algorithms are grouped by domain.

```
algorithm/

    traversal/

    shortestpath/

    mst/

    topology/

    connectivity/

    cycle/

    property/

    euler/
```

Every algorithm extends

```
GraphAlgorithm
```

which provides common functionality.

---

## Results

Algorithms never print.

Algorithms never log.

Algorithms return immutable results.

Examples

```
TraversalResult

ShortestPathResult

MSTResult

EulerResult

SCCResult
```

The user decides how results are displayed.

---

## Validation

Validation is separated from algorithms.

Example

```
GraphValidator

EulerValidator

MSTValidator

TraversalValidator
```

Validators should never perform graph algorithms.

Validators verify correctness only.

---

## Generator

Responsible for graph generation.

Future versions use a property-based design.

Example

```java
RandomGraphGenerator
        .undirected()
        .vertices(100)
        .property(TREE)
        .property(CONNECTED)
        .build();
```

Generation logic should remain independent of algorithms.

---

## Utilities

Utilities contain reusable helper methods.

Examples

```
GraphUtils

GraphPrinter

GraphExporter

GraphImporter
```

Utilities should be stateless.

---

## Benchmark

Benchmark classes measure

- execution time
- correctness
- scalability

Benchmarks never implement algorithms.

---

## Examples

Examples demonstrate API usage.

Every algorithm should have at least one example.

---

# Dependency Rules

Graphite follows strict dependency rules.

```
Builder
    ↓
Graph
    ↓
Algorithms
    ↓
Results
```

Utilities may be used anywhere.

Validators may be used anywhere.

Examples depend on everything.

Benchmarks depend on everything.

The reverse is never allowed.

---

# Design Principles

## Single Responsibility

Every package has exactly one purpose.

Example

```
algorithm

Only algorithms.
```

Not

```
algorithm

printer

generator

validation
```

---

## Open / Closed

Adding a new algorithm should require:

- one new class

possibly

- one result object

Nothing else.

No existing algorithms should require modification.

---

## Immutability

Result objects are immutable.

Graphs are mutable unless explicitly created as immutable.

---

## Composition over Inheritance

Inheritance is limited.

```
Graph

↑

DirectedGraph

UndirectedGraph
```

Everything else should prefer composition.

---

## Stateless Algorithms

Algorithms should not store state between executions.

Every invocation should be independent.

---

# Public API

Users primarily interact with

```
GraphBuilder

RandomGraphGenerator

Algorithms

Result Objects
```

Everything else is implementation detail.

---

# Internal Package

Classes inside

```
internal/
```

are **not** considered public API.

They may change without notice.

Examples

```
VertexCost

MSTNode

Timer

HeapNode
```

---

# Future Expansion

The architecture is designed to support

- Maximum Flow
- Matching
- A*
- Johnson
- Graph Coloring
- Planarity
- Graph Visualization
- Serialization
- Parallel Algorithms

without reorganizing the package structure.

---

# Guiding Philosophy

Graphite should remain

- lightweight
- dependency-free
- readable
- modular
- educational
- production-quality

Every new feature should improve the library without increasing unnecessary complexity.
