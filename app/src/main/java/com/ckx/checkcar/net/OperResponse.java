package com.ckx.checkcar.net;

public class OperResponse
{
    public String retCode; // 响应码   200:成功,其他:异常
    public String errorMsg;// 响应消息
    public String value;   // 响应数据,加密的数据

    public OperResponse()
    {
    }
}
