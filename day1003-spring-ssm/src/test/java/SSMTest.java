import com.aue.config.RootConfig;
import com.aue.dao.PostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(RootConfig.class)
public class SSMTest {
    @Autowired
    PostMapper mapper;

    @Test
    public void test() {
        System.out.println(mapper.selectAll());
    }
}
