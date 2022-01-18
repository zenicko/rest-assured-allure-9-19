package ru.zenicko.demoqa.config.urls;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/urls/urls.properties"})
public interface UrlsConfig extends Config {

    @Key("url.api.base")
    String urlApiBase();

    @Key("bookstore.get.books")
    String bookstoreGetBooks();

    @Key("account.post.GenerateToken")
    String accountPostGenerateToken();
}
