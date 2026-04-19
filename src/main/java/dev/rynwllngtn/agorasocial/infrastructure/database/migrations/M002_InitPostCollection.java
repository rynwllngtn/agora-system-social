package dev.rynwllngtn.agorasocial.infrastructure.database.migrations;

import dev.rynwllngtn.agorasocial.entities.post.Post;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

@ChangeUnit(id = "init-post-collection", order = "002", author = "Ryan Wellington")
public class M002_InitPostCollection {

    private static final Class<?> COLLECTION = Post.class;

    @Execution
    public void execution(MongoTemplate mongoTemplate) {
        if (!mongoTemplate.collectionExists(COLLECTION)) {
            mongoTemplate.createCollection(COLLECTION);
        }

        Index index = new Index().on("author.id", Sort.Direction.ASC);
        mongoTemplate.indexOps(COLLECTION).createIndex(index);
    }

    @RollbackExecution
    public void rollback(MongoTemplate mongoTemplate) {
        mongoTemplate.dropCollection(COLLECTION);
    }

}