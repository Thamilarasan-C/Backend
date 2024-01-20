package com.thamil.project.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserEntity extends User implements UserDetails {
  private List<GrantedAuthority> grantedAuthority;

  public UserEntity(User user) {
    super();
    grantedAuthority = List.of(new SimpleGrantedAuthority(super.getRole()));
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return grantedAuthority;
  }

  @Override
  public String getUsername() {
    return super.getName();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}