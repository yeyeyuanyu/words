package xyz.yyworker.words.automaticgenerated.service;

import xyz.yyworker.words.automaticgenerated.entity.Lexicon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Lexicon)表服务接口
 *
 * @author makejava
 * @since 2021-12-07 21:41:34
 */
public interface LexiconService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Lexicon queryById(Integer id);

    /**
     * 分页查询
     *
     * @param lexicon 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Lexicon> queryByPage(Lexicon lexicon, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param lexicon 实例对象
     * @return 实例对象
     */
    Lexicon insert(Lexicon lexicon);

    /**
     * 修改数据
     *
     * @param lexicon 实例对象
     * @return 实例对象
     */
    Lexicon update(Lexicon lexicon);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
