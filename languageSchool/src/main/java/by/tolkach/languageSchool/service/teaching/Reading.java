package by.tolkach.languageSchool.service.teaching;

import by.tolkach.languageSchool.service.teaching.api.Teaching;
import org.springframework.stereotype.Service;

@Service
public class Reading implements Teaching {
    private static final String READ = "Читаем книжку";

    @Override
    public String process() {
        System.out.println(READ);
        return READ;
    }
}
