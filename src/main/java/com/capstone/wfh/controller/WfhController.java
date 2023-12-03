package com.capstone.wfh.controller;

import com.capstone.wfh.model.WfhRequest;
import com.capstone.wfh.model.WfhRequestDTO;
import com.capstone.wfh.service.WfhService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SuppressWarnings(value = "all")
public class WfhController {

    @Autowired
    WfhService wfhService;

    public WfhController(WfhService wfhService) {
        this.wfhService = wfhService;
    }

    @PostMapping(path = "/submit")
    @ResponseBody
    public ResponseEntity<WfhRequest> submitRequest(@RequestBody @Valid WfhRequestDTO wfhRequestDTO) {
        return new ResponseEntity<>(wfhService.submit(wfhRequestDTO), HttpStatus.CREATED);
    }

}
