package entity;

/**
 * 状态码实体类
 */
public class StatusCode {

    public static final int OK = 20000;//成功
    public static final int ERROR =20001;//失败
    public static final int LOGINERROR =20002;//用户名或密码
    public static final int ACCESSERROR =20003;//权限不足
    public static final int REMOTEERROR =20004;//远程调用失败
    public static final int REPERROR =20005;//重复操作

    public StatusCode() {
    }

    public static int getOK() {
        return OK;
    }

    public static int getERROR() {
        return ERROR;
    }

    public static int getLOGINERROR() {
        return LOGINERROR;
    }

    public static int getACCESSERROR() {
        return ACCESSERROR;
    }

    public static int getREMOTEERROR() {
        return REMOTEERROR;
    }

    public static int getREPERROR() {
        return REPERROR;
    }
}
