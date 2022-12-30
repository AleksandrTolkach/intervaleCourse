package by.tolkach.languageSchool.service.api;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.beans.Introspector;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InjectListBPP implements BeanPostProcessor {

    private ApplicationContext context;

    public InjectListBPP(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        List<Field> fields = Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(InjectList.class))
                .collect(Collectors.toList());
        for (Field field : fields) {
            InjectList annotation = field.getAnnotation(InjectList.class);
            List<Object> list = Arrays.stream(annotation.value())
                    .map(aClass -> Introspector.decapitalize(aClass.getSimpleName()))
                    .map(name -> context.getBean(name))
                    .collect(Collectors.toList());
            field.setAccessible(true);
            try {
                field.set(bean, list);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }
}
