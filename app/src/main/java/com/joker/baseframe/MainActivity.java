package com.joker.baseframe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.joker.mysdk.entity.BaseEntity;
import com.joker.mysdk.net.Api;
import com.joker.mysdk.net.NetWorkUtil;
import com.joker.mysdk.net.RetrofitHelper;
import com.joker.mysdk.net.SubscribeWrapper;
import com.joker.mysdk.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.result)
    TextView tv_result;
    @BindView(R.id.btn)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                requestMovieList();
            }
        });
    }

    private void requestMovieList(){
        RetrofitHelper.getInstance().getApiService(Api.class)
                .getMovieList("hot","0","1000")
                .compose(NetWorkUtil.<BaseEntity>rxSchedulerHelper())
                .subscribe(new SubscribeWrapper<BaseEntity>(new SubscribeWrapper.RequestListener<BaseEntity>() {
                    @Override
                    public void onSuccess(BaseEntity baseEntity) {
                        LogUtil.e(baseEntity.toString());
                    }

                    @Override
                    public void onFail(String message) {
                        LogUtil.e(message);
                    }
                }));
    }

}
