package com.david.config.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.david.domain.user.User;

public class PrincipalDetail implements UserDetails {
	
	private User user; // User 엔티티 참조

    // User 객체를 받는 생성자
    public PrincipalDetail(User user) {
        this.user = user;
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	  //사용자 이메일
    public String getEmail() {
        return user.getEmail();
    }

    //사용자 닉네임
    public String getNickname() {
        return user.getNickname();
    }

    //사용자 pk
    public Long getId() {
        return user.getId();
    }
	
    public User getUser() {
        return this.user;
    }
	
	
}
