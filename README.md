# distributed

pay: 模拟转账服务
reliable: 模拟可靠性服务
integral: 模拟积分服务
common: 工具类项目

调用入口: localhost:8082/pay/transfer 
    1: 转账前，通过HTTP向reliable发送预处理信息
    2: 转账成功后，通过HTTP向reliable发送处理成功信息
    3: reliable处理完转账业务后,调用MQ向integral服务发送增加积分信息
    4: integral处理成功积分业务,通过HTTP回调reliable，发送操作成功信息
    
获取积分处理失败数据: localhost:8083/reliable/queryFailIntegral

定时任务类：reliable项目ScheduledService类