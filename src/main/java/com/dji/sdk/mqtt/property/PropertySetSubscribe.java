package com.dji.sdk.mqtt.property;

import com.dji.sdk.common.GatewayManager;
import com.dji.sdk.mqtt.IMqttTopicService;
import com.dji.sdk.mqtt.TopicConst;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author sean
 * @version 1.7
 * @date 2023/5/24
 */
@Component
public class PropertySetSubscribe {

    public static final String TOPIC = TopicConst.THING_MODEL_PRE + TopicConst.PRODUCT + "%s" + TopicConst.PROPERTY_SUF + TopicConst.SET_SUF + TopicConst._REPLY_SUF;

    @Resource
    private IMqttTopicService topicService;

    public void subscribe(GatewayManager gateway) {
        topicService.subscribe(String.format(TOPIC, gateway.getGatewaySn()));
    }

    public void unsubscribe(GatewayManager gateway) {
        topicService.unsubscribe(String.format(TOPIC, gateway.getGatewaySn()));
    }
}
