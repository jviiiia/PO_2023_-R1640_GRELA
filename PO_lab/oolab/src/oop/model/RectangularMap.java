package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap {

    private final int width;
    private final int height;

    public RectangularMap(int width, int height){
        this.height = height;
        this.width = width;
    }


    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(new Vector2d(0,0), new Vector2d(width, height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && position.follows(new Vector2d(0, 0))
                && position.precedes(new Vector2d(width, height));
    }

}

