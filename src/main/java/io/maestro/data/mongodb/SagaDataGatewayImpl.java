package io.maestro.data.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.maestro.common.command.CommandWithDestination;
import io.maestro.common.port.SagaDataGateway;
import io.maestro.common.saga.instance.SagaInstance;
import org.bson.Document;

public class SagaDataGatewayImpl implements SagaDataGateway {

    private final MongoClient mongoClient;
    private final MongoDatabase mongoDatabase;
    private final MongoCollection<SagaInstance> sagaCollection;
    private final MongoCollection<CommandWithDestination> eventsCollection;

    public SagaDataGatewayImpl(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        this.mongoDatabase = this.mongoClient.getDatabase("saga_db");
        this.sagaCollection = this.mongoDatabase.getCollection("saga", SagaInstance.class);
        this.eventsCollection = this.mongoDatabase.getCollection("events", CommandWithDestination.class);
    }

    @Override
    public SagaInstance saveSaga(SagaInstance saga) {
        //set the id here.
        this.sagaCollection.insertOne(saga);
        return saga;
    }

    @Override
    public SagaInstance saveSagaAndSendCommand(SagaInstance saga, CommandWithDestination command) {
        return null;
    }

    @Override
    public SagaInstance findSaga(String sagaId, String sagaType) {
        return this.sagaCollection.find(new Document("id", sagaId), SagaInstance.class)
                                  .first();
    }
}
