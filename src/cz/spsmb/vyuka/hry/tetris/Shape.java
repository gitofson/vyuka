package cz.spsmb.vyuka.hry.tetris;

import java.util.Random;

public class Shape {

    protected enum Tetrominoe {
        NoShape, ZShape, SShape, LineShape,
        TShape, SquareShape, LShape, MirroredLShape, OwnShape
    }

    private Tetrominoe pieceShape;
    private int[][] coords;

    public Shape() {

        coords = new int[4][2];
        setShape(Tetrominoe.NoShape);
    }

    void setShape(Tetrominoe shape) {

        int[][][] coordsTable = new int[][][]{
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}},    //NoShape
                {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}}, //ZShape
                {{0, -1}, {0, 0}, {1, 0}, {1, 1}},   //SShape
                {{0, -1}, {0, 0}, {0, 1}, {0, 2}},   //LineShape
                {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},   //TShape
                {{0, 0}, {1, 0}, {0, 1}, {1, 1}},    //SquareShape
                {{-1, -1}, {0, -1}, {0, 0}, {0, 1}}, //LShape
                {{1, -1}, {0, -1}, {0, 0}, {0, 1}},  //MirroredLShape
                {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}   //OwnShape

        };

        for (int i = 0; i < 4; i++) {

            System.arraycopy(coordsTable[shape.ordinal()], 0, coords, 0, 4);
        }

        pieceShape = shape;
    }

    private void setX(int index, int x) {

        coords[index][0] = x;
    }

    private void setY(int index, int y) {

        coords[index][1] = y;
    }

    int x(int index) {

        return coords[index][0];
    }

    int y(int index) {

        return coords[index][1];
    }

    Tetrominoe getShape() {

        return pieceShape;
    }

    void setRandomShape() {

        var r = new Random();
        int x = r.nextInt(8) + 1;

        Tetrominoe[] values = Tetrominoe.values();
        setShape(values[x]);
    }

    public int minX() {

        int m = coords[0][0];

        for (int i = 0; i < 4; i++) {

            m = Math.min(m, coords[i][0]);
        }

        return m;
    }


    int minY() {

        int m = coords[0][1];

        for (int i = 0; i < 4; i++) {

            m = Math.min(m, coords[i][1]);
        }

        return m;
    }

    Shape rotateLeft() {

        if (pieceShape == Tetrominoe.SquareShape) {

            return this;
        }

        var result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; i++) {

            result.setX(i, y(i));
            result.setY(i, -x(i));
        }

        return result;
    }

    Shape rotateRight() {

        if (pieceShape == Tetrominoe.SquareShape) {

            return this;
        }

        var result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; i++) {

            result.setX(i, -y(i));
            result.setY(i, x(i));
        }

        return result;
    }
    Shape mirrorX() {

        if (pieceShape == Tetrominoe.SquareShape) {

            return this;
        }

        var result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; i++) {

            result.setX(i, x(i));
            result.setY(i, -y(i));
        }

        return result;
    }
    Shape mirrorY() {

        if (pieceShape == Tetrominoe.SquareShape) {

            return this;
        }

        var result = new Shape();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; i++) {

            result.setX(i, -x(i));
            result.setY(i, y(i));
        }

        return result;
    }
}
