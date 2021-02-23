package pl.polsl.producer.service;

import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;
import pl.polsl.producer.model.WeatherReport;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
@Service
public class WeatherReportService {
    private Long reportID= 0l;
    private String []cities={"Krakow",
            "Bielsko-Biala",
            "Warszawa",
            "Poznan",
            "Katowice",
            "Gliwice"};


    public ArrayList<WeatherReport> generateReports(){
        ArrayList<WeatherReport> weatherReports=new ArrayList<>();
        Date currentDate=new Date();
        Random random = new Random();
        for (int i=0;i<cities.length;i++){
            Double temperature = random.nextDouble();
            temperature*=100/2;
            temperature=DoubleRounder.round(temperature,1);
            reportID++;
            WeatherReport current=new WeatherReport(reportID,currentDate,cities[i],temperature);
            weatherReports.add(current);
        }
        return weatherReports;
    }

    public String[] getCities(){
        return cities;
    }
}
