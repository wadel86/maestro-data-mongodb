package io.maestro.data.mongodb;

import com.mongodb.client.MongoClient;
import io.maestro.common.command.CommandWithDestination;
import io.maestro.common.port.SagaDataGateway;
import io.maestro.common.saga.instance.SagaInstance;

public class SagaDataGatewayImpl implements SagaDataGateway {

    private final MongoClient mongoClient;

    public SagaDataGatewayImpl(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public SagaInstance saveSaga(SagaInstance saga) {
        return null;
    }

    @Override
    public SagaInstance saveSagaAndSendCommand(SagaInstance saga, CommandWithDestination command) {
        return null;
    }

    @Override
    public SagaInstance findSaga(String sagaId, String sagaType) {
        return null;
    }
}
