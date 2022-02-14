package xyz.yyworker.words.automaticgenerated.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.yyworker.words.automaticgenerated.entity.Lexicon;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Lexicon)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-07 21:41:32
 */
@Mapper
public interface LexiconDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Lexicon queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param lexicon 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Lexicon> queryAllByLimit(Lexicon lexicon, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param lexicon 查询条件
     * @return 总行数
     */
    long count(Lexicon lexicon);

    /**
     * 新增数据
     *
     * @param lexicon 实例对象
     * @return 影响行数
     */
    int insert(Lexicon lexicon);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Lexicon> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Lexicon> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Lexicon> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Lexicon> entities);

    /**
     * 修改数据
     *
     * @param lexicon 实例对象
     * @return 影响行数
     */
    int update(Lexicon lexicon);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

