package com.ckx.checkcar.model;

/**
 * Created by lihui on 16/7/11.
 */
public class ReportZDImgBean extends ReportImgBean
{
    private String categoryId;
    private String attributeId;

    public ReportZDImgBean(String aReportId, String aCategoryId, String aAttributeId)
    {
        super(aReportId, ReportImgBean.FLAG_TYPE_ZD);
        categoryId = aCategoryId;
        attributeId = aAttributeId;
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(String aCategoryId)
    {
        categoryId = aCategoryId;
    }

    public String getAttributeId()
    {
        return attributeId;
    }

    public void setAttributeId(String aAttributeId)
    {
        attributeId = aAttributeId;
    }
}
