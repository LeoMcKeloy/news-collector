package lev.pyryanov.newscollector.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.stereotype.Service;

@Service
public class NewsLoadXmlService {
    private final String FILE_URL_VEDOMOSTI = "https://www.vedomosti.ru/rss/news";
    private final String FILE_URL_LENTA = "https://lenta.ru/rss/";
    private final String FILE_URL_TASS = "https://tass.ru/rss/v2.xml";
    private final String FILE_NAME_VEDOMOSTI = "/opt/workspace/data/vedomosti.xml";
    private final String FILE_NAME_LENTA = "/opt/workspace/data/lenta.xml";
    private final String FILE_NAME_TASS = "/opt/workspace/data/tass.xml";

    public void load() {
        loadFile(FILE_URL_VEDOMOSTI, FILE_NAME_VEDOMOSTI);
        loadFile(FILE_URL_LENTA, FILE_NAME_LENTA);
        loadFile(FILE_URL_TASS, FILE_NAME_TASS);
    }

    public void loadFile(String url, String fileName) {

        try (InputStream in = new URL(url).openStream()) {
            Files.copy(in, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            System.out.println("Не удалось скачать!!!");
        }
    }
}
