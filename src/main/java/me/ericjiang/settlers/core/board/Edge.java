package me.ericjiang.settlers.core.board;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Edge {

    private Coordinates coordinates;

    private String owner;

    @Getter
    @AllArgsConstructor
    public static class Coordinates {
        private int column;
        private int row;
        private Direction direction;

        public static enum Direction { W, N, E }
    }
}
