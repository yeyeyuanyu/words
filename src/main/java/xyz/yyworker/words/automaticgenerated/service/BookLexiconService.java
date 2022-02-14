package xyz.yyworker.words.automaticgenerated.service;

import xyz.yyworker.words.automaticgenerated.entity.BookLexicon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (BookLexicon)表服务接口
 *
 * @author makejava
 * @since 2021-12-07 21:37:22
 */
public interface BookLexiconService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BookLexicon queryById(Integer id);

    /**
     * 分页查询
     *
     * @param bookLexicon 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<BookLexicon> queryByPage(BookLexicon bookLexicon, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param bookLexicon 实例对象
     * @return 实例对象
     */
    BookLexicon insert(BookLexicon bookLexicon);

    /**
     * 修改数据
     *
     * @param bookLexicon 实例对象
     * @return 实例对象
     */
    BookLexicon update(BookLexicon bookLexicon);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
