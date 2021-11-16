package io.maestro.data.mongodb;

import io.maestro.data.mongodb.common.CommandWithDestination;
import io.maestro.data.mongodb.common.SagaInstance;

public interface SagaDataGateway {
    SagaInstance saveSaga(SagaInstance saga);
    SagaInstance saveSagaAndSendCommand(SagaInstance saga, CommandWithDestination command);
    SagaInstance findSaga(String sagaId, String sagaType);
}
