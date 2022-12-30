package by.tolkach.languageSchool.model;

public class Student {
    private String name;
    private Languages language;
    private Level level;

    public Student(String name, Languages language, Level level) {
        this.name = name;
        this.language = language;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
