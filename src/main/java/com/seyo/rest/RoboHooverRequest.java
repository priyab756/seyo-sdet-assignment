package com.seyo.rest;

import com.fasterxml.jackson.annotation.JsonProperty;


public class RoboHooverRequest extends RoboHooverBase {
    private final int[] roomSize;
    private final int[][] patches;
    private final String instructions;

    public RoboHooverRequest(
            @JsonProperty("roomSize") int[] roomSize,
            @JsonProperty("coords") int[] coords,
            @JsonProperty("patches") int[][] patches,
            @JsonProperty("instructions") String instructions) {
        super(coords);
        this.roomSize = roomSize;
        this.patches = patches;
        this.instructions = instructions;
    }

    public int[] getRoomSize() {
        return roomSize;
    }

    public int[][] getPatches() {
        return patches;
    }

    public String getInstructions() {
        return instructions;
    }
}
