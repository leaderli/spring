package mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by li on 1/17/18.
 */
@Service
public class CategoryImpl implements ICategory {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void insert(Category category) {
        categoryMapper.insert(category);
    }
}
