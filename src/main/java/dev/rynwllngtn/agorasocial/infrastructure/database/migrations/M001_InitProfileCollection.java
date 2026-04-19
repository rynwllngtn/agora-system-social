package dev.rynwllngtn.agorasocial.infrastructure.database.migrations;

import dev.rynwllngtn.agorasocial.entities.profile.Profile;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;

@ChangeUnit(id = "init-profile-collection", order = "001", author = "Ryan Wellington")
public class M001_InitProfileCollection {

    private static final Class<?> COLLECTION = Profile.class;

    @Execution
    public void execution(MongoTemplate mongoTemplate) {
        if (!mongoTemplate.collectionExists(COLLECTION)) {
            mongoTemplate.createCollection(COLLECTION);
        }

        Index index = new Index().on("profileOwner", Sort.Direction.ASC).unique();
        mongoTemplate.indexOps(COLLECTION).createIndex(index);
    }

    @RollbackExecution
    public void rollback(MongoTemplate mongoTemplate) {
        mongoTemplate.dropCollection(COLLECTION);
    }

}