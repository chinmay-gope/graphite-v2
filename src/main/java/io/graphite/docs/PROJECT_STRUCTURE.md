# Project Structure

Graphite follows a feature-oriented package structure.

```
graphite
│
├── algorithm
│
├── graph
│
├── builder
│
├── generator
│
├── model
│
├── result
│
├── validation
│
├── util
│
├── exception
│
├── examples
│
├── benchmark
│
└── internal
```

---

## algorithm

Contains all graph algorithms.

Grouped by category.

Example:

algorithm/
traversal/
shortestpath/
mst/
topology/
connectivity/
cycle/
property/
euler/

---

## graph

Contains graph implementations.

Graph

DirectedGraph

UndirectedGraph

IGraph

---

## builder

Responsible for graph construction.

Example:

GraphBuilder

---

## generator

Random graph generation.

Future versions will support property-based generation.

Examples:

Tree

DAG

Connected

Complete

Euler

Bipartite

---

## model

Small reusable data structures.

Examples:

Edge

GraphEdge

VertexCost

DSU

MSTNode

---

## result

Immutable outputs returned by algorithms.

Examples:

TraversalResult

ShortestPathResult

MSTResult

EulerResult

SCCResult

---

## validation

Validation utilities.

GraphValidator

EulerValidator

MSTValidator

TraversalValidator

---

## util

Stateless helper classes.

GraphUtils

GraphPrinter

GraphExporter

---

## exception

Project-specific exceptions.

Grouped by category.

---

## benchmark

Performance and stress testing.

---

## examples

Usage examples for every algorithm.

---

## internal

Implementation details hidden from users.
