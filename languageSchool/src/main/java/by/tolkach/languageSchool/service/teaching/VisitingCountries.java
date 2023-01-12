package by.tolkach.languageSchool.service.teaching;

import by.tolkach.languageSchool.service.teaching.api.Teaching;
import org.springframework.stereotype.Service;

@Service
public class VisitingCountries implements Teaching {
    private static final String VISIT = "Едем в страну происхождения языка";

    @Override
    public String process() {
        System.out.println(VISIT);
        return VISIT;
    }
}
