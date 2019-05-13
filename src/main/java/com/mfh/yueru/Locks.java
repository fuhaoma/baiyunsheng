package com.mfh.yueru;


import java.util.List;

public class Locks {

  /**
   * errorCode : 0
   * message : SUCCESS
   * data : {"majorKeys":[{"id":"132372","name":null,"comment":null,"order":0,"pictureId":null,"tdId":"02b7b58836dc941cc4ba33d16dab6e3059","tdName":"1606Z门锁","tpType":null,"canBeLocked":false,"autherId":32,"autherName":"系统","authedId":57342,"authedName":"马富豪","major":true,"startTime":"2019-01-01 20:16","endTime":"2019-12-31 23:59","enable":true,"createTime":"2019-01-01 20:16:27","lockModel":"02","effective":true,"keyboardPwd":null,"keyboardAble":false,"keyboardCanDel":false,"keyboardLimitEndTime":null,"singleDelete":true,"areaType":3,"lockStatus":null}],"otherKeys":[],"lockedOrPowerCut":{"lock":null,"power":null},"openModes":null}
   * time : 2019-03-14 18:52:57
   */

  private int errorCode;
  private String message;
  private DataBean data;
  private String time;

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

  public DataBean getData() {
    return data;
  }

  public void setData(DataBean data) {
    this.data = data;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public static class DataBean {
    /**
     * majorKeys : [{"id":"132372","name":null,"comment":null,"order":0,"pictureId":null,"tdId":"02b7b58836dc941cc4ba33d16dab6e3059","tdName":"1606Z门锁","tpType":null,"canBeLocked":false,"autherId":32,"autherName":"系统","authedId":57342,"authedName":"马富豪","major":true,"startTime":"2019-01-01 20:16","endTime":"2019-12-31 23:59","enable":true,"createTime":"2019-01-01 20:16:27","lockModel":"02","effective":true,"keyboardPwd":null,"keyboardAble":false,"keyboardCanDel":false,"keyboardLimitEndTime":null,"singleDelete":true,"areaType":3,"lockStatus":null}]
     * otherKeys : []
     * lockedOrPowerCut : {"lock":null,"power":null}
     * openModes : null
     */

    private LockedOrPowerCutBean lockedOrPowerCut;
    private Object openModes;
    private List<MajorKeysBean> majorKeys;
    private List<?> otherKeys;

    public LockedOrPowerCutBean getLockedOrPowerCut() {
      return lockedOrPowerCut;
    }

    public void setLockedOrPowerCut(LockedOrPowerCutBean lockedOrPowerCut) {
      this.lockedOrPowerCut = lockedOrPowerCut;
    }

    public Object getOpenModes() {
      return openModes;
    }

    public void setOpenModes(Object openModes) {
      this.openModes = openModes;
    }

    public List<MajorKeysBean> getMajorKeys() {
      return majorKeys;
    }

    public void setMajorKeys(List<MajorKeysBean> majorKeys) {
      this.majorKeys = majorKeys;
    }

    public List<?> getOtherKeys() {
      return otherKeys;
    }

    public void setOtherKeys(List<?> otherKeys) {
      this.otherKeys = otherKeys;
    }

    public static class LockedOrPowerCutBean {
      /**
       * lock : null
       * power : null
       */

      private Object lock;
      private Object power;

      public Object getLock() {
        return lock;
      }

      public void setLock(Object lock) {
        this.lock = lock;
      }

      public Object getPower() {
        return power;
      }

      public void setPower(Object power) {
        this.power = power;
      }
    }

    public static class MajorKeysBean {
      /**
       * id : 132372
       * name : null
       * comment : null
       * order : 0
       * pictureId : null
       * tdId : 02b7b58836dc941cc4ba33d16dab6e3059
       * tdName : 1606Z门锁
       * tpType : null
       * canBeLocked : false
       * autherId : 32
       * autherName : 系统
       * authedId : 57342
       * authedName : 马富豪
       * major : true
       * startTime : 2019-01-01 20:16
       * endTime : 2019-12-31 23:59
       * enable : true
       * createTime : 2019-01-01 20:16:27
       * lockModel : 02
       * effective : true
       * keyboardPwd : null
       * keyboardAble : false
       * keyboardCanDel : false
       * keyboardLimitEndTime : null
       * singleDelete : true
       * areaType : 3
       * lockStatus : null
       */

      private String id;
      private Object name;
      private Object comment;
      private int order;
      private Object pictureId;
      private String tdId;
      private String tdName;
      private Object tpType;
      private boolean canBeLocked;
      private int autherId;
      private String autherName;
      private int authedId;
      private String authedName;
      private boolean major;
      private String startTime;
      private String endTime;
      private boolean enable;
      private String createTime;
      private String lockModel;
      private boolean effective;
      private Object keyboardPwd;
      private boolean keyboardAble;
      private boolean keyboardCanDel;
      private Object keyboardLimitEndTime;
      private boolean singleDelete;
      private int areaType;
      private Object lockStatus;

      public String getId() {
        return id;
      }

      public void setId(String id) {
        this.id = id;
      }

      public Object getName() {
        return name;
      }

      public void setName(Object name) {
        this.name = name;
      }

      public Object getComment() {
        return comment;
      }

      public void setComment(Object comment) {
        this.comment = comment;
      }

      public int getOrder() {
        return order;
      }

      public void setOrder(int order) {
        this.order = order;
      }

      public Object getPictureId() {
        return pictureId;
      }

      public void setPictureId(Object pictureId) {
        this.pictureId = pictureId;
      }

      public String getTdId() {
        return tdId;
      }

      public void setTdId(String tdId) {
        this.tdId = tdId;
      }

      public String getTdName() {
        return tdName;
      }

      public void setTdName(String tdName) {
        this.tdName = tdName;
      }

      public Object getTpType() {
        return tpType;
      }

      public void setTpType(Object tpType) {
        this.tpType = tpType;
      }

      public boolean isCanBeLocked() {
        return canBeLocked;
      }

      public void setCanBeLocked(boolean canBeLocked) {
        this.canBeLocked = canBeLocked;
      }

      public int getAutherId() {
        return autherId;
      }

      public void setAutherId(int autherId) {
        this.autherId = autherId;
      }

      public String getAutherName() {
        return autherName;
      }

      public void setAutherName(String autherName) {
        this.autherName = autherName;
      }

      public int getAuthedId() {
        return authedId;
      }

      public void setAuthedId(int authedId) {
        this.authedId = authedId;
      }

      public String getAuthedName() {
        return authedName;
      }

      public void setAuthedName(String authedName) {
        this.authedName = authedName;
      }

      public boolean isMajor() {
        return major;
      }

      public void setMajor(boolean major) {
        this.major = major;
      }

      public String getStartTime() {
        return startTime;
      }

      public void setStartTime(String startTime) {
        this.startTime = startTime;
      }

      public String getEndTime() {
        return endTime;
      }

      public void setEndTime(String endTime) {
        this.endTime = endTime;
      }

      public boolean isEnable() {
        return enable;
      }

      public void setEnable(boolean enable) {
        this.enable = enable;
      }

      public String getCreateTime() {
        return createTime;
      }

      public void setCreateTime(String createTime) {
        this.createTime = createTime;
      }

      public String getLockModel() {
        return lockModel;
      }

      public void setLockModel(String lockModel) {
        this.lockModel = lockModel;
      }

      public boolean isEffective() {
        return effective;
      }

      public void setEffective(boolean effective) {
        this.effective = effective;
      }

      public Object getKeyboardPwd() {
        return keyboardPwd;
      }

      public void setKeyboardPwd(Object keyboardPwd) {
        this.keyboardPwd = keyboardPwd;
      }

      public boolean isKeyboardAble() {
        return keyboardAble;
      }

      public void setKeyboardAble(boolean keyboardAble) {
        this.keyboardAble = keyboardAble;
      }

      public boolean isKeyboardCanDel() {
        return keyboardCanDel;
      }

      public void setKeyboardCanDel(boolean keyboardCanDel) {
        this.keyboardCanDel = keyboardCanDel;
      }

      public Object getKeyboardLimitEndTime() {
        return keyboardLimitEndTime;
      }

      public void setKeyboardLimitEndTime(Object keyboardLimitEndTime) {
        this.keyboardLimitEndTime = keyboardLimitEndTime;
      }

      public boolean isSingleDelete() {
        return singleDelete;
      }

      public void setSingleDelete(boolean singleDelete) {
        this.singleDelete = singleDelete;
      }

      public int getAreaType() {
        return areaType;
      }

      public void setAreaType(int areaType) {
        this.areaType = areaType;
      }

      public Object getLockStatus() {
        return lockStatus;
      }

      public void setLockStatus(Object lockStatus) {
        this.lockStatus = lockStatus;
      }
    }
  }
}
