package com.wyh.haoke.dubbo.api.service;

import com.wyh.haoke.dubbo.api.vo.es.HouseData;
import com.wyh.haoke.dubbo.api.vo.es.SearchResult;
import org.elasticsearch.client.Request;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    public static final Integer ROWS = 10;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    public SearchResult search(String keyWord, Integer page) {

        PageRequest pageRequest = PageRequest.of(page - 1, ROWS);
        SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchQuery("title",
                keyWord).operator(Operator.AND)) // match查询
                .withPageable(pageRequest)
                .withHighlightFields(new HighlightBuilder.Field("title"))
                .build();
        AggregatedPage<HouseData> searchResults = elasticsearchTemplate.queryForPage(query, HouseData.class);

        return new SearchResult(searchResults.getTotalPages(),searchResults.getContent());
    }
}
