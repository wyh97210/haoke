package com.wyh.haoke.dubbo.api.graphql;


import com.wyh.haoke.dubbo.api.service.HouseResourcesService;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

//实现的功能： 将GraphQL对象载入到Spring容器,并且完成GraphQL的初始化功能
@Component
public class GraphQLProvider {

    private GraphQL graphQL;
    @Autowired
    private HouseResourcesService houseResourcesService;

    @Autowired
    private List<MydataFetcher> mydataFetchers;
    //实现GraphQL的初始化
    @PostConstruct
    public void init() throws FileNotFoundException {


        File file = ResourceUtils.getFile("classpath:haoke.graphqls");

        this.graphQL=GraphQL.newGraphQL(buildGraphQLSchema(file)).build();
    }
    private GraphQLSchema buildGraphQLSchema(File file){
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(file);
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return  schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, buileRuntimeWiring());
    }
    private RuntimeWiring buileRuntimeWiring(){
        return RuntimeWiring.newRuntimeWiring()
                .type("HaokeQuery", builder ->{

                        for( MydataFetcher mydataFetchers:mydataFetchers) {
                            builder.dataFetcher(mydataFetchers.fileName(),
                                    environment ->
                                            mydataFetchers.dataFotchor(environment));
                        }
                            return builder;
                        }).build();

                }
    @Bean
    public GraphQL getGraphQL() {
        return this.graphQL;
    }
}
