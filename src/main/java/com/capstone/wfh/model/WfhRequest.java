package com.capstone.wfh.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class WfhRequest {

    @Id
    private String id;

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
}
