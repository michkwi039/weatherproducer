package pl.polsl.producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Date;

@Data
@AllArgsConstructor
public class WeatherReport {

    private Long reportID;
    private Date date;
    private String city;
    private Double temperature;
}
