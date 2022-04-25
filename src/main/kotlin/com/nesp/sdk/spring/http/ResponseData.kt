/*
 *
 *   Copyright (c) 2020  NESP Technology Corporation. All rights reserved.
 *
 *   This program is not free software; you can't redistribute it and/or modify it
 *  without the permit of team manager.
 *
 *   Unless required by applicable law or agreed to in writing.
 *
 *   If you have any questions or if you find a bug,
 *   please contact the author by email or ask for Issues.
 *
 *   Author:JinZhaolu <1756404649@qq.com>
 */

package com.nesp.sdk.spring.http

import com.google.gson.GsonBuilder
import org.springframework.http.HttpStatus
import java.io.Serializable

/**
 * Team: NESP Technology
 * Author: <a href="mailto:1756404649@qq.com">靳兆鲁 Email:1756404649@qq.com</a>
 * Time: Created 2020/6/9 22:34
 * Project: server
 **/
open class ResponseData<T> : Serializable {

    var code: Int = 0
    var msg: String = ""
    var success = false
    var data: T? = null

    constructor()

    constructor(code: Int, msg: String, data: T?) {
        this.code = code
        this.msg = msg
        this.data = data
        this.success = code == HttpStatus.OK.value()
    }

    constructor(code: Int, msg: String) {
        this.code = code
        this.msg = msg
        this.success = code == HttpStatus.OK.value()
    }

    constructor(httpStatus: HttpStatus, msg: String) {
        this.code = httpStatus.value()
        this.msg = msg
        this.success = httpStatus.value() == HttpStatus.OK.value()
    }

    constructor(httpStatus: HttpStatus) {
        this.code = httpStatus.value()
        this.msg = httpStatus.reasonPhrase
        this.success = httpStatus == HttpStatus.OK
    }

    constructor(httpStatus: HttpStatus, data: T?) {
        this.code = httpStatus.value()
        this.msg = httpStatus.reasonPhrase
        this.data = data
        this.success = httpStatus == HttpStatus.OK
    }

    override fun toString(): String {
        return GsonBuilder().setPrettyPrinting().create().toJson(this)
    }

}