package com.neusoft.reliable.base.prehandle.entity;

import java.util.Date;

public class ReliableEntity {
    private String id;
    private String editor;
    private String creater;
    private Date editTime;
    private Date createTime;
    private String orderId;
    private String orderInfo;
    private String queryOrderTimes;
    private String messageSendTimes;
    //转账状态 1：成功  2：处理中  3：失败
    private String orderStatus;
    //积分状态 1：成功  2：处理中  3：失败
    private String integralStatus;
    private String remark;
    private String field1;
    private String field2;
    private String field3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getQueryOrderTimes() {
        return queryOrderTimes;
    }

    public void setQueryOrderTimes(String queryOrderTimes) {
        this.queryOrderTimes = queryOrderTimes;
    }

    public String getMessageSendTimes() {
        return messageSendTimes;
    }

    public void setMessageSendTimes(String messageSendTimes) {
        this.messageSendTimes = messageSendTimes;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getIntegralStatus() {
        return integralStatus;
    }

    public void setIntegralStatus(String integralStatus) {
        this.integralStatus = integralStatus;
    }
}
