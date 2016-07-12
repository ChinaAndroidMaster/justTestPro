package com.ckx.checkcar.bean;

/**
 * Created by 201607040319 on 2016/7/7.
 */
public class HomeBean
{
    private int carIconId;
    private String carName;
    private String date;
    private String version;
    private String state;
    private String carSaleName;
    private String tel;
    private String ivState;
    private int  stateIconId;
    private boolean isPendingAudit;

    public HomeBean(int aCarIconId, String aCarName, String aDate, String aVersion, String aState, String aCarSaleName, String aTel, String aIvState, int aStateIconId, boolean aIsPendingAudit)
    {
        carIconId = aCarIconId;
        carName = aCarName;
        date = aDate;
        version = aVersion;
        state = aState;
        carSaleName = aCarSaleName;
        tel = aTel;
        ivState = aIvState;
        stateIconId = aStateIconId;
        isPendingAudit = aIsPendingAudit;
    }

    public HomeBean(){}


    public int getCarIconId()
    {
        return carIconId;
    }

    public void setCarIconId(int aCarIconId)
    {
        carIconId = aCarIconId;
    }

    public String getCarName()
    {
        return carName;
    }

    public void setCarName(String aCarName)
    {
        carName = aCarName;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String aDate)
    {
        date = aDate;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String aVersion)
    {
        version = aVersion;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String aState)
    {
        state = aState;
    }

    public String getCarSaleName()
    {
        return carSaleName;
    }

    public void setCarSaleName(String aCarSaleName)
    {
        carSaleName = aCarSaleName;
    }

    public String getTel()
    {
        return tel;
    }

    public void setTel(String aTel)
    {
        tel = aTel;
    }

    public String getIvState()
    {
        return ivState;
    }

    public void setIvState(String aIvState)
    {
        ivState = aIvState;
    }

    public int getStateIconId()
    {
        return stateIconId;
    }

    public void setStateIconId(int aStateIconId)
    {
        stateIconId = aStateIconId;
    }

    public boolean isPendingAudit()
    {
        return isPendingAudit;
    }

    public void setPendingAudit(boolean aPendingAudit)
    {
        isPendingAudit = aPendingAudit;
    }
}
