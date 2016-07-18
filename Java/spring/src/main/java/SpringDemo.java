import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by tianx on 2016/4/22.
 */
public class SpringDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        People people = (People) context.getBean("People");

        people.setName("天信");

        System.out.println(people.getName());

    }
}
