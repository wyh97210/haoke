package com.wyh.haoke.dubbo.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Pagination {
private Integer current;
private Integer pageSize;
private Integer total;
}