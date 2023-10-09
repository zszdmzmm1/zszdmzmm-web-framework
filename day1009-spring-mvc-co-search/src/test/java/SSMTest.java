import com.aue.config.RootConfig;
import com.aue.dao.PostMapper;
import com.aue.pojo.Post;
import com.aue.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;


@SpringJUnitConfig(RootConfig.class)
public class SSMTest {
    @Autowired
    PostMapper mapper;

    @Test
    @Disabled
    public void test() {
        Post post = new Post();
        post.setTitle("数据");
        post.setContent("j");
        List<Post> postList = mapper.selectByConditionWithDynamicSql(post);
        Assertions.assertTrue(postList.size() > 0);
    }

    @Test
    @Disabled
    public void coSearchTest() {
        List<Post> postList = mapper.selectPostsAndUser();
        System.out.println(postList);
    }

    @Test
    @Disabled
    public void coSearchTest2() {
        List<User> userList = mapper.selectUserAndPosts();
        System.out.println(userList);
    }
}
