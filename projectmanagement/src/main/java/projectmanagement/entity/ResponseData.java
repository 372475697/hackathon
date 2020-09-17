package projectmanagement.entity;

public class ResponseData {
    private String code;
    private String message;
    private Object object;

    public ResponseData() {
    }

    public ResponseData(String code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public  static ResponseData success(Object object){
        return new ResponseData("0000","success",object);
    }

    public  static ResponseData success(String message,Object object){
        return new ResponseData("0000",message,object);
    }

    public  static ResponseData fail(String code,String message){
        return new ResponseData(code,message,"");
    }
}
