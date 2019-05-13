package com.mfh.yueru;

public class LoginEntity {

    /**
     * errorCode : 0
     * message : null
     * data : {"id":57342,"customerNo":"166680483","loginName":null,"password":"9bba0b533f2a2e55cd4aaa450619ea12","nickname":null,"name":"马富豪","sex":"1048001","sexDesc":null,"mobile":"15516771992","email":null,"perType":"1001001","longitude":null,"latitude":null,"dummy":null,"deviceToken":null,"random":"PaQCZyg6iC9bJIWwXlXKiRNxl","createTime":"2017-12-11 20:08:12","status":"1023001","statusDesc":null,"headPicId":null,"headPicUrl":null,"cardAuthen":1,"cardAuthenDesc":"已认证","authenCheckStatus":null,"authenCheckStatusDesc":null,"cardType":"1024001","cardTypeDesc":"身份证","cardNo":"4*************1212","personId":57643,"perSign":null,"birthDay":"1993-06-10 00:00:00","ticket":"20f8c5243b4dd4bc85239adbe13ea7a5c88555b5c1df45fccc0ba5d342130ad0","headPic":null,"ackV":null,"hasPaymentPwd":true,"isStaff":0,"defaultUserId":null,"cusotmName":"马富豪","customName":"马富豪"}
     * time : 2019-03-10 18:52:18
     */

    private int errorCode;
    private Object message;
    private DataBean data;
    private String time;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
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
         * id : 57342
         * customerNo : 166680483
         * loginName : null
         * password : 9bba0b533f2a2e55cd4aaa450619ea12
         * nickname : null
         * name : 马富豪
         * sex : 1048001
         * sexDesc : null
         * mobile : 15516771992
         * email : null
         * perType : 1001001
         * longitude : null
         * latitude : null
         * dummy : null
         * deviceToken : null
         * random : PaQCZyg6iC9bJIWwXlXKiRNxl
         * createTime : 2017-12-11 20:08:12
         * status : 1023001
         * statusDesc : null
         * headPicId : null
         * headPicUrl : null
         * cardAuthen : 1
         * cardAuthenDesc : 已认证
         * authenCheckStatus : null
         * authenCheckStatusDesc : null
         * cardType : 1024001
         * cardTypeDesc : 身份证
         * cardNo : 4*************1212
         * personId : 57643
         * perSign : null
         * birthDay : 1993-06-10 00:00:00
         * ticket : 20f8c5243b4dd4bc85239adbe13ea7a5c88555b5c1df45fccc0ba5d342130ad0
         * headPic : null
         * ackV : null
         * hasPaymentPwd : true
         * isStaff : 0
         * defaultUserId : null
         * cusotmName : 马富豪
         * customName : 马富豪
         */

        private int id;
        private String customerNo;
        private Object loginName;
        private String password;
        private Object nickname;
        private String name;
        private String sex;
        private Object sexDesc;
        private String mobile;
        private Object email;
        private String perType;
        private Object longitude;
        private Object latitude;
        private Object dummy;
        private Object deviceToken;
        private String random;
        private String createTime;
        private String status;
        private Object statusDesc;
        private Object headPicId;
        private Object headPicUrl;
        private int cardAuthen;
        private String cardAuthenDesc;
        private Object authenCheckStatus;
        private Object authenCheckStatusDesc;
        private String cardType;
        private String cardTypeDesc;
        private String cardNo;
        private int personId;
        private Object perSign;
        private String birthDay;
        private String ticket;
        private Object headPic;
        private Object ackV;
        private boolean hasPaymentPwd;
        private int isStaff;
        private Object defaultUserId;
        private String cusotmName;
        private String customName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCustomerNo() {
            return customerNo;
        }

        public void setCustomerNo(String customerNo) {
            this.customerNo = customerNo;
        }

        public Object getLoginName() {
            return loginName;
        }

        public void setLoginName(Object loginName) {
            this.loginName = loginName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Object getSexDesc() {
            return sexDesc;
        }

        public void setSexDesc(Object sexDesc) {
            this.sexDesc = sexDesc;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getPerType() {
            return perType;
        }

        public void setPerType(String perType) {
            this.perType = perType;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getDummy() {
            return dummy;
        }

        public void setDummy(Object dummy) {
            this.dummy = dummy;
        }

        public Object getDeviceToken() {
            return deviceToken;
        }

        public void setDeviceToken(Object deviceToken) {
            this.deviceToken = deviceToken;
        }

        public String getRandom() {
            return random;
        }

        public void setRandom(String random) {
            this.random = random;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getStatusDesc() {
            return statusDesc;
        }

        public void setStatusDesc(Object statusDesc) {
            this.statusDesc = statusDesc;
        }

        public Object getHeadPicId() {
            return headPicId;
        }

        public void setHeadPicId(Object headPicId) {
            this.headPicId = headPicId;
        }

        public Object getHeadPicUrl() {
            return headPicUrl;
        }

        public void setHeadPicUrl(Object headPicUrl) {
            this.headPicUrl = headPicUrl;
        }

        public int getCardAuthen() {
            return cardAuthen;
        }

        public void setCardAuthen(int cardAuthen) {
            this.cardAuthen = cardAuthen;
        }

        public String getCardAuthenDesc() {
            return cardAuthenDesc;
        }

        public void setCardAuthenDesc(String cardAuthenDesc) {
            this.cardAuthenDesc = cardAuthenDesc;
        }

        public Object getAuthenCheckStatus() {
            return authenCheckStatus;
        }

        public void setAuthenCheckStatus(Object authenCheckStatus) {
            this.authenCheckStatus = authenCheckStatus;
        }

        public Object getAuthenCheckStatusDesc() {
            return authenCheckStatusDesc;
        }

        public void setAuthenCheckStatusDesc(Object authenCheckStatusDesc) {
            this.authenCheckStatusDesc = authenCheckStatusDesc;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public String getCardTypeDesc() {
            return cardTypeDesc;
        }

        public void setCardTypeDesc(String cardTypeDesc) {
            this.cardTypeDesc = cardTypeDesc;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public int getPersonId() {
            return personId;
        }

        public void setPersonId(int personId) {
            this.personId = personId;
        }

        public Object getPerSign() {
            return perSign;
        }

        public void setPerSign(Object perSign) {
            this.perSign = perSign;
        }

        public String getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(String birthDay) {
            this.birthDay = birthDay;
        }

        public String getTicket() {
            return ticket;
        }

        public void setTicket(String ticket) {
            this.ticket = ticket;
        }

        public Object getHeadPic() {
            return headPic;
        }

        public void setHeadPic(Object headPic) {
            this.headPic = headPic;
        }

        public Object getAckV() {
            return ackV;
        }

        public void setAckV(Object ackV) {
            this.ackV = ackV;
        }

        public boolean isHasPaymentPwd() {
            return hasPaymentPwd;
        }

        public void setHasPaymentPwd(boolean hasPaymentPwd) {
            this.hasPaymentPwd = hasPaymentPwd;
        }

        public int getIsStaff() {
            return isStaff;
        }

        public void setIsStaff(int isStaff) {
            this.isStaff = isStaff;
        }

        public Object getDefaultUserId() {
            return defaultUserId;
        }

        public void setDefaultUserId(Object defaultUserId) {
            this.defaultUserId = defaultUserId;
        }

        public String getCusotmName() {
            return cusotmName;
        }

        public void setCusotmName(String cusotmName) {
            this.cusotmName = cusotmName;
        }

        public String getCustomName() {
            return customName;
        }

        public void setCustomName(String customName) {
            this.customName = customName;
        }
    }
}
