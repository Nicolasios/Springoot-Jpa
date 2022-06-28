package com.example.ty.common;


import java.util.List;
import org.springframework.data.domain.Page;

public class PageResult<T> extends RestResult<List<T>> {
    private Integer current = 1;
    private Integer pageSize = 10;
    private Long total;
    private Integer totalPage;

    public PageResult(Integer current, Integer pageSize, Long totalNum) {
        this.current = current;
        this.pageSize = pageSize;
        this.total = totalNum;
        this.totalPage = (this.total.intValue() + this.pageSize - 1) / this.pageSize;
    }

    public PageResult(Integer current, Integer pageSize, Long totalNum, List<T> data) {
        this.current = current;
        this.pageSize = pageSize;
        this.total = totalNum;
        this.totalPage = (this.total.intValue() + this.pageSize - 1) / this.pageSize;
        super.setData(data);
    }

    public static <E> PageResult<E> ok(int code, String message, Integer currentPage, Integer pageSize, Long totalNum, List<E> data) {
        PageResult<E> result = new PageResult(currentPage, pageSize, totalNum, data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <E> PageResult<E> ok(Page<E> page) {
        return new PageResult(page.getNumber(), page.getSize(), page.getTotalElements(), page.getContent());
    }

    public static <E> PageResult<E> error(int code, String message, Integer currentPage, Integer pageSize) {
        PageResult<E> result = new PageResult(currentPage, pageSize, 0L);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public Integer getCurrent() {
        return this.current;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public Long getTotal() {
        return this.total;
    }

    public Integer getTotalPage() {
        return this.totalPage;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageResult)) {
            return false;
        } else {
            PageResult<?> other = (PageResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$current = this.getCurrent();
                    Object other$current = other.getCurrent();
                    if (this$current == null) {
                        if (other$current == null) {
                            break label59;
                        }
                    } else if (this$current.equals(other$current)) {
                        break label59;
                    }

                    return false;
                }

                Object this$pageSize = this.getPageSize();
                Object other$pageSize = other.getPageSize();
                if (this$pageSize == null) {
                    if (other$pageSize != null) {
                        return false;
                    }
                } else if (!this$pageSize.equals(other$pageSize)) {
                    return false;
                }

                Object this$total = this.getTotal();
                Object other$total = other.getTotal();
                if (this$total == null) {
                    if (other$total != null) {
                        return false;
                    }
                } else if (!this$total.equals(other$total)) {
                    return false;
                }

                Object this$totalPage = this.getTotalPage();
                Object other$totalPage = other.getTotalPage();
                if (this$totalPage == null) {
                    if (other$totalPage != null) {
                        return false;
                    }
                } else if (!this$totalPage.equals(other$totalPage)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageResult;
    }

    public int hashCode() {
        int result = 1;
        return result;
    }

    public String toString() {
        return "PageResult(current=" + this.getCurrent() + ", pageSize=" + this.getPageSize() + ", total=" + this.getTotal() + ", totalPage=" + this.getTotalPage() + ")";
    }

    public PageResult() {
    }
}
