package com.capstone.wfh.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class WfhRequestDTO {

    @NotEmpty
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String fromDate;

    @NotEmpty
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String toDate;

    @NotEmpty
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
    private String fromTime;

    @NotEmpty
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
    private String toTime;

    public WfhRequestDTO(String fromDate, String toDate, String fromTime, String toTime) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

}
