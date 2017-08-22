package com.maldou.regex.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupRegex {

    public static void ticketPrice() {
        String str = "【contact-phone:2873 6808】 【票价:由太古广场往数码港:$8.8】 " +
                "【票价:由太古广场往数码港:$11.4】 【票价:由明爱中心往数码港:$8.7】 " +
                "【票价:由玛丽医院往数码港:$4.9】 " +
                "【政府长者及合资格残疾人士公共交通票价优惠计划:政府长者及合资格残疾人士公共交通票价优惠计划】 " +
                "【政府长者及合资格残疾人士公共交通票价优惠计划:以下乘客可以$2.0的车资优惠乘搭本路线： " +
                "- 65岁或以上长者使用长者八达通或个人八达通 - 合资格残疾人士使用「残疾人士身分」个人八达通 註：" +
                "若原有车资已低於$2.0，受惠人士只需支付该原有车资】";

        //regex1: ?<=【票价:.{0,100}:\$ , regex2: ?=】  匹配 regex1之后，regex2之前的内容
        String regex = "(?<=【票价:.{0,100}:\\$(?<price>.{0,100}?)(?=】))"; //此处的$为美元符号
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }

    public static void main(String[] args) {
        ticketPrice();
    }
}
