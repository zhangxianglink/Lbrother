# Lbrother
师兄的spring boot
导入sts,并且运行成功
bug????
全局处理异常的思路: 首先定义出格式 Result                 -> status,msg,data
                                               定义出输出结果集工具类ResultUtils  (单纯的用于输出)
                                               为满足逻辑只在service处理引入异常,
                                               针对不同的异常,自定义异常类BoyException -> status, msg
                                              只对全局异常建立ExceptionHandler进行拦截, 识别其中属于BoyException,使用resultUtils输出
                                              自定义异常多了,不好管理,建立枚举类ExceptionEnums. ->status msg  (为BoyException提供数据,被handlel拦截,utils输出)                             