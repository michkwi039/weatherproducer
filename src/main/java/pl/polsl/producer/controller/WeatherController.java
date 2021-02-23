package pl.polsl.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.polsl.producer.model.WeatherReportContainer;
import pl.polsl.producer.service.WeatherReportService;
@Controller
public class WeatherController {
    private String topicName= "Reports";
    @Autowired
    private KafkaTemplate<String, WeatherReportContainer> reportsKafkaTemplate;
    @Autowired
    private WeatherReportService weatherReportService;
    @PostMapping(path = "/publish")
    public String publish() {
        ListenableFuture<SendResult<String, WeatherReportContainer>> future =
                reportsKafkaTemplate.send(topicName, new WeatherReportContainer(weatherReportService.generateReports()));
        future.addCallback(new ListenableFutureCallback<SendResult<String, WeatherReportContainer>>() {
            @Override
            public void onSuccess(SendResult<String, WeatherReportContainer> result) {
                System.out.println("Success");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable due to : " + ex.getMessage());
            }
        });
        return "error";
    }

}
