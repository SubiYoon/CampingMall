package com.camp.camping;

import java.util.Locale;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.SimpleLocaleContext;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.i18n.LocaleContextResolver;

@Configuration
public class LocaleResolve implements LocaleContextResolver {

    @Override
    public LocaleContext resolveLocaleContext(ServerWebExchange exchange) {
        //String language = exchange.getRequest().getHeaders().getFirst("Accept-Language");
        String language = exchange.getRequest().getQueryParams().getFirst("lang");
        Locale targetLocale = Locale.getDefault();
        if (language != null && !language.isEmpty()) {
            targetLocale = Locale.forLanguageTag(language);
        }
        return new SimpleLocaleContext(targetLocale);
    }

    @Override
    public void setLocaleContext(ServerWebExchange exchange, LocaleContext localeContext) {
        throw new UnsupportedOperationException("Not Supported");
    }

}