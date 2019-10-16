package cn.algerfan.springboot.repository;

import cn.algerfan.springboot.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author algerfan
 * @date 2019/10/15 17:26
 */
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

    List<Book> findByBookNameLike(String bookName);

}
