package com.example.gwt.client;

import com.vaadin.shared.communication.ServerRpc;

public interface MyPersistToServerRpc extends ServerRpc {
    void persistToServer();
}
