package com.autoframework.dateformat;

import com.autoframework.tools.DateFormat;
import org.testng.annotations.Test;

public class DateFormatTest {

    @Test
    public void test(){
        DateFormat.format(DateFormat.ZH_DATE_FORMAT);
    }
}
