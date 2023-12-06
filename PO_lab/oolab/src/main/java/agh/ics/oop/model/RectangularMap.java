package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap implements WorldMap {


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public boolean canMoveTo(Vector2d position){
        if(position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(width -1,height-1)) && !isOccupied(position)){
            return true;
        }
        return false;
    }


}

