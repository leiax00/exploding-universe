package org.leiax00.universe.common.bean.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageRst<T> {
    private int pageNum;
    private int pageSize;
    private long totalSize;
    private int totalPages;
    private List<T> data;

}
