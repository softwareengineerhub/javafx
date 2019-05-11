/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.server.client;

import com.backend.api.server.data.MessageData;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author asusadmin
 */
public class ServerClientImpl implements ServerClient {

    private String host;
    private int port;
    private Socket socket;

    public ServerClientImpl(String host, int port) {
        try {
            this.host = host;
            this.port = port;
            //socket = new Socket(InetAddress.getByName(host), port);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Object readData(MessageData requestData) {
        try {
            socket = new Socket(InetAddress.getByName(host), port);            
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(requestData);
            out.flush();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            return in.readObject();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            close();
        }
    }

    public void close() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
