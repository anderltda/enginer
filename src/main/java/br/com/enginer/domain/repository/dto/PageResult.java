package br.com.enginer.domain.repository.dto;

import java.util.List;

import br.com.enginer.domain.repository.dto.page.Page;

/**
 * @param <T>
 */
public class PageResult<T> {

	public Page page;

	private List<T> content;

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
