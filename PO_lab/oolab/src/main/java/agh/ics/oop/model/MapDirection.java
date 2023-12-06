package agh.ics.oop.model;

public enum MapDirection{
    NORTH,
    EAST,
    SOUTH,
    WEST;

    @Override
    public String toString(){
        return switch (this) {
            case NORTH -> "Północ";
            case EAST -> "Wschód";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
        };
    }

    public String toSymbol() {
        return switch (this) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public MapDirection next(){
        int nextDirectionIndex = (this.ordinal() + 1) % values().length;
        return values()[nextDirectionIndex];
    }

    public MapDirection previous() {
        int previousDirectionIndex = (this.ordinal() - 1 + values().length) % values().length;
        return values()[previousDirectionIndex];
    }

    public Vector2d toUnitVector(){
        return switch (this) {
            case NORTH -> new Vector2d(0, 1);
            case EAST -> new Vector2d(1, 0);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
        };
    }
}
