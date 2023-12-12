package agh.ics.oop.model;

public class Grass  implements WorldElement {
    Vector2d vector2d;

    public Grass(Vector2d vector2d) {
        this.vector2d = vector2d;
    }

    public Vector2d getPosition(){
        return vector2d;
    }

    @Override
    public String toString() {
        return "*";
    }
}
