package com.example.smart_03.ex618_2_listview;

public class SingerItem {
    String name;
    String mobile;

    int restId; // Drawable img

    //생성자
    public SingerItem(String name, String mobile){
        this.name = name;
        this.mobile=mobile;
    }

    public SingerItem(String name, String mobile, int restId){
        this.name = name;
        this.mobile=mobile;
        this.restId=restId;
    }


    //getter / setter 추가
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }



    //객체 결과 메세지
    @Override
    public String toString() {
        String result = "이름" + name;
        result += "전화번호" + mobile;
        result += "이미지" + restId;

        return result;
    }
}
