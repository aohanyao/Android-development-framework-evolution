/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package retrofit2.converter.gson;

import android.util.Log;

import com.google.gson.TypeAdapter;
import com.td.framework.module.exception.NetErrorException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class HandlerGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;

    /**
     * 模拟的假数据
     */
    private final List<String> mockResult;

    private final Random random;

    HandlerGsonResponseBodyConverter(TypeAdapter<T> adapter) {
        this.random = new Random();
        this.adapter = adapter;
        mockResult = new ArrayList<>();
        mockResult.add("{\"code\":200,\"message\":\"成功，但是没有数据\",\"data\":[]}");
        mockResult.add("{\"code\":-1,\"message\":\"这里是接口返回的：错误的信息，抛出错误信息提示！\",\"data\":[]}");
        mockResult.add("{\"code\":401,\"message\":\"这里是接口返回的：权限不足，请重新登录！\",\"data\":[]}");
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        // 这里就是对返回结果进行处理
        String jsonString = value.string();
        try {
            // 这里为了模拟不同的网络请求，所以采用了本地字符串的格式然后进行随机选择判断结果。
            int resultIndex = random.nextInt(mockResult.size() + 1);
            if (resultIndex == mockResult.size()) {
                return adapter.fromJson(jsonString);

            } else {
                // 这里模拟不同的数据结构
                jsonString = mockResult.get(resultIndex);

                Log.e("TAG", "这里进行了返回结果的判断:" + jsonString);
                // ------------------ JsonObject 只做了初略的判断，具体情况自定
                JSONObject object = new JSONObject(jsonString);
                int code = object.getInt("code");
                if (code != 200) {
                    throw new NetErrorException(object.getString("message"), code);
                }
                return adapter.fromJson(object.getString("data"));

            }

        } catch (JSONException e) {
            e.printStackTrace();
            throw new NetErrorException("数据解析异常", NetErrorException.PARSE_ERROR);
        } finally {
            value.close();
        }
    }
}
