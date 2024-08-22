package com.baidu.texas.ddd;

public interface DomainEventSubscriber {
    void handleEvent(DomainEvent domainEvent);
}
