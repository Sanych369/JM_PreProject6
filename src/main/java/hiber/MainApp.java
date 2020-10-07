package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User(
                "User1", "LastName1", "user1@mail.ru",
                new Car("BMW", 123)));
        userService.add(new User(
                "User2", "LastName2", "user2@mail.ru",
                new Car("Audi", 80)));
        userService.add(new User(
                "User3", "LastName3", "user3@mail.ru",
                new Car("Honda", 111)));
        userService.add(new User(
                "User4", "LastName4", "user4@mail.ru",
                new Car("Opel", 50)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getName());
            System.out.println("Car series = " + user.getCar().getSeries());
            System.out.println();
        }

        System.out.println(userService.getUserByCar(new Car("Honda", 111)).toString());

        context.close();
    }
}
