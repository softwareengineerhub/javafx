package com.backend.api.server.client;

import com.backend.api.server.data.MessageData;

public interface ServerClient {

    public Object readData(MessageData requestData);
}
