package me.ericjiang.settlers.data.board;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Collection;
import me.ericjiang.settlers.core.board.Edge;
import me.ericjiang.settlers.core.board.Intersection;
import me.ericjiang.settlers.core.board.Tile;

public class BoardDaoInMemory implements BoardDao {

    // R = gameId, C = V.Coordinates
    private Table<String, Tile.Coordinates, Tile> tiles;
    private Table<String, Edge.Coordinates, Edge> edges;
    private Table<String, Intersection.Coordinates, Intersection> intersections;

    public BoardDaoInMemory() {
        tiles = HashBasedTable.create();
        edges = HashBasedTable.create();
        intersections = HashBasedTable.create();
    }

    @Override
    public Tile getTile(String gameId, Tile.Coordinates coordinates) {
        return tiles.get(gameId, coordinates);
    }

    @Override
    public Collection<Tile> getTiles(String gameId) {
        return tiles.row(gameId).values();
    }

    @Override
    public void putTile(String gameId, Tile.Coordinates coordinates, Tile tile) {
        tiles.put(gameId, coordinates, tile);
    }

    @Override
    public Edge getEdge(String gameId, Edge.Coordinates coordinates) {
        return edges.get(gameId, coordinates);
    }

    @Override
    public Collection<Edge> getEdges(String gameId) {
        return edges.row(gameId).values();
    }

    @Override
    public void putEdge(String gameId, Edge.Coordinates coordinates, Edge edge) {
        edges.put(gameId, coordinates, edge);
    }

    @Override
    public Intersection getIntersection(String gameId, Intersection.Coordinates coordinates) {
        return intersections.get(gameId, coordinates);
    }

    @Override
    public Collection<Intersection> getIntersections(String gameId) {
        return intersections.row(gameId).values();
    }

    @Override
    public void putIntersection(String gameId, Intersection.Coordinates coordinates, Intersection intersection) {
        intersections.put(gameId, coordinates, intersection);
    }

}
