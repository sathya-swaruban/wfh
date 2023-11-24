package com.capstone.wfh.service;

import com.capstone.wfh.exception.DifferentDatesException;
import com.capstone.wfh.exception.InvalidTimeRangeException;
import com.capstone.wfh.exception.RequestExistsException;
import com.capstone.wfh.exception.WeekendException;
import com.capstone.wfh.model.WfhRequest;
import com.capstone.wfh.repository.WfhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.List;

@Service
public class WfhService {

    @Autowired
    WfhRepository wfhRepository;

    public WfhService(WfhRepository wfhRepository) {
        this.wfhRepository = wfhRepository;
    }

    private void validateDateAndTime(WfhRequest wfhRequest) {
        String fromDate = wfhRequest.getFromDate();
        String toDate = wfhRequest.getToDate();
        String fromTime = wfhRequest.getFromTime();
        String toTime = wfhRequest.getToTime();

        if (!fromDate.equals(toDate)) {
            throw new DifferentDatesException("ERROR: Provided from-date and to-date are different.");
        } else if (LocalDate.parse(fromDate).get(ChronoField.DAY_OF_WEEK) >= 6) {
            throw new WeekendException("ERROR: Provided from-date and to-date must not be a weekend.");
        } else if (LocalTime.parse(fromTime).getHour() > LocalTime.parse(toTime).getHour()) {
            throw new InvalidTimeRangeException("ERROR: Provided from-time should be less than to-time.");
        } else if (!wfhRepository.findByFromDate(fromDate).isEmpty()) {
            throw new RequestExistsException("ERROR: WFH Request already exists for the provided date.");
        }
    }

    public WfhRequest submit(WfhRequest wfhRequest) {
        validateDateAndTime(wfhRequest);
        return wfhRepository.save(wfhRequest);
    }

    public List<WfhRequest> getAll() {
        return wfhRepository.findAll();
    }

}
