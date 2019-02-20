package io.myblog.base.service;

import io.myblog.base.dao.LabelDao;
import io.myblog.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
@EnableAutoConfiguration
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     * @return
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     * 根据 ID 查询标签
     * @param id
     * @return
     */
    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    public void add(Label label){
        label.setId(idWorker.nextId()+" ");//设置ID
        labelDao.save(label);
    }
    public void update(Label label){
        labelDao.save(label);
    }

    public void deleteById(String id){
        labelDao.deleteById(id);
    }

}
