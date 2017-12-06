package com.weasel.secret.common.test;

import com.weasel.secret.common.helper.Md5Helper;

import java.io.File;
import java.io.IOException;

/**
 * Created by dell on 2017/12/6.
 */
public class Md5HelperTests {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\apks\\secret-android-0.2.apk");
        String md5 = Md5Helper.md5Hex(file);
        System.out.println(md5);
    }
}
