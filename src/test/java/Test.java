import com.yang.crm.settings.service.UserService;
import com.yang.crm.workbench.service.ActivityService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService bean = ioc.getBean(UserService.class);
        System.out.println(bean);
        System.out.println(1);
    }
}
