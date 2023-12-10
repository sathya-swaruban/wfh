package com.capstone.wfh;

import com.capstone.wfh.dto.WfhRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@SuppressWarnings(value = "all")
public class WfhRequestJSONTest {

    @Autowired
    private JacksonTester<WfhRequestDTO> json;

    @Test
    void wfhRequestSerializationTest() throws IOException {
        WfhRequestDTO wfhRequestDTO = new WfhRequestDTO(
                "2023-12-01",
                "2023-12-01",
                "08:00",
                "17:15"
        );
        String expected = """
                {
                    "fromDate": "2023-12-01",
                    "toDate": "2023-12-01",
                    "fromTime": "08:00",
                    "toTime": "17:15"
                }
                """;
        assertThat(json.write(wfhRequestDTO)).isStrictlyEqualToJson(expected);
        assertThat(json.write(wfhRequestDTO)).hasJsonPathStringValue("@.fromDate");
        assertThat(json.write(wfhRequestDTO)).extractingJsonPathStringValue("@.fromDate")
                .asString().isEqualTo("2023-12-01");
        assertThat(json.write(wfhRequestDTO)).hasJsonPathStringValue("@.toDate");
        assertThat(json.write(wfhRequestDTO)).extractingJsonPathStringValue("@.toDate")
                .asString().isEqualTo("2023-12-01");
        assertThat(json.write(wfhRequestDTO)).hasJsonPathStringValue("@.fromTime");
        assertThat(json.write(wfhRequestDTO)).extractingJsonPathStringValue("@.fromTime")
                .asString().isEqualTo("08:00");
        assertThat(json.write(wfhRequestDTO)).hasJsonPathStringValue("@.toTime");
        assertThat(json.write(wfhRequestDTO)).extractingJsonPathStringValue("@.toTime")
                .asString().isEqualTo("17:15");
    }

    @Test
    void wfhRequestDeserializationTest() throws IOException {
        String expected = """
                {
                    "fromDate": "2023-12-01",
                    "toDate": "2023-12-01",
                    "fromTime": "08:00",
                    "toTime": "17:15"
                }
                """;
        assertThat(json.parse(expected).getObject())
                .isEqualTo(new WfhRequestDTO(
                        "2023-12-01",
                        "2023-12-01",
                        "08:00",
                        "17:15"
                ));
        assertThat(json.parseObject(expected).getFromDate()).isEqualTo("2023-12-01");
        assertThat(json.parseObject(expected).getToDate()).isEqualTo("2023-12-01");
        assertThat(json.parseObject(expected).getFromTime()).isEqualTo("08:00");
        assertThat(json.parseObject(expected).getToTime()).isEqualTo("17:15");
    }

}
