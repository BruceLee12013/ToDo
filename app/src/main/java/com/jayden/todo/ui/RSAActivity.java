package com.jayden.todo.ui;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.jayden.todo.R;
import com.jayden.todo.entry.Biz;
import com.jayden.todo.util.AESUtils;

public class RSAActivity extends AppCompatActivity {

    private TextView pwd;
    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsa);
        pwd=(TextView)findViewById(R.id.entry_codec);
        name=(TextView)findViewById(R.id.entry_name);

        try {
//            RSAUtils.getKeys();
            String data="HyEyEO9Dw1H0btjS/oyv+jGmei43fEE2zOJiMsnmm93OYRFAC6E+Veo7L0HUD4EYfafCOKGBhFE/BdO2dJCuLNPv/YbBIQ4zt/2uloJInfPUEdtYbmBGydVk27CzXcFD6xDzA20bZ5DKNEEA3KiuRgzytBgg5G3ECykshjP8CnY=";
            Biz biz=new Biz(data,"app","site",System.currentTimeMillis()%1000+"");
            String  obj= JSON.toJSONString(biz);
            pwd.setText(obj.toString());

            Gson gson=new Gson();
            String jsonStr=gson.toJson(new Biz(data,"app","site",System.currentTimeMillis()+""));
            String datas=AESUtils.encryptData(AESUtils.DEFAULT_KEY,obj.toString());

            name.setText(jsonStr);


        } catch (Exception e) {


        }


    }
}
