package com.weasel.secret.common.test;

import com.weasel.secret.common.domain.Secret;
import com.weasel.secret.common.domain.Subject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/11/21.
 */
public class SubjectTests {

    @Test
    public void encryptAndDecryptAllSecret() throws Exception {

        String key = "yy!@#_+=";
        Subject subject = new Subject();

        List<Secret> secrets  = new ArrayList<Secret>();
        Secret secret1 = new Secret();
        secret1.setName("登录密码");
        secret1.setValue("abc4568975364");
        secrets.add(secret1);


        Secret secret2 = new Secret();
        secret2.setName("支付密码");
        secret2.setValue("cdf5656435465");
        secrets.add(secret2);

        subject.setSecrets(secrets);
        System.out.println("加密前:"+subject.toString());
        subject.entryptAllSecret(key);
        System.out.println("加密后:"+subject.toString());
        subject.decryptAllSecret(key);
        System.out.println("解密后:"+subject.toString());
    }
}
