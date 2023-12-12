package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener {

    private int numbersOfUpdates = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        System.out.println("Update nr " + (++numbersOfUpdates) + ": " + message);
        System.out.println(worldMap);
    }
}
