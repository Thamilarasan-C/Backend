package com.thamil.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thamil.project.dto.EventInfo;
import com.thamil.project.model.Event;
import com.thamil.project.model.TicketDetails;
import com.thamil.project.repository.EventRepo;
import com.thamil.project.repository.TicketDetailsRepo;

@Service
public class EventInfoService {

  @Autowired
  private EventRepo eventRepo;

  @Autowired
  private TicketDetailsRepo ticketDetailsRepo;

  public String saveEvent(EventInfo eventInfo) {
    Event event = eventFromEventInfo(eventInfo);
    TicketDetails ticketDetails = ticketDetailsFromEventInfo(eventInfo);
    ticketDetails.setEventId(event.getEventId());
    eventRepo.save(event);
    ticketDetailsRepo.save(ticketDetails);
    return "Event Successfuly added";
  }

  public Event eventFromEventInfo(EventInfo eventInfo) {
    return Event.builder()
        .eventName(eventInfo.getEventName())
        .date(eventInfo.getDate())
        .description(eventInfo.getDescription())
        .venue(eventInfo.getVenue())
        .organizerId(eventInfo.getOrganizerId())
        .status("Pending")
        .build();
  }

  public TicketDetails ticketDetailsFromEventInfo(EventInfo eventInfo) {
    return TicketDetails.builder()
        .price(eventInfo.getTicketPrice())
        .totalTicketCount(eventInfo.getTotalTicketCount())
        .build();
  }

  public List<EventInfo> getAllEventsInfo() {
    List<EventInfo> eventsInfo = new ArrayList<EventInfo>();
    List<Event> events = eventRepo.findAll();
    for (Event event : events) {

      System.out.println(event.getEventName());
      Optional<TicketDetails> ticketsDetail = ticketDetailsRepo.findByEventId(event.getEventId());
      
      TicketDetails ticketDetails = ticketsDetail.get();

      EventInfo eventInfo = EventInfo.builder().eventName(event.getEventName()).date(event.getDate())
          .description(event.getDescription()).ticketPrice(ticketDetails.getPrice()).venue(event.getVenue()).build();

      eventsInfo.add(eventInfo);
    }
    return eventsInfo;
  }
}