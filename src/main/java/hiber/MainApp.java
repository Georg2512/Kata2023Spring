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

      userService.add(new User("User1", "Lastname1", "user1@mail.ru",new Car("test1",2)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",new Car("test2",3)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",new Car("test3",4)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",new Car("test4",5)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar().getId());
         System.out.println();
      }

      System.out.println("Получения пользователя по модели и серии машины");
      String model = "test3";
      int series = 4;
      System.out.println("" +
              "Id = "+ userService.getUserByCar(model,series).getId() + "\n" +
              "First Name = " + userService.getUserByCar(model,series).getFirstName() + "\n" +
              "Last Name = " + userService.getUserByCar(model,series).getLastName() + "\n" +
              "Email = " + userService.getUserByCar(model,series).getEmail() + "\n" +
              "Car = " + userService.getUserByCar(model,series).getCar().getId());

      context.close();
   }
}
