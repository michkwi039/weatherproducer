package pl.polsl.producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
@Data
@AllArgsConstructor
public class WeatherReportContainer {
    private ArrayList<WeatherReport> weatherReports;
}
