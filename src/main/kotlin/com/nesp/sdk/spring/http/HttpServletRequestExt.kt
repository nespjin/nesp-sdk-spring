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

import jakarta.servlet.http.HttpServletRequest

/**
 * Team: NESP Technology
 * Author: <a href="mailto:1756404649@qq.com">靳兆鲁 Email:1756404649@qq.com</a>
 * Time: Created 2020/6/9 21:37
 * Project: server
 **/

/**
 * Get host url from request
 */
fun HttpServletRequest.hostUrl(): String {
    val url = requestURL
    return url.delete(url.length - requestURI.length, url.length).toString()
}