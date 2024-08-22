package com.baidu.searchbox.player.message;

public class PlayerMessengerFactory implements IMessengerFactory {
    public IMessenger createMessenger() {
        return new RxMessenger();
    }
}
