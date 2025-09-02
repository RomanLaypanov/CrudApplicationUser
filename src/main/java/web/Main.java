package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.HibernateConfig;
import web.dao.UserDao;
import web.model.User;

public class Main {
    public static void main(String[] args) {
        // Создаем Spring контекст
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateConfig.class);

        // Получаем UserDao из контекста (Spring управляет зависимостями)
        UserDao userDao = context.getBean(UserDao.class);

        User user = new User("roma", "lay", 24);
        userDao.save(user);

        // Закрываем контекст
        context.close();
    }
}
