package xyz.yyworker.words.automaticgenerated.controller;

import xyz.yyworker.words.automaticgenerated.entity.BookLexicon;
import xyz.yyworker.words.automaticgenerated.service.BookLexiconService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BookLexicon)表控制层
 *
 * @author makejava
 * @since 2021-12-07 21:37:18
 */
@RestController
@RequestMapping("bookLexicon")
public class BookLexiconController {
    /**
     * 服务对象
     */
    @Resource
    private BookLexiconService bookLexiconService;

    /**
     * 分页查询
     *
     * @param bookLexicon 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BookLexicon>> queryByPage(BookLexicon bookLexicon, PageRequest pageRequest) {
        return ResponseEntity.ok(this.bookLexiconService.queryByPage(bookLexicon, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BookLexicon> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.bookLexiconService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param bookLexicon 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BookLexicon> add(BookLexicon bookLexicon) {
        return ResponseEntity.ok(this.bookLexiconService.insert(bookLexicon));
    }

    /**
     * 编辑数据
     *
     * @param bookLexicon 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BookLexicon> edit(BookLexicon bookLexicon) {
        return ResponseEntity.ok(this.bookLexiconService.update(bookLexicon));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.bookLexiconService.deleteById(id));
    }

}

