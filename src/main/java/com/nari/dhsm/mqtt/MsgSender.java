package com.nari.dhsm.mqtt;

import com.alibaba.fastjson.JSONObject;
import com.nari.dhsm.mqtt.mqttPublisher;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class MsgSender {
	@Autowired
	private mqttPublisher Publisher;

    @Value("${mqtt.publish.defaultTopic}")
    private String TopicPrefix;

    //发送控制命令报文组包
       public JSONObject sendDirectOrder(int indexno) {
        JSONObject obj = new JSONObject();
        //obj.put(ConstStr.IP, dtDev.getDevIP());
        //obj.put(ConstStr.DEVID, devId);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.zzz");
        String strSDate =df.format(new Date());
        obj.put(ConstStr.TIME, strSDate);
        obj.put(ConstStr.TYPE, ConstStr.DIRECTCTRL);
        obj.put(ConstStr.VALUE, indexno);
        obj.put(ConstStr.SQID,0);

        JSONObject data = new JSONObject();
        data.put(ConstStr.DSTIP, "0.0.0.0");
        data.put(ConstStr.PARAM, "B02.ied04_cpu00_yk0101");
        obj.put(ConstStr.DATAS,data);

        String strTopic = TopicPrefix+"strDevId";
        Publisher.sendToMqtt(strTopic, 0, obj.toString());
        return obj;
    }
}
