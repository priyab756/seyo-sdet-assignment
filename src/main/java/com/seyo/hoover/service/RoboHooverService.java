package com.seyo.hoover.service;

import com.seyo.Utils.HooverConstants;
import com.seyo.Utils.HooverMethods;
import com.seyo.VO.HooverInputs;
import com.seyo.domain.model.Hoover;
import com.seyo.domain.model.Room;
import com.seyo.exception.HooverException;
import com.seyo.rest.RoboHooverError;
import com.seyo.rest.RoboHooverRequest;
import com.seyo.rest.RoboHooverResponse;

import java.awt.*;
import java.util.Arrays;


public class RoboHooverService implements IRoboHooverService {
    @Override
    public RoboHooverResponse runCleaning(RoboHooverRequest roboHooverReq) throws HooverException {
        if (null != roboHooverReq) {
            //validate_inputs
            HooverInputs inputsVO = new HooverMethods().validateInputs(roboHooverReq);
            //init_room
            Room room = new Room(inputsVO.getRoomSize(), inputsVO.getPatchesPosition());
            //init_hoover
            Hoover hoover = new Hoover(inputsVO.getHooverInitialPosition(), room);
            //move_hoover
            hoover.executeCommands(inputsVO.getCommands());
            //display_results
            final Point finalHooverPosition = hoover.hooverPosition();
            return new RoboHooverResponse(
                    new int[]{finalHooverPosition.x, finalHooverPosition.y},
                    room.getStainRemovalCount(),
                    null);
        }
        return new RoboHooverResponse(null,
                0,
                Arrays.asList(new RoboHooverError(
                        false,
                        HooverConstants.ERROR_INPUT_SERVICE,
                        "")));
    }
}
