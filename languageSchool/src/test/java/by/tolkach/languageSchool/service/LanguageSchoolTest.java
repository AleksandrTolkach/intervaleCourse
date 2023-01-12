package by.tolkach.languageSchool.service;

import by.tolkach.languageSchool.model.Languages;
import by.tolkach.languageSchool.model.Level;
import by.tolkach.languageSchool.model.Student;
import by.tolkach.languageSchool.service.api.ILanguageSchool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@SpringBootTest
public class LanguageSchoolTest {
    @Autowired
    List<ILanguageSchool> schools;

    @ParameterizedTest
    @MethodSource("studentProvider")
    void inviteStudentTest(String expectedArray, Student student) {
        for (ILanguageSchool school : schools) {
            Assertions.assertEquals(expectedArray, school.inviteStudent(student));
        }
    }

    static Stream<Arguments> studentProvider() {
        return Stream.of(
                arguments("Hello!\nЧитаем книжку\nПишем историю\n",
                        new Student("Вася", Languages.ENGLISH, Level.A1)),
                arguments("Hello!\nДиалог с носителем языка\nВыполняем тест\n",
                        new Student("Ваня", Languages.ENGLISH, Level.A2)),
                arguments("Cześć\nЧитаем книжку\nПишем историю\n",
                        new Student("Петя", Languages.POLAND, Level.A1)),
                arguments("Cześć\nДиалог с носителем языка\nВыполняем тест\n",
                        new Student("Лена", Languages.POLAND, Level.A2)),
                arguments("Открываем словарь", new Student("Ася", Languages.CHINESE, Level.A1)),
                arguments("Открываем словарь", new Student("Вера", Languages.ENGLISH, Level.B2))
        );
    }
}
