package com.david.blogproject.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.david.dto.HelloResponseDto;

class HelloResponseDtoTest {

	@Test
	public void lomboktest() {
		//given
		String name = "minsu";
		String nickname = "babo";
		
		//when
		HelloResponseDto helloResponseDto = new HelloResponseDto(name, nickname);
		
		//then
		assertThat(helloResponseDto.getName()).isEqualTo(name);
		assertThat(helloResponseDto.getNickname()).isEqualTo(nickname);
		
		
		
	}

}
