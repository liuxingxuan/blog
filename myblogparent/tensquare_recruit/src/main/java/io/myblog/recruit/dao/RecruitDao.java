package io.myblog.recruit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import io.myblog.recruit.pojo.Recruit;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit>{

    public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String statu);//where state =? oder by createtime

    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String statu);//where state !=? oder by createtime
}
