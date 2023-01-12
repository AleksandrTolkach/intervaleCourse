package by.tolkach.languageSchool.service.teaching;

import by.tolkach.languageSchool.service.teaching.api.Teaching;
import org.springframework.stereotype.Service;

@Service
public class Writing implements Teaching {
    private static final String WRITE = "Пишем историю";

    @Override
    public String process() {
        System.out.println(WRITE);
        return WRITE;
    }
}
