package com.david.controller.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.david.config.auth.PrincipalDetail;
import com.david.domain.reply.Reply;
import com.david.service.Replyservice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReplyApiController {

	private final Replyservice replyService;
	
	@PostMapping("/api/v1/board/{boardId}/reply")
	public void save(@PathVariable Long boardId,
					 @RequestBody Reply reply,
					 @AuthenticationPrincipal PrincipalDetail principalDetail) {
		replyService.replySave(boardId, reply, principalDetail.getUser());
	}
	
	@DeleteMapping("/api/v1/board/{boardId}/reply/{replyId}")
    public void delete(@PathVariable Long replyId) {
        replyService.replyDelete(replyId);
    }
	
	
}
