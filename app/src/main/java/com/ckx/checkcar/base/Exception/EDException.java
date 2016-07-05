package com.ckx.checkcar.base.Exception;

/**
 * Created by lihui on 16/6/21.
 */
public class EDException extends Exception
{
    private static final long serialVersionUID = 6775179545328979398L;

    /**
     *
     */
    public EDException()
    {
        super();
    }

    /**
     * @param aMsg
     */
    public EDException(String aMsg)
    {
        super(aMsg);
    }

    /**
     * @param aMsg
     * @param aThrowable
     */
    public EDException(String aMsg, Throwable aThrowable)
    {
        super(aMsg, aThrowable);
    }

    /**
     * @param aThrowable
     */
    public EDException(Throwable aThrowable)
    {
        super(aThrowable);
    }
}
