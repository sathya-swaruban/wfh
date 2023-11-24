package com.capstone.wfh.controller;

import com.capstone.wfh.service.WfhService;
import com.capstone.wfh.model.WfhRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@SuppressWarnings("all")
public class WfhController {

    @Autowired
    WfhService wfhService;

    public WfhController(WfhService wfhService) {
        this.wfhService = wfhService;
    }

    @GetMapping(path = "/current_date")
    public ResponseEntity<LocalDate> get_date() {
        return new ResponseEntity<>(LocalDate.now(), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/requests")
    public ResponseEntity<List<WfhRequest>> getAllRequests() {
        return new ResponseEntity<>(wfhService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/submit")
    @ResponseBody
    public ResponseEntity<WfhRequest> submit_request(@RequestBody @Valid WfhRequest wfhRequest) {
        return new ResponseEntity<>(wfhService.submit(wfhRequest), HttpStatus.CREATED);
    }

}
