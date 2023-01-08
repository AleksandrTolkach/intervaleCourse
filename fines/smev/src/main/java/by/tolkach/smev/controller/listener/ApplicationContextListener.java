package by.tolkach.smev.controller.listener;

import by.tolkach.smev.model.Fine;
import by.tolkach.smev.service.api.IFineService;
import by.tolkach.smev.service.api.IWorkerService;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class ApplicationContextListener {
    private final IFineService fineService;
    private final IWorkerService workerService;

    public ApplicationContextListener(IFineService fineService, IWorkerService workerService) {
        this.fineService = fineService;
        this.workerService = workerService;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void handle(ContextRefreshedEvent event) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
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
                        .setSts(sbSts.toString())
                        .setDate(LocalDate.ofYearDay(random.nextInt(2000, 2022), random.nextInt(0, 365)))
                        .setArticle(sbArticle.toString())
                        .build();
                this.fineService.create(fine);
            }
        }
        this.workerService.run();
    }
}
