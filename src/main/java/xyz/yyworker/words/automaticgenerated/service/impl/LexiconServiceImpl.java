package xyz.yyworker.words.automaticgenerated.service.impl;

import xyz.yyworker.words.automaticgenerated.entity.Lexicon;
import xyz.yyworker.words.automaticgenerated.dao.LexiconDao;
import xyz.yyworker.words.automaticgenerated.service.LexiconService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Lexicon)表服务实现类
 *
 * @author makejava
 * @since 2021-12-07 21:41:34
 */
@Service("lexiconService")
public class LexiconServiceImpl implements LexiconService {
    @Resource
    private LexiconDao lexiconDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Lexicon queryById(Integer id) {
        return this.lexiconDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param lexicon 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Lexicon> queryByPage(Lexicon lexicon, PageRequest pageRequest) {
        long total = this.lexiconDao.count(lexicon);
        return new PageImpl<>(this.lexiconDao.queryAllByLimit(lexicon, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param lexicon 实例对象
     * @return 实例对象
     */
    @Override
    public Lexicon insert(Lexicon lexicon) {
        this.lexiconDao.insert(lexicon);
        return lexicon;
    }

    /**
     * 修改数据
     *
     * @param lexicon 实例对象
     * @return 实例对象
     */
    @Override
    public Lexicon update(Lexicon lexicon) {
        this.lexiconDao.update(lexicon);
        return this.queryById(lexicon.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.lexiconDao.deleteById(id) > 0;
    }
}
