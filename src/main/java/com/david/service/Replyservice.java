package com.david.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.david.domain.Board.Board;
import com.david.domain.Board.BoardRepository;
import com.david.domain.reply.Reply;
import com.david.domain.reply.ReplyRepository;
import com.david.domain.user.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class Replyservice {
	
	private final ReplyRepository replyRepository;
	private final BoardRepository boardRepository;
	
	
	@Transactional
	public void replySave(Long boardId, Reply reply, User user) {
		Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("해당 boardId가 없습니다. id=" + boardId));
	
		reply.save(board, user);
		
		replyRepository.save(reply);
	
	}


	public void replyDelete(Long replyId) {
		replyRepository.deleteById(replyId);
		
	}

}
