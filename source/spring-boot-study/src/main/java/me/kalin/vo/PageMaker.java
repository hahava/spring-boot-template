package me.kalin.vo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PageMaker<T> {

	private Page<T> result;
	private Pageable currentPage;
	private int startPage;
	private int lastPage;
	public static final int MAX_PAGINATION_SIZE = 5;

	public Pageable getCurrentPage() {
		return currentPage;
	}

	public Page<T> getResult() {
		return result;
	}

	public PageMaker(Page<T> result) {
		this.result = result;
		this.currentPage = result.getPageable();
		setStartPage();
		setLastPage();
	}

	public int getStartPage() {
		return startPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	private void setStartPage() {
		this.startPage = (currentPage.getPageNumber() / MAX_PAGINATION_SIZE) * 5 + 1;
	}

	private void setLastPage() {
		int tempLastPage = (currentPage.getPageNumber() / MAX_PAGINATION_SIZE + 1) * 5;
		this.lastPage = tempLastPage <= this.result.getTotalPages() ? tempLastPage : this.currentPage.getPageSize();
	}

}
