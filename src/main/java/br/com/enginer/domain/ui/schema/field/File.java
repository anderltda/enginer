package br.com.enginer.domain.ui.schema.field;

import java.util.List;

/**
 * 
 */
public class File extends Base {

	private static final String TYPE = "file";
	private String title;
	private String action;
	private String mode;
	private List<String> files;

	public String getType() {
		return TYPE;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public List<String> getFiles() {
		return files;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

}
