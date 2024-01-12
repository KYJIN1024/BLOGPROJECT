package com.david.service;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.david.domain.Board.Board;
import com.david.domain.Board.BoardRepository;
import com.david.domain.user.User;
import com.david.dto.board.BoardSaveRequestDto;
import com.david.dto.board.BoardUpdateRequestDto;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {

		private final BoardRepository boardRepository;
		
		@Transactional
		public Long save(BoardSaveRequestDto boardSaveRequestDto, User user) {
			boardSaveRequestDto.setUser(user);
			return boardRepository.save(boardSaveRequestDto.toEntity()).getId();
		}

		@Transactional(readOnly = true)
		public Page<Board>  findAll(Pageable pageable) {
			return boardRepository.findAll(pageable);
		}
		
		@Transactional(readOnly = true)
		public Board detail(Long id) {
			return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
		}

		@Transactional
		public void deleteById(Long id) {
			boardRepository.deleteById(id);
			
		}

		@Transactional
		public Long update(Long id, BoardUpdateRequestDto boardUpdateRequestDto) {
			Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
			board.update(boardUpdateRequestDto.getTitle(), boardUpdateRequestDto.getContent());
			
			return id;
		}

		public void updateCount(Long id) {
			// TODO Auto-generated method stub
			
		}
		
		@Transactional(readOnly = true)
		public Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pagebale){
			return boardRepository.findByTitleContainingOrContentContaining(title, content, pagebale);
		}
		
		
		

}
