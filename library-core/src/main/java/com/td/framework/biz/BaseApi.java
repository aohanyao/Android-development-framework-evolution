package com.td.framework.biz;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 基类  API
 */
public class BaseApi {
    /**
     * 网络配置项
     */
    private static NetConfig mConfig = null;
    /**
     * mRetrofit
     */
    private Retrofit mRetrofit;
    /**
     * mClient
     */
    private OkHttpClient mClient;
    /**
     * 默认连接超时时间
     */
    private static final long DEFAULT_CONNECT_TIMEOUT_MILLS = 40 * 1000L;
    /**
     * 默认读取超时时间
     */
    private static final long DEFAULT_READ_TIMEOUT_MILLS = 40 * 1000L;
    /**
     * 实例
     **/
    private static BaseApi instance;

    private BaseApi() {
        mRetrofit = null;
        mClient = null;
    }


    /**
     * 创建 Retrofit
     *
     * @return Retrofit
     */
    public static synchronized Retrofit createRetrofit() {
        return getInstance().getRetrofit();
    }


    /**
     * 单例 获取
     *
     * @return BaseApi
     */
    private static synchronized BaseApi getInstance() {
        if (instance == null)
            instance = new BaseApi();
        return instance;
    }


    /**
     * 创建class
     *
     * @param service 服务class
     * @param <C>     类泛型
     * @return 泛型
     */
    public static <C> C get(Class<C> service) {
        return getInstance().getRetrofit().create(service);
    }


    /**
     * 注册配置
     *
     * @param config
     */
    public static void registerConfig(NetConfig config) {
        BaseApi.mConfig = config;
        //赋值为空
        instance = null;
    }


    /**
     * 获取Retrofit
     *
     * @return 获取Retrofit
     */
    public Retrofit getRetrofit() {
        if (mRetrofit == null) {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(mConfig.configBaseUrl())//配置BaseUrl
                    .client(getHttpClient())// 设置client
                    .addConverterFactory(GsonConverterFactory.create());//gson转换器
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
            mRetrofit = builder.build();
        }
        return mRetrofit;
    }


    /**
     * 获取httpclient
     *
     * @return OkHttpClient
     */
    private OkHttpClient getHttpClient() {
        if (mClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            // 连接超时时间
            builder.connectTimeout(mConfig.configConnectTimeoutMills() != 0
                    ? mConfig.configConnectTimeoutMills()
                    : DEFAULT_CONNECT_TIMEOUT_MILLS, TimeUnit.MILLISECONDS);
            // 读取超时时间
            builder.readTimeout(mConfig.configReadTimeoutMills() != 0
                    ? mConfig.configReadTimeoutMills() : DEFAULT_READ_TIMEOUT_MILLS, TimeUnit.MILLISECONDS);

            // 拦截器
            Interceptor[] interceptors = mConfig.configInterceptors();
            if (interceptors != null && interceptors.length > 0) {
                for (Interceptor interceptor : interceptors) {
                    builder.addInterceptor(interceptor);
                }
            }
            if (mConfig.configLogEnable()) {//配置打印
                HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
                logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                builder.addInterceptor(logInterceptor);
            }

            mClient = builder.build();
        }
        return mClient;
    }

    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> FlowableTransformer<T, T> getScheduler() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
