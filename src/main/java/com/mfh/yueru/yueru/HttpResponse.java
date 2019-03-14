package com.mfh.yueru.yueru;

import java.util.List;

public class HttpResponse {
  /**
   * errorCode : 0
   * message : SUCCESS
   * data : []
   * time : 2019-03-14 17:38:32
   */

  private int errorCode;
  private String message;
  private String time;
  private List<?> data;

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public List<?> getData() {
    return data;
  }

  public void setData(List<?> data) {
    this.data = data;
  }
}
