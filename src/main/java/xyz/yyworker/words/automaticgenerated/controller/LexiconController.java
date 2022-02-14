package xyz.yyworker.words.automaticgenerated.controller;

import xyz.yyworker.words.automaticgenerated.entity.Lexicon;
import xyz.yyworker.words.automaticgenerated.service.LexiconService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Lexicon)表控制层
 *
 * @author makejava
 * @since 2021-12-07 21:41:32
 */
@RestController
@RequestMapping("lexicon")
public class LexiconController {
    /**
     * 服务对象
     */
    @Resource
    private LexiconService lexiconService;

    /**
     * 分页查询
     *
     * @param lexicon 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Lexicon>> queryByPage(Lexicon lexicon, PageRequest pageRequest) {
        return ResponseEntity.ok(this.lexiconService.queryByPage(lexicon, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Lexicon> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.lexiconService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param lexicon 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Lexicon> add(Lexicon lexicon) {
        return ResponseEntity.ok(this.lexiconService.insert(lexicon));
    }

    /**
     * 编辑数据
     *
     * @param lexicon 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Lexicon> edit(Lexicon lexicon) {
        return ResponseEntity.ok(this.lexiconService.update(lexicon));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.lexiconService.deleteById(id));
    }

}

