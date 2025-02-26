package com.dji.sdk.cloudapi.debug.api;

import com.dji.sdk.annotations.CloudSDKVersion;
import com.dji.sdk.cloudapi.debug.*;
import com.dji.sdk.common.BaseModel;
import com.dji.sdk.common.Common;
import com.dji.sdk.common.GatewayManager;
import com.dji.sdk.common.GatewayTypeEnum;
import com.dji.sdk.exception.CloudSDKErrorEnum;
import com.dji.sdk.exception.CloudSDKException;
import com.dji.sdk.mqtt.ChannelName;
import com.dji.sdk.mqtt.MqttReply;
import com.dji.sdk.mqtt.events.EventsDataRequest;
import com.dji.sdk.mqtt.events.TopicEventsRequest;
import com.dji.sdk.mqtt.events.TopicEventsResponse;
import com.dji.sdk.mqtt.services.ServicesPublish;
import com.dji.sdk.mqtt.services.ServicesReplyData;
import com.dji.sdk.mqtt.services.TopicServicesResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author sean
 * @version 1.7
 * @date 2023/6/29
 */
public abstract class AbstractDebugService {

    @Resource
    private ServicesPublish servicesPublish;

    /**
     * Open the debug mode
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> debugModeOpen(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.DEBUG_MODE_OPEN.getMethod());
    }

    /**
     * Close the debug mode
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> debugModeClose(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.DEBUG_MODE_CLOSE.getMethod());
    }

    /**
     * Open the supplement light
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> supplementLightOpen(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.SUPPLEMENT_LIGHT_OPEN.getMethod());
    }

    /**
     * Close the supplement light
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> supplementLightClose(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.SUPPLEMENT_LIGHT_CLOSE.getMethod());
    }

    /**
     * Maintenance state switch of battery
     * @param gateway
     * @param request   data
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> batteryMaintenanceSwitch(GatewayManager gateway, BatteryMaintenanceSwitchRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.BATTERY_MAINTENANCE_SWITCH.getMethod(),
                request);
    }

    /**
     * Air conditioner working mode switch of dock
     * @param gateway
     * @param request   data
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> airConditionerModeSwitch(GatewayManager gateway, AirConditionerModeSwitchRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.AIR_CONDITIONER_MODE_SWITCH.getMethod(),
                request);
    }

    /**
     * Sound and light alarm switch of dock
     * @param gateway
     * @param request   data
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> alarmStateSwitch(GatewayManager gateway, AlarmStateSwitchRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.AIR_CONDITIONER_MODE_SWITCH.getMethod(),
                request);
    }

    /**
     * Battery storage mode switch of dock
     * @param gateway
     * @param request   data
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> batteryStoreModeSwitch(GatewayManager gateway, BatteryStoreModeSwitchRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.BATTERY_STORE_MODE_SWITCH.getMethod(),
                request);
    }

    /**
     * Reboot the dock
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> deviceReboot(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.DEVICE_REBOOT.getMethod());
    }

    /**
     * Power on the aircraft
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> droneOpen(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.DRONE_OPEN.getMethod());
    }

    /**
     * Power off the aircraft
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> droneClose(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.DRONE_CLOSE.getMethod());
    }

    /**
     * Format the dock data
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> deviceFormat(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.DEVICE_FORMAT.getMethod());
    }

    /**
     * Format the aircraft data
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> droneFormat(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.DRONE_FORMAT.getMethod());
    }

    /**
     * Open the dock cover
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> coverOpen(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.COVER_OPEN.getMethod());
    }

    /**
     * Close the dock cover
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> coverClose(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.COVER_CLOSE.getMethod());
    }

    /**
     * Open the putter
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> putterOpen(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.PUTTER_OPEN.getMethod());
    }

    /**
     * Close the putter
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> putterClose(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.PUTTER_CLOSE.getMethod());
    }

    /**
     * Turn on charging
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> chargeOpen(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.CHARGE_OPEN.getMethod());
    }

    /**
     * Turn off charging
     * @param gateway
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> chargeClose(GatewayManager gateway) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.CHARGE_CLOSE.getMethod());
    }

    /**
     * Switch of 4G enhancement mode
     * @param gateway
     * @param request   data
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> sdrWorkmodeSwitch(GatewayManager gateway, SdrWorkmodeSwitchRequest request) {
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                DebugMethodEnum.SDR_WORKMODE_SWITCH.getMethod(),
                request);
    }

    /**
     * Common interface for remote debugging
     * @param gateway
     * @param methodEnum
     * @param request   data
     * @return  services_reply
     */
    @CloudSDKVersion(exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData<RemoteDebugResponse>> remoteDebug(GatewayManager gateway, DebugMethodEnum methodEnum, BaseModel request) {
        if (Objects.nonNull(methodEnum.getClazz())) {
            if (methodEnum.getClazz() != request.getClass()) {
                throw new CloudSDKException(CloudSDKErrorEnum.INVALID_PARAMETER);
            }
            Common.validateModel(request);
        }
        return servicesPublish.publish(
                new TypeReference<RemoteDebugResponse>() {},
                gateway.getGatewaySn(),
                methodEnum.getMethod(),
                request);
    }

    /**
     * Inform of remote debug progress
     * @param request  data
     * @param headers   The headers for a {@link Message}.
     * @return events_reply
     */
    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_CONTROL_PROGRESS, outputChannel = ChannelName.OUTBOUND_EVENTS)
    public TopicEventsResponse<MqttReply> remoteDebugProgress(TopicEventsRequest<EventsDataRequest<RemoteDebugProgress>> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("remoteDebugProgress not implemented");
    }

}
