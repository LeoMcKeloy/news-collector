package lev.pyryanov.newscollector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StartupService {
    @Autowired
    private NewsLoadXmlService newsLoadXmlService;

    @Scheduled(fixedRateString = "PT024H")
    public void downloadNews() {
        newsLoadXmlService.load();
        System.out.println("Done!!!");
    }
}
