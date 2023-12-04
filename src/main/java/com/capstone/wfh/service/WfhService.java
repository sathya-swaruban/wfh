package com.capstone.wfh.service;

import com.capstone.wfh.exception.WfhException;
import com.capstone.wfh.model.WfhRequest;
import com.capstone.wfh.dto.WfhRequestDTO;
import com.capstone.wfh.repository.WfhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

@Service
public class WfhService {

    @Autowired
    WfhRepository wfhRepository;

    public WfhService(WfhRepository wfhRepository) {
        this.wfhRepository = wfhRepository;
    }

    private WfhRequest validateDateAndTime(WfhRequestDTO wfhRequestDTO) {
        String fromDate = wfhRequestDTO.getFromDate();
        String toDate = wfhRequestDTO.getToDate();
        String fromTime = wfhRequestDTO.getFromTime();
        String toTime = wfhRequestDTO.getToTime();

        if (!fromDate.equals(toDate)) {
            throw new RuntimeException(WfhException.DIFFERENTDATES);
        } else if (LocalDate.parse(fromDate).isAfter(LocalDate.now())) {
            throw new RuntimeException(WfhException.FUTUREDATES);
        } else if (LocalDate.parse(fromDate).get(ChronoField.DAY_OF_WEEK) >= 6) {
            throw new RuntimeException(WfhException.WEEKENDDATES);
        } else if (LocalTime.parse(fromTime).getHour() >= LocalTime.parse(toTime).getHour()) {
            throw new RuntimeException(WfhException.INVALIDTIMES);
        } else if (fromDate.equals(LocalDate.now().toString()) &&
                LocalTime.parse(toTime).getHour() > LocalTime.now().getHour()) {
            throw new RuntimeException(WfhException.INVALIDTOHOUR);
        } else if (fromDate.equals(LocalDate.now().toString()) &&
                LocalTime.parse(toTime).getMinute() >= LocalTime.now().getMinute()) {
            throw new RuntimeException(WfhException.INVALIDTOMINUTE);
        } else if (!wfhRepository.findByFromDate(fromDate).isEmpty()) {
            throw new RuntimeException(WfhException.REQUESTEXISTS);
        }
        return new WfhRequest(fromDate, toDate, fromTime, toTime);
    }

    public WfhRequest submit(WfhRequestDTO wfhRequestDTO) {
        WfhRequest wfhRequest = validateDateAndTime(wfhRequestDTO);
        return wfhRepository.save(wfhRequest);
    }

}
