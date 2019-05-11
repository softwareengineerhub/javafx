/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.server.client;

import com.backend.api.server.data.MessageData;

/**
 *
 * @author asusadmin
 */
public interface ServerClient {

    public Object readData(MessageData requestData);

}
