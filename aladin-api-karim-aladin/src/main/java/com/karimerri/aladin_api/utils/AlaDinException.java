package com.karimerri.aladin_api.utils;


public class AlaDinException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public AlaDinException()
	{
		super();
	}

	public AlaDinException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AlaDinException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public AlaDinException(String message)
	{
		super(message);
	}

	public AlaDinException(Throwable cause)
	{
		super(cause);
	}
	
}
