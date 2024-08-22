package com.baidu.texas.ddd.support.jms.adapter;

import com.baidu.texas.ddd.DomainEvent;
import com.baidu.texas.ddd.DomainEventPublisher;
import com.baidu.texas.ddd.DomainEventSubscriber;
import com.baidu.texas.ddd.support.jms.LiveBroker;
import com.baidu.texas.ddd.support.jms.Message;
import com.baidu.texas.ddd.support.jms.MessageListener;
import com.baidu.texas.ddd.support.jms.Topic;
import com.baidu.texas.ddd.support.jms.TopicContext;
import com.baidu.texas.ddd.support.jms.TopicPublisher;
import com.baidu.texas.ddd.support.jms.TopicSubscriber;
import java.lang.ref.WeakReference;

public class DomainMessages {
    public static DomainEventPublisher livePublisher(String domain) {
        return new Publisher(domain);
    }

    private static class Publisher implements DomainEventPublisher {
        private final Topic mDomain;
        private final TopicPublisher mDomainPublisher;
        private final TopicSubscriber mDomainSubscriber;

        Publisher(String domainName) {
            TopicContext domainContext = new TopicContext(LiveBroker.instance);
            Topic createTopic = domainContext.createTopic(domainName);
            this.mDomain = createTopic;
            this.mDomainPublisher = domainContext.createPublisher(createTopic);
            this.mDomainSubscriber = domainContext.createSubscriber(createTopic);
        }

        public void publish(DomainEvent event) {
            this.mDomainPublisher.publish(Transformer.from(event));
        }

        public DomainEventPublisher.Unsubscriber subscribe(final DomainEventSubscriber subscriber) {
            this.mDomainSubscriber.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    subscriber.handleEvent(Transformer.from(message));
                }
            });
            return new Canceller(this.mDomainSubscriber);
        }
    }

    private static class Canceller implements DomainEventPublisher.Unsubscriber {
        private final WeakReference<TopicSubscriber> mSubscriberWeakRef;

        Canceller(TopicSubscriber subscriber) {
            this.mSubscriberWeakRef = new WeakReference<>(subscriber);
        }

        public void unsubscribe() {
            TopicSubscriber subscriber = (TopicSubscriber) this.mSubscriberWeakRef.get();
            if (subscriber != null) {
                subscriber.setMessageListener((MessageListener) null);
            }
        }
    }

    private static class Transformer {
        private Transformer() {
        }

        static Message from(DomainEvent domainEvent) {
            return new Message(domainEvent);
        }

        static DomainEvent from(Message message) {
            return (DomainEvent) message.getBody(DomainEvent.class);
        }
    }
}
