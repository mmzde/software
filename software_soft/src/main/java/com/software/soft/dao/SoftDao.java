package com.software.soft.dao;

import com.software.soft.pojo.Soft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SoftDao extends JpaRepository<Soft,String> {

    Page<Soft> findByClassifyId(String classifyId, Pageable pageable);

    @Query(value = "select * from soft where ishot=1",nativeQuery = true)
    Page<Soft> findHotList(Pageable pageable);

    @Query(value = "select * from soft order by createtime desc",nativeQuery = true)
    Page<Soft> findNewList(Pageable pageable);
}