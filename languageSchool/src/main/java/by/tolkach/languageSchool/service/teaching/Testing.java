package by.tolkach.languageSchool.service.teaching;

import by.tolkach.languageSchool.service.teaching.api.Teaching;
import org.springframework.stereotype.Service;

@Service
public class Testing implements Teaching {
    private static final String TEST = "Выполняем тест";

    @Override
    public String process() {
        System.out.println(TEST);
        return TEST;
    }
}
