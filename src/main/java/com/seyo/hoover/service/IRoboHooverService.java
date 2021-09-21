package com.seyo.hoover.service;

import com.seyo.exception.HooverException;
import com.seyo.rest.RoboHooverRequest;
import com.seyo.rest.RoboHooverResponse;

public interface IRoboHooverService {
    public RoboHooverResponse runCleaning(RoboHooverRequest roboHooverReq) throws HooverException;
}
