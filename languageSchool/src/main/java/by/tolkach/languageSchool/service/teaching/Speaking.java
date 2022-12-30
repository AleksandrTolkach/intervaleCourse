package by.tolkach.languageSchool.service.teaching;

import by.tolkach.languageSchool.service.teaching.api.BeginnersTeaching;
import org.springframework.stereotype.Service;

@Service
public class Speaking implements BeginnersTeaching {
    @Override
    public void process() {
        System.out.println("Диалог с носителем языка");
    }
}
