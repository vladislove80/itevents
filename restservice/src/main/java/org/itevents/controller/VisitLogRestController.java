package org.itevents.controller;

import org.itevents.mapper.UserMapper;
import org.itevents.model.Event;
import org.itevents.model.User;
import org.itevents.service.EventService;
import org.itevents.service.VisitLogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;


@RestController
public class VisitLogRestController {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EventService eventService = context.getBean("eventService", EventService.class);
    private VisitLogService visitLogService = context.getBean("visitLogService", VisitLogService.class);
    private UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

    @RequestMapping(value = "/events/{event_id}/users/{user_id}")
    public ResponseEntity getRegLink(@PathVariable("event_id") int eventId, @PathVariable("user_id") int userId) {
        Event event = eventService.getEvent(eventId);
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.setLocation(new URL(event.getRegLink()).toURI());
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        User user = userMapper.getUser(userId);
        visitLogService.addVisitLog(event, user);
        return new ResponseEntity(headers, HttpStatus.FOUND);
    }
}