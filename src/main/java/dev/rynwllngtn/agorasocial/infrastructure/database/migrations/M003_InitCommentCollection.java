package dev.rynwllngtn.agorasocial.infrastructure.database.migrations;

import dev.rynwllngtn.agorasocial.entities.comment.Comment;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

@ChangeUnit(id = "init-comment-collection", order = "003", author = "Ryan Wellington")
public class M003_InitCommentCollection {

    private static final Class<?> COLLECTION = Comment.class;

    @Execution
    public void execution(MongoTemplate mongoTemplate) {
        if (!mongoTemplate.collectionExists(COLLECTION)) {
            mongoTemplate.createCollection(COLLECTION);
        }

        mongoTemplate.indexOps(COLLECTION).createIndex(new Index().on("author.id", Sort.Direction.ASC));
        mongoTemplate.indexOps(COLLECTION).createIndex(new Index().on("post.id", Sort.Direction.ASC));
    }

    @RollbackExecution
    public void rollback(MongoTemplate mongoTemplate) {
        mongoTemplate.dropCollection(COLLECTION);
    }

}