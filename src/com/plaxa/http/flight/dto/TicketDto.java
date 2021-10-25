package com.plaxa.http.flight.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketDto {

    Long id;
    Long flightId;
    String seatNo;
}
