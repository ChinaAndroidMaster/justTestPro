package com.ckx.checkcar.model;

/**
 * Created by lihui on 16/7/11.
 */
public class ReportBPZImgBean extends ReportImgBean
{
    private String imgType;

    public ReportBPZImgBean(String aReportId, String aImgType)
    {
        super(aReportId, ReportImgBean.FLAG_TYPE_BPZ);
        imgType = aImgType;
    }

    public String getImgType()
    {
        return imgType;
    }

    public void setImgType(String aImgType)
    {
        imgType = aImgType;
    }
}
