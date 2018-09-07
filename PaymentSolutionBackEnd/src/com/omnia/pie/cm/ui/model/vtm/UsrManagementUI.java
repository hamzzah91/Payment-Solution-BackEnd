package com.omnia.pie.cm.ui.model.vtm;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UsrManagementUI implements Serializable {
	
	private static final long serialVersionUID = 3716792990953706255L;
	
	private String username;
	private LocalDateTime lastLogin;
	private LocalDateTime passwordDate;
	private LocalDateTime blockedUntil;
	private boolean passwordBlocked;
	private String email;
	private long userGroupId;
	private String userGroupName;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDateTime getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}
	public LocalDateTime getPasswordDate() {
		return passwordDate;
	}
	public void setPasswordDate(LocalDateTime passwordDate) {
		this.passwordDate = passwordDate;
	}
	public LocalDateTime getBlockedUntil() {
		return blockedUntil;
	}
	public void setBlockedUntil(LocalDateTime blockedUntil) {
		this.blockedUntil = blockedUntil;
	}
	public boolean isPasswordBlocked() {
		return passwordBlocked;
	}
	public void setPasswordBlocked(boolean passwordBlocked) {
		this.passwordBlocked = passwordBlocked;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getUserGroupId() {
		return userGroupId;
	}
	public void setUserGroupId(long userGroupId) {
		this.userGroupId = userGroupId;
	}
	public String getUserGroupName() {
		return userGroupName;
	}
	public void setUserGroupName(String userGroupName) {
		this.userGroupName = userGroupName;
	}
	
	
}
