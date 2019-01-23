package com.example.jpa.repository;

import com.example.jpa.model.Data;
import com.example.jpa.model.DataPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, DataPK> {
//    Page<Comment> findByPostId(Long postId, Pageable pageable);
//    Optional<Comment> findByIdAndPostId(Long id, Long postId);
}
