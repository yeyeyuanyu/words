package xyz.yyworker.words.automaticgenerated.service.impl;

import xyz.yyworker.words.automaticgenerated.entity.BookLexicon;
import xyz.yyworker.words.automaticgenerated.dao.BookLexiconDao;
import xyz.yyworker.words.automaticgenerated.service.BookLexiconService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (BookLexicon)表服务实现类
 *
 * @author makejava
 * @since 2021-12-07 21:37:23
 */
@Service("bookLexiconService")
public class BookLexiconServiceImpl implements BookLexiconService {
    @Resource
    private BookLexiconDao bookLexiconDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BookLexicon queryById(Integer id) {
        return this.bookLexiconDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param bookLexicon 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<BookLexicon> queryByPage(BookLexicon bookLexicon, PageRequest pageRequest) {
        long total = this.bookLexiconDao.count(bookLexicon);
        return new PageImpl<>(this.bookLexiconDao.queryAllByLimit(bookLexicon, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param bookLexicon 实例对象
     * @return 实例对象
     */
    @Override
    public BookLexicon insert(BookLexicon bookLexicon) {
        this.bookLexiconDao.insert(bookLexicon);
        return bookLexicon;
    }

    /**
     * 修改数据
     *
     * @param bookLexicon 实例对象
     * @return 实例对象
     */
    @Override
    public BookLexicon update(BookLexicon bookLexicon) {
        this.bookLexiconDao.update(bookLexicon);
        return this.queryById(bookLexicon.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.bookLexiconDao.deleteById(id) > 0;
    }
}
