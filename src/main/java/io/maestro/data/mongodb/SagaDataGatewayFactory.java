package io.maestro.data.mongodb;

import com.mongodb.client.MongoClients;

public class SagaDataGatewayFactory {

    private SagaDataGatewayImpl instance;

    public SagaDataGateway create(String uri){
        if(instance == null){
            synchronized (SagaDataGatewayFactory.class){
                if(instance == null){
                    this.instance = new SagaDataGatewayImpl(MongoClients.create(uri));
                }
            }
        }
        return instance;
    }

}
