package edu.dhu.poetryanalysis.service;


import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;

public class AnalysisService {
    //设置APPID/AK/SK
    public static final String APP_ID = "25954989";
    public static final String API_KEY = "SxXgNKfrTn3Tb8iKQ6K5owvi";
    public static final String SECRET_KEY = "ADkr5hgwnCwYy4zwpGDCUNPEC0lxMW8i";
    private static final AnalysisService instance = new AnalysisService();
    private AnalysisService(){


        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("127.0.0.1", 7890);  // 设置http代理
//        client.setSocketProxy("127.0.0.1", 7890);  // 设置socket代理
        // 调用接口

    }
    public static AnalysisService getInstance() {
        return instance;
    }
    public String getRes(String text) {
        if (Objects.equals(text, "")) {
            return "输入字符串为空！";
        }
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        HashMap<String, Object> options = new HashMap<String, Object>();

        JSONObject res = client.sentimentClassify(text, options);
        System.out.println(res.toString(2));
        return res.toString(2);
    }
}