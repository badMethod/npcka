package pers.npcka.model;

public class Page {
    private Integer currentPage;
    private Integer pageSize;
    private Object page;

    public Page(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Page virify(Page page,int defaultPage,int defaultSize) {
        if (page.getCurrentPage() == null || page.getCurrentPage() <= 0) {
            page.setCurrentPage(defaultPage);
        }
        if (page.getPageSize() == null || page.getPageSize() <= 0) {
            page.setPageSize(defaultSize);
        }
        return page;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }
}
