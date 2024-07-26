import com.ruoyi.RuoYiApplication;
import com.ruoyi.greatzc.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = RuoYiApplication.class)
public class TestRun {

    @Autowired
    ProductMapper productMapper;

//    @Test
    public void runOne() {
        log.info(productMapper.selectList(null).toString());
    }
}
