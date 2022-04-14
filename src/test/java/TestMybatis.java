import com.px.dao.ClassificationDao;
import com.px.po.Classification;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.security.PublicKey;
import java.util.List;

public class TestMybatis {
    private ClassificationDao classificationDao;

    @Before
    public void init() throws IOException{
        classificationDao = new ClassificationDao("mybatis-config.xml");
    }

    @Test
    public void findAllTest(){
        List<Classification> all = classificationDao.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void insertTest(){
        Classification classification = new Classification();
        classification.setClassCode("99.99.99");
        classification.setPropertyName("测试物料属性");
        int i = classificationDao.addRecord(classification);
        System.out.println("写入成功，新增记录数："+i);
    }
}
