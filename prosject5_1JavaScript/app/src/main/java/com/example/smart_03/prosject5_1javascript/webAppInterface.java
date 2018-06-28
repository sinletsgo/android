package com.example.smart_03.prosject5_1javascript;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class webAppInterface {
    Context mContext;

    webAppInterface(Context c){
        mContext =c;
    }
    //메서드 정의 --> 자바스크립트에서 안드로이드 메서드 호출
    // JavascriptInterface 넣어주어야 web에서 javaScript를 호출 가능
    @JavascriptInterface
    public void showToast (String toast){ //javascript에서 showToast호출하며 파라미터로 값받아 화면출력
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }


}
