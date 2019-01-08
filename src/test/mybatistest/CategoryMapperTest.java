package mybatistest;

import mybatis.Category;
import mybatis.CategoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by li on 1/15/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class CategoryMapperTest {
    @Autowired
    CategoryImpl categoryMapper;

    @Autowired
    Category category;
    @Test
    public void test(){
        System.out.println(category.getClass());
//        long t = new Date().getTime();
        category.setId("888");
        category.setName("10086");
        category.setDescription("1111111");
        System.out.println("class "+ category.getClass());
        categoryMapper.insert(category);
    }
}