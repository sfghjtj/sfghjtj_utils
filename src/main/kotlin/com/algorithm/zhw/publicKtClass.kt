package com.algorithm.zhw

import com.sun.deploy.util.StringUtils

/**
 * Created by sfghjtj on 2018/5/19.
 */
class BussinessBlockingException(vararg args: String) : RuntimeException(StringUtils.join(args.asList(), ","))