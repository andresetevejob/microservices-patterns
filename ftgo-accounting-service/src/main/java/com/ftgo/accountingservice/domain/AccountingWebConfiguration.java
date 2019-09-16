package com.ftgo.accountingservice.domain;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ftgo.accountingservice.service.AccountServiceConfiguration;

@Configuration
@Import(AccountServiceConfiguration.class)
@ComponentScan
public class AccountingWebConfiguration {
}
