package agh.ics.oop.model;

public enum MoveDirection {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT;

    public Vector2d toUnitVector() {
        switch (this) {
            case FORWARD:
                return new Vector2d(0, 1);
            case BACKWARD:
                return new Vector2d(0, -1);
            case RIGHT:
                return new Vector2d(1, 0);
            case LEFT:
                return new Vector2d(-1, 0);
            default:
                throw new IllegalArgumentException("Unknown direction");
        }
    }
}
