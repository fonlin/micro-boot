/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.microframework.boot.autoconfigure.web;

import com.microframework.boot.web.BsException;
import com.microframework.boot.web.Result;
import com.microframework.boot.web.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Iterator;


/**
 * 全局异常处理器
 *
 * @author fonlin
 * @date 2021/4/7
 */
@RestControllerAdvice
public class DefaultGlobalExceptionHandler implements GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(DefaultGlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Void> error(Exception e) {
        log.error(e.getMessage(), e);
        return Result.fail(ResultEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BsException.class)
    @ResponseBody
    public Result<Void> error(BsException e) {
        return Result.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<Void> error(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        StringBuilder sb = new StringBuilder();
        for (Iterator<FieldError> it = result.getFieldErrors().iterator(); it.hasNext();) {
            FieldError fieldError = it.next();
            sb.append(fieldError.getDefaultMessage());
            if (it.hasNext()) {
                sb.append(";");
            }
        }
        return Result.fail(ResultEnum.ILLEGAL_ARGUMENT.getCode(), sb.toString());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public Result<Void> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        return Result.fail(ResultEnum.ILLEGAL_ARGUMENT.getCode(), e.getMessage());
    }
}
