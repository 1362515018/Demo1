package com.example.gaochao.demo1;

import android.net.wifi.aware.DiscoverySession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.district.DistrictResult;
import com.baidu.mapapi.search.district.DistrictSearch;
import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;

public class MainActivity extends AppCompatActivity {
    private MapView mMapView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        BaiduMap mBaidumap = mMapView.getMap();

        //设定中心点坐标
        LatLng cenpt = new LatLng(36.6990093960,110.9472026633);
        //定义地图状态
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(cenpt)
                .zoom(18)
                .build();

        /*DistrictSearch mDistrictSearch = DistrictSearch.newInstance();//初始化行政区检索
        mDistrictSearch.setOnDistrictSearchListener(listener );//设置回调监听

        DistrictSearchOption districtSearchOption = new DistrictSearchOption();
        districtSearchOption.cityName(cityStr);//检索城市名称
        districtSearchOption.districtName(districtStr);//检索的区县名称
        mDistrictSearch.searchDistrict(districtSearchOption);//请求行政区数据

        OnGetDistricSearchResultListener listener = new OnGetDistricSearchResultListener() {
            @Override
            public void onGetDistrictResult(DistrictResult districtResult) {

            }
        };*/


        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        //改变地图状态
        mBaidumap.setMapStatus(mMapStatusUpdate);


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}
