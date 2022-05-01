package com.flywheel.project.domain.repository;

import com.flywheel.project.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // JpaRepository에서는 By 뒷 부분이 SQL의 where 조건 절에 해당. 따라서, Containing을 붙여주면 Like 검색이 됨.
    List<Board> findByTitleContaining(String keyword);

}
