package ru.zenicko.demoqa.config.users;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/users/user.properties"})
public interface DemoQaUserDataConfig extends Config {

    @Key("demoqa.userName")
    String userName();

    @Key("demoqa.password")
    String password();

}
