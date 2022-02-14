package xyz.yyworker.words.automaticgenerated.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.yyworker.words.automaticgenerated.entity.BookLexicon;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (BookLexicon)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-07 21:37:20
 */
@Mapper
public interface BookLexiconDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BookLexicon queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param bookLexicon 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<BookLexicon> queryAllByLimit(BookLexicon bookLexicon, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param bookLexicon 查询条件
     * @return 总行数
     */
    long count(BookLexicon bookLexicon);

    /**
     * 新增数据
     *
     * @param bookLexicon 实例对象
     * @return 影响行数
     */
    int insert(BookLexicon bookLexicon);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BookLexicon> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BookLexicon> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BookLexicon> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BookLexicon> entities);

    /**
     * 修改数据
     *
     * @param bookLexicon 实例对象
     * @return 影响行数
     */
    int update(BookLexicon bookLexicon);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    List<BookLexicon> queryAllByBookName(String name);

    int updateByBooKNameAndWord(BookLexicon bookLexicon);
}

