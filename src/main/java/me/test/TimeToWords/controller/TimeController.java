package me.test.TimeToWords.controller;

import me.test.TimeToWords.service.TimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class TimeController {
    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/{time}")
    public ResponseEntity<String> getTimeInWords(@PathVariable String time) {
        try {
            String timeInWords = timeService.getTimeInWords(time);
            return ResponseEntity.ok(timeInWords);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
