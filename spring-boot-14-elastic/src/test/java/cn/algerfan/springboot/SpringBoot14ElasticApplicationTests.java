package cn.algerfan.springboot;

import cn.algerfan.springboot.domain.Article;
import cn.algerfan.springboot.domain.Book;
import cn.algerfan.springboot.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot14ElasticApplicationTests {

    @Autowired
    JestClient jestClient;
    @Autowired
    BookRepository bookRepository;

    @Test
    public void test(){
		Book book = new Book(1, "深入理解Java虚拟机", "周志明");
        bookRepository.index(book);

        for (Book book1 : bookRepository.findByBookNameLike("虚拟机")) {
            System.out.println(book1);
        }
    }

    @Test
    public void contextLoads() {
        Article article = new Article(1, "张三", "好文章", "今天是美好的一天");
        Index build = new Index.Builder(article).index("algerfan").type("news").build();
        try {
            //执行
            jestClient.execute(build);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search() {
        //查询表达式
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"美好的一天\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //更多操作：https://github.com/searchbox-io/Jest/tree/master/jest
        //构建搜索功能
        Search build = new Search.Builder(json).addIndex("algerfan").addType("news").build();
        try {
            //执行
            SearchResult execute = jestClient.execute(build);
            System.out.println(execute.getJsonString());
            System.out.println(execute.getMaxScore());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

