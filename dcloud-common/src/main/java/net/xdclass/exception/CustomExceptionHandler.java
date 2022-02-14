package net.xdclass.exception;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import net.xdclass.util.JsonData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: jian.liu
 * @Description //TODO
 * @Date: 2022/2/14 22:01
 */
@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value= Exception.class)
    @ResponseBody
    public JsonData handler(Exception e){
        if(e instanceof BizException){
            BizException bizException = (BizException) e;
            log.error("[业务异常]{}", e);
            return JsonData.buildCodeAndMsg(bizException.getCode(), bizException.getMsg());
        }else{
            log.error("[系统异常]{}", e);
            return JsonData.buildError("[系统异常]"+ e);
        }

    }
}
