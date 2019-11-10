package com.wyh.haoke.dubbo.api.vo.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult {
private Integer totalPage;
private List<HouseData> list;
}