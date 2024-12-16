package org.graphs;

import java.util.*;

class Node implements Comparable<Node> {
    public int x, y;
    public double gCost, hCost, fCost;
    public Node parent;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void calculateCosts(Node target, double gCostFromParent) {
        this.gCost = gCostFromParent;
        this.hCost = Math.abs(target.x - this.x) + Math.abs(target.y - this.y); // Манхэттенская эвристика
        this.fCost = this.gCost + this.hCost;
    }

    @Override
    public int compareTo(Node other) {
        return Double.compare(this.fCost, other.fCost);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return x == node.x && y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

public class AStar {

    private static final int[][] DIRECTIONS = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}, // 4 направления
            {-1, 1}, {1, 1}, {1, -1}, {-1, -1} // Диагонали
    };

    public static List<Node> findPath(int[][] grid, Node start, Node target) {
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Set<Node> closedSet = new HashSet<>();

        start.calculateCosts(target, 0);
        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.equals(target)) {
                return reconstructPath(current);
            }

            closedSet.add(current);

            for (int[] direction : DIRECTIONS) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                if (isValid(grid, newX, newY) && !closedSet.contains(new Node(newX, newY))) {
                    Node neighbor = new Node(newX, newY);
                    double tentativeGCost = current.gCost + distanceBetween(current, neighbor);

                    if (tentativeGCost < neighbor.gCost || !openSet.contains(neighbor)) {
                        neighbor.calculateCosts(target, tentativeGCost);
                        neighbor.parent = current;

                        if (!openSet.contains(neighbor)) {
                            openSet.add(neighbor);
                        }
                    }
                }
            }
        }

        return Collections.emptyList(); // Путь не найден
    }

    private static boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0;
    }

    private static double distanceBetween(Node a, Node b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    private static List<Node> reconstructPath(Node node) {
        List<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        Node start = new Node(0, 0);
        Node target = new Node(4, 4);

        List<Node> path = findPath(grid, start, target);

        if (!path.isEmpty()) {
            for (Node node : path) {
                System.out.println("(" + node.x + ", " + node.y + ")");
            }
        } else {
            System.out.println("Path not found.");
        }
    }
}
