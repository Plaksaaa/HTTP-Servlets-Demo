package com.plaxa.http.flight.service;

import com.plaxa.http.flight.dao.TicketDao;
import com.plaxa.http.flight.dto.TicketDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TicketService {

    private final TicketDao ticketDao = TicketDao.getInstance();

    private TicketService() {
    }

    private static class TicketServiceHolder {
        private static final TicketService INSTANCE = new TicketService();
    }

    public List<TicketDto> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(ticket -> TicketDto.builder()
                        .id(ticket.getId())
                        .flightId(ticket.getFlightId())
                        .seatNo(ticket.getSeatNo())
                        .build()
                )
                .collect(toList());
    }

    public static TicketService getInstance() {
        return TicketServiceHolder.INSTANCE;
    }
}
