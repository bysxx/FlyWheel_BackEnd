package com.flywheel.project.service;

import com.flywheel.project.domain.entity.Board;
import com.flywheel.project.domain.repository.BoardRepository;
import com.flywheel.project.dto.BoardDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

     @Transactional // 트랜잭션 처리 지원, 트랜잭션 기능이 적용된 프록시 객체 생성 (Commit or Rollback 수행)
    public Long savePost(BoardDto boardDto) { // repository를 통해 실제로 데이터를 저장
         return boardRepository.save(boardDto.toEntity()).getId();
     }

    @Transactional
    public List<BoardDto> getBoardList() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board : boards){
           BoardDto boardDto = BoardDto.builder()
                   .id(board.getId())
                   .title(board.getTitle())
                   .content(board.getContent())
                   .writer(board.getWriter())
                   .createdDate(board.getCreatedDate())
                   .build();

           boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }

    @Transactional
    public BoardDto getPost(Long id) {
        Optional<Board> boardWrapper = boardRepository.findById(id);
        Board board = boardWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createdDate(board.getCreatedDate())
                .build();

        return boardDto;
    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public List<BoardDto> searchPosts(String keyword) {
        List<Board> boards = boardRepository.findByTitleContaining(keyword);
        List<BoardDto> boardDtoList = new ArrayList<>();

        if (boards.isEmpty()) return boardDtoList;

        for (Board board : boards) {
            boardDtoList.add(this.convertEntityToDto(board));
        }

        return boardDtoList;
    }

    private BoardDto convertEntityToDto(Board board) {
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createdDate(board.getCreatedDate())
                .build();
    }





}