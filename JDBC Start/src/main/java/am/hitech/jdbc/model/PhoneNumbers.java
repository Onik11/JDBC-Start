package am.hitech.jdbc.model;

public class PhoneNumbers {
    private int id;
    private int number;
    private int phoneCodeId;
    private Integer userId;

    public PhoneNumbers(int id, int number, int phoneCodeId, Integer userId){
        this.id=id;
        this.number=number;
        this.phoneCodeId=phoneCodeId;
        this.userId=userId;

    }
    public PhoneNumbers(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPhoneCodeId() {
        return phoneCodeId;
    }

    public void setPhoneCodeId(int phoneCodeId) {
        this.phoneCodeId = phoneCodeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PhoneNumbers{" +
                "number=" + number +
                ", userId=" + userId +
                '}';
    }
}
