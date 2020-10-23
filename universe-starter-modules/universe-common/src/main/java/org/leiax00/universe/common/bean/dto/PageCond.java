package org.leiax00.universe.common.bean.dto;

import lombok.Data;

@Data
public class PageCond<T extends FilterCond> {
    private int pageSize;

    private int pageNum;

    private String orderBy;

    private T filterBy;
}
