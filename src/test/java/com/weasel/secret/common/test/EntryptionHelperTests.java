package com.weasel.secret.common.test;

import com.weasel.secret.common.helper.EntryptionHelper;
import org.junit.Test;

/**
 * Created by dell on 2017/11/15.
 */
public class EntryptionHelperTests {

    @Test
    public void encryptAndDecreypt() throws Exception {

        String key = "abcdefg";
        String password = "abc66666";
        String entryptPassword = EntryptionHelper.encrypt(key,password);
        System.out.println("password : "+password+" entrypt is :"+entryptPassword);

        String _password = EntryptionHelper.decrypt(key,entryptPassword);
        System.out.println("entrypt password : "+entryptPassword+" detrypt is :"+_password);
    }

}
