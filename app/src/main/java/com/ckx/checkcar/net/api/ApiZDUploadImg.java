package com.ckx.checkcar.net.api;

import com.ckx.checkcar.base.net.IRequestCallback;
import com.ckx.checkcar.model.ReportBPZImgBean;
import com.ckx.checkcar.model.ReportZDImgBean;
import com.ckx.checkcar.net.APPBaseRequest;
import com.ckx.checkcar.net.NetConstants;

/**
 * Created by lihui on 16/7/11.
 */
public class ApiZDUploadImg extends APPBaseRequest<String>
{
    public ApiZDUploadImg(IRequestCallback aRequestCallback)
    {
        super(aRequestCallback);
    }

    @Override
    public String getApi()
    {
        return NetConstants.API_UPLOAD_IMG;
    }

    public void setParams(String aReportId, String aCategoryId, String aAttributeId)
    {
        setParams(new ReportZDImgBean(aReportId, aCategoryId, aAttributeId));
    }
}
