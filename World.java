/*
 * This class represents a world in the game.
 * A world is a collection of locations.
 * A world has a name and a story.
 * A world generates a random number of different locations.
 * @author:  JustAKuba
 */

import java.util.ArrayList;

public class World extends GameObject{

    // Variables
    private String name;
    private String story;
    private int numberOfLocations;
    private ArrayList<Location> locations = new ArrayList<Location>();

    // Constructor
    public void World(String name, String story, int numberOfLocations) {
        this.name = name;
        this.story = story;
        this.numberOfLocations = numberOfLocations;
    }

    // Getters and setters
    // Get world name
    public String getName() {
        return name;
    }
    // Get world story
    public String getStory() {
        return story;
    }
    // Get number of locations
    public int getNumberOfLocations() {
        return numberOfLocations;
    }
    // Get world locations
    public ArrayList<Location> getLocations() {
        return locations;
    }

    // Set world name
    public void setName(String name) {
        this.name = name;
    }
    // Set world story
    public void setStory(String story) {
        this.story = story;
    }
    // Set number of location
    public void setNumberOfLocations(int number) {
        this.numberOfLocations = number;
    }

    // Actions
    // Generate random locations
    public void generate() {
        for (int i = 0; i < this.numberOfLocations; i++) {
            //Location newLocation = new Location();
        }
    }
}
