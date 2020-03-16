package com.sykean.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ${yanghong}
 * @create 2020/3/10 9:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    //返回码
    private Integer code;

    private String message;

    private T  data;

    public  Response(Integer code,String message){
        this(code,message,null);
    }
}
