package com.tshine.server.apiserver.common.factory;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

public final class KeyGenarator {
    public static String getKey(){
        return UUID.randomUUID().toString();
    }

    public static String getDefaultPassword(PasswordEncoder encoder){
        PasswordGeneratorFactory passwordGeneratorFactory = new PasswordGeneratorFactory.PasswordGeneratorBuilder()
                .usePunctuation(true)
                .useDigits(true)
                .useLower(true)
                .useUpper(true)
                .build();

//        return encoder.encode(passwordGeneratorFactory.generate(8));
        return encoder.encode("1");
    }
}
