package com.seyo.VO;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class HooverInputs {
    private final Point roomSize;
    private final Point hooverInitialPosition;
    private final Set<Point> patchesPosition;
    private final List<Character> commands;

    public HooverInputs(Point roomSize,
                        Point hooverInitialPosition,
                        Set<Point> patchesPosition,
                        List<Character> commands) {
        this.roomSize = roomSize;
        this.hooverInitialPosition = hooverInitialPosition;
        this.patchesPosition = patchesPosition;
        this.commands = commands;
    }

    public Point getRoomSize() {
        return roomSize;
    }

    public Point getHooverInitialPosition() {
        return hooverInitialPosition;
    }

    public Set<Point> getPatchesPosition() {
        return patchesPosition;
    }

    public List<Character> getCommands() {
        return commands;
    }

}

