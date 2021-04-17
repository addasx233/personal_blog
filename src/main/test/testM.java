import com.yamlapkei.service.type_info.TypeInfoService;
import com.yamlapkei.view.TypeInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testM {
    @Test
    public void testsql(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        TypeInfoService typeInfoService = (TypeInfoService) applicationContext.getBean("TypeInfoService");
        System.out.println(typeInfoService);
        System.out.println("====================");
        List<TypeInfo> list = typeInfoService.list();
        for (TypeInfo t:list){
            System.out.println(t);
        }

    }
}
