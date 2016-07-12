package com.ckx.checkcar.model;

/**
 * Created by lihui on 16/7/11.
 */
public class ReportImgBean extends BaseBean
{
    /** 照片类型，服务器统一采用的字符串类型**/
    protected static String FLAG_TYPE_BPZ = "1";
    protected static String FLAG_TYPE_ZD  = "2";

    private String reportId;
    private String flag;

    public ReportImgBean(String aReportId, String aFlag)
    {
        reportId = aReportId;
        flag = aFlag;
    }

    public String getReportId()
    {
        return reportId;
    }

    public void setReportId(String aReportId)
    {
        reportId = aReportId;
    }

    public String getFlag()
    {
        return flag;
    }

    public void setFlag(String aFlag)
    {
        flag = aFlag;
    }
}
