package com.thamil.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.thamil.project.dto.AttendeeDto;
import com.thamil.project.dto.TicketRegistration;
import com.thamil.project.dto.TicketToken;
import com.thamil.project.exception.CustomException;
import com.thamil.project.model.Attendee;
import com.thamil.project.model.Registration;
import com.thamil.project.model.Ticket;
import com.thamil.project.model.TicketDetails;
import com.thamil.project.repository.AttendeeRepo;
import com.thamil.project.repository.TicketDetailsRepo;

public class TicketRegistrationService {

  @Autowired
  private AttendeeRepo attendeeRepo;

  @Autowired
  private RegistrationService registrationService;

  @Autowired
  private TicketDetailsRepo ticketDetailsRepo;

  public List<TicketToken> saveTicketRegistration(TicketRegistration ticketRegistration) throws CustomException {

    List<TicketToken> ticketTokens = new ArrayList<TicketToken>();

    Registration registration = Registration.builder()
        .userId(ticketRegistration.getUserId())
        .eventId(ticketRegistration.getEventId())
        .ticketCount(ticketRegistration.getAttendees().size())
        .build();
    Long regId = registrationService.saveRegistration(registration).getRegistrationId();

    for (AttendeeDto currentAttendeeDto : ticketRegistration.getAttendees()) {
      Long attendeeId;
      if (!attendeeRepo.existsByEmailId(currentAttendeeDto.getEmailId()))
        attendeeId = attendeeRepo.save(attendeeFromDto(currentAttendeeDto)).getAttendeeId();
      else{
        attendeeId = attendeeRepo.findByEmailId(currentAttendeeDto.getEmailId()).get().getAttendeeId();
      }
      Optional<TicketDetails> ticketDetails= ticketDetailsRepo.findByEventId(ticketRegistration.getEventId());
      Long ticketDetailsId = ticketDetails.get().getTicketDetailsId();
      Ticket ticket = Ticket.builder()
        .registrationId(regId)
        .attendeeId(attendeeId)
        .ticketDetailsId(ticketDetailsId)
        .isAttended(false)
        .build();
        //generate ticket tokens
        //ticketTokens.add(new TicketToken(attendeeName,generatedToken))
    }
    return ticketTokens;
  }

  public Attendee attendeeFromDto(AttendeeDto attendeeDto) {
    return Attendee.builder()
        .emailId(attendeeDto.getEmailId())
        .name(attendeeDto.getName())
        .gender(attendeeDto.getGender())
        .dob(attendeeDto.getDob())
        .build();
  }
}
