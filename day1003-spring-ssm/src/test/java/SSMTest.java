import com.aue.config.RootConfig;
import com.aue.dao.PostMapper;
import com.aue.pojo.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;


@SpringJUnitConfig(RootConfig.class)
public class SSMTest {
    @Autowired
    PostMapper mapper;

    @Test
    public void test() {
        Post post = new Post();
        post.setTitle("数据");
        post.setContent("j");
        List<Post> postList = mapper.selectByConditionWithDynamicSql(post);
        Assertions.assertTrue(postList.size() > 0);
    }
}
