package io.myblog.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import io.myblog.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{

    /**
     * 最新问答列表分页
     * @param labelid
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem,tb_pl WHERE id = problemid AND labelid =? order by replytime DESC",nativeQuery = true)
    public Page<Problem> newlist(String labelid, Pageable pageable);

    /**
     * 最热回复列表
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem,tb_pl WHERE id = problemid AND labelid =? order by reply DESC" ,nativeQuery = true)
    public Page<Problem> hotlist(String labelid, Pageable pageable);

    /**
     * 等待回答列表
     * @return
     */
    @Query(value = "SELECT * FROM tb_problem,tb_pl WHERE id = problemid AND labelid =? AND reply = 0 ORDER BY createtime DESC" ,nativeQuery = true)
    public Page<Problem> waitlist(String labelid, Pageable pageable);
}
