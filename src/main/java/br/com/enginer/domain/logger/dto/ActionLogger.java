package br.com.enginer.domain.logger.dto;

import java.time.LocalDateTime;

/**
 * 
 */
public class ActionLogger {

	private String action;
	private String id;
	private String username;
	private LocalDateTime datelocal;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getDatelocal() {
		return datelocal;
	}

	public void setDatelocal(LocalDateTime datelocal) {
		this.datelocal = datelocal;
	}

}
