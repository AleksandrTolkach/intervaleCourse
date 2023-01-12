package by.tolkach.languageSchool.service.teaching;

import by.tolkach.languageSchool.service.teaching.api.Teaching;
import org.springframework.stereotype.Service;

@Service
public class Speaking implements Teaching {
    private static final String SPEAK = "Диалог с носителем языка";

    @Override
    public String process() {
        System.out.println(SPEAK);
        return SPEAK;
    }
}
