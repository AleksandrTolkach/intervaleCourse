package by.tolkach.smev.service.api;

import by.tolkach.smev.model.Fine;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class DBFiller {

    private final IFineService fineService;

    public DBFiller(IFineService fineService) {
        this.fineService = fineService;
    }

    @PostConstruct
    public void fillDb() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        List<Fine> fines = new ArrayList<>();
        if (this.fineService.count() == 0) {
            for (int i = 0; i < 20; i++) {
                StringBuilder sbSts = new StringBuilder();
                StringBuilder sbArticle = new StringBuilder();
                for (int j = 0; j < 7; j++) {
                    sbSts.append((char) random.nextInt(65, 90));
                }
                for (int j = 0; j < 4; j++) {
                    sbArticle.append(random.nextInt(0, 9));
                }
                Fine fine = Fine.FineBuilder.createBuilder()
                        .setIncomeSum(random.nextInt(0, 1000))
                        .setPaymentSum(random.nextInt(0, 1000))
                        .setDecreeNumber(random.nextInt(0, 100))
                        .setVehicleId(sbSts.toString())
                        .setDate(LocalDate.ofYearDay(random.nextInt(2000, 2022),
                                random.nextInt(1, 365)))
                        .setArticle(sbArticle.toString())
                        .build();
                fines.add(fine);
            }
        }
        this.fineService.createList(fines);
    }
}
