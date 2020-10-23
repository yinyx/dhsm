/*
常数定义
*/

package com.nari.dhsm.mqtt;

public class ConstStr {

	//数据库操�?
	//数据库更新条目数�?
	static public final int REAL_DATA_UPDATE = 0;
	//状态更�?上下�?
	static public final int DEV_STATUS_UPDATE = 1;
	//实时数据插入
	static public final int REAL_DATA_INSERT = 2;
	//历史数据插入
	static public final int HISTORY_DATA_INSERT = 3;
	//采集装置状态更�?
	static public final int SAMPLE_DEV_STATUS_UPDATE = 4;
	//监控装置状态更�?
	static public final int MONITOR_STATUS_UPDATE = 5;
	//callId更新
	static public final int DEV_CALL_ID = 6;

	static public final int BOARD_STATUS_INSERT = 7;

	static public final int BOARD_STATUS_UPDATE = 8;

	//删除多余的历史数据，防止数据库过�?
	static public final int DELETE_HISTORY_ROCORD = 9;


	//发送变量步�?
	//合并信号
	static public final int SEND_MERGED_SIGNAL = 0;
	//具体信号（被合并的信号）
	static public final int SEND_DETAIL_SIGNAL = 1;
	//硬件信号
	static public final int SEND_HARDWARE_SIGNAL = 2;
	//非侵�?
	static public final int SEND_NONINVADE_SIGNAL = 3;

	//
	static public final String EVENT_TOPIC_PRIFIX = "/V1/StateDetect/Event/";

	static public final String NOTICE_TOPIC_PRIFIX = "/V1/StateDetect/Notice/";

	static public final String REQUEST_TOPIC_PRIFIX = "/V1/StateDetect/Request/";

	static public final String RESPONSE_TOPIC_PRIFIX = "/V1/StateDetect/Response/";

	//JSON
	static public final String SQID = "sqid";

	static public final String TIME = "time";

	static public final String TYPE = "type";

	static public final String STATUS = "status";

	static public final String DATAS = "data";

	static public final String DSPORT = "dstPort";

	static public final String SECURITY = "security";

	static public final String KEEPALIVE = "keepAlive";

	static public final String RESULT = "result";

	static public final String PARAMS = "params";

	static public final String PARAM = "param";

	static public final String IP = "ip";

	static public final String ONLINE = "online";

	static public final String DEVSTATUS = "deviceStatus";

	static public final String DEVID = "devId";

	static public final String DSTIP = "dstIp";

	static public final String MQTTRECEIVEDTOPIC = "mqtt_receivedTopic";

	static public final String SENDERID = "senderID";

	static public final String VALUE = "value";

	//报文类型
	static public final String CONNECT = "connect";

	static public final String DISCONNECT = "disconnect";

	static public final String READPARAM = "readParam";

	static public final String DIRECTCTRL = "directCtrl";


	//命令回复
	static public final int SUCCESS = 0;
	static public final int FAIL = 1;

	//装置在线状态online------>
	//在线
	static public final int ONLINE_STATUS = 1;
	//离线
	static public final int OFFLINE_STATUS = 0;
	//<------装置在线状态online

	//dev_template_flag表的alarmType--------->
	static public final int LESS_THAN = 0;

	static public final int GREATER_THAN = 1;

	static public final int GREATER_LESS = 2;

	static public final int EQUAL = 3;

	static public final int NO_WARN = 4;

	static public final int OVER_THRLD = 5;//越上下限告警

	static public final int NOT_EQUAL = 6; //
	//<---------dev_template_flag表的alarmType

	//dev_online_flag的alarm_flag----->
	//信号非告
	static public final int NORMAL = 0;
	//信号告警
	static public final int WARN = 1;
	//<-----dev_online_flag的alarm_flag


	//info_device_config的intellegent是否智能----->
	static public final int INTELLEGENT = 0;
	static public final int NONINZTELLEGENT = 1;
	//<-----------



	//dev_template_flag表的belong_flag---------->
	//公共
	static public final int PUBLIC_SIGNAL = 0;
	//独占
	static public final int PRIVATE_SIGNAL = 1;
	//belong_flag<----------

	//dev_template_flag表monitor_mode------>
	//侵入模式 保护装置采集
	static public final int INVADE_MODE = 0;
	//非侵入1u采集
	static public final int NONINVADE_MODE = 1;
	//<----------------monitor_mode

	//dev_template_flag表的value_type---->
    static public final int INT_TYPE = 0;
    static public final int FLOAT_TYPE = 1;
    static public final int BOOLEAN_TYPE = 2;

	//<----dev_template_flag表的value_type

	static public final int HARD_SIGNAL = 0;

	static public final int DIVIDED_SIGNAL = 1;

	static public final int MERGE_SIGNAL = 2;

	//signal_type
	//0-闭锁信号�?-告警信号�?-其他智能板卡报警闭锁信号�?-B02额外报警信号
	static public final int BS_SIGNAL = 0;
	static public final int BJ_SIGNAL = 1;
	static public final int OTHER_BOARD_SIGNAL = 2;
	//static public final int B02_BJ_SIGNAL = 3;

	//值是否有�?
	static public final int VALUE_INVALID = 0;
	static public final int VALUE_VALID = 1;

	static public final int CRYPTED = 1;
	static public final int NONCRYPTED = 0;

	//不使�?
	static public final int DISENABLED = 0;
	//使能
	static public final int ENABLED = 1;


	static public final int MAX_HISTORY_SIZE = 200;


	//信号类别
	//
    static public final int PWR_SIGNAL = 3;

    static public final int ADC_SIGNAL = 4;

    static public final int AI_SIGNAL = 5;

    static public final int BI_SIGNAL = 6;

	static public final int BO_SIGNAL = 7;

    static public final int LCD_SIGNAL = 8;

    static public final int GOOSE_SIGNAL = 9;

    static public final int CPU_SIGNAL = 10;

    static public final int CHASSI_SIGNAL = 11;

    static public final int UNDIFINED = 0;
    static public final int  VALID = 2;
    static public final int INVALID = 1;

}
