package com.think.linxuanxuan.picassosample.picassoSource;

import java.lang.annotation.*;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface TestOnly {
}
