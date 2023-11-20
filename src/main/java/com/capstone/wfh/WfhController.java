package com.capstone.wfh;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public LocalDate get_date() {
        return LocalDate.now();
    }

    @PostMapping(path = "/submit")
    @ResponseBody
    public WfhRequest submit_request(@RequestBody @Valid WfhRequest wfhRequest) {
        return wfhService.submit(wfhRequest);
    }

    @GetMapping(path = "/requests")
    public List<WfhRequest> getAllRequests() {
        return wfhService.getAll();
    }

}
