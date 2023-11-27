import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld bean = (HelloWorld) applicationContext.getBean("helloworld");
        HelloWorld bean2 = (HelloWorld) applicationContext.getBean("helloworld");

        Cat beanCat = (Cat) applicationContext.getBean("cat");
        Cat beanCat2 = (Cat) applicationContext.getBean("cat");


        System.out.println(bean.getMessage());
        System.out.println(bean.getMessage() + "\n Сравнение по ссылке");

        System.out.println(bean.equals(bean2) + "\n");

        System.out.println(beanCat.getName());
        System.out.println(beanCat.getName() + "\n Сравнение по ссылке");

        System.out.println(beanCat.equals(beanCat2));
    }
}