package com.zf.dao;

import com.zf.entity.Article;
import com.zf.entity.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2021-01-12 20:22
 */
public interface CollectDao extends JpaRepository<Collect,Integer>, JpaSpecificationExecutor<Collect> {

    @Transactional
    @Rollback(false)
    @Modifying
    @Query(value = "delete from collect where id =?1",nativeQuery = true)
    public Integer deleteCollect(Integer id);
}
