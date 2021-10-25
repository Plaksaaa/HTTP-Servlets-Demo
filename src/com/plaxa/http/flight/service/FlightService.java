package com.plaxa.http.flight.service;

import com.plaxa.http.flight.dao.FlightDao;
import com.plaxa.http.flight.dto.FlightDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightService {

    private FlightService() {
    }

    private static class FlightServiceHolder {
        private static final FlightService INSTANCE = new FlightService();
    }

    private final FlightDao flightDao = FlightDao.getInstance();

    public List<FlightDto> findAll() {
        return flightDao.findAll().stream()
                .map(flight -> FlightDto.builder()
                        .id(flight.getId())
                        .description(
                                """
                                    %s - %s - %s
                                """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatus()))
                        .build()
                )
                .collect(toList());
    }

    public static FlightService getInstance() {
        return FlightServiceHolder.INSTANCE;
    }
}
