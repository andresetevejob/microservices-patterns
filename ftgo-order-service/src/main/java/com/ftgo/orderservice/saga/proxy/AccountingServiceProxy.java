package com.ftgo.orderservice.saga.proxy;

import com.ftgo.accountservice.api.AccountingServiceChannels;
import com.ftgo.accountservice.api.command.AuthorizeCommand;

import io.eventuate.tram.commands.common.Success;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;

public class AccountingServiceProxy {
	public final CommandEndpoint<AuthorizeCommand> authorize = CommandEndpointBuilder
			.forCommand(AuthorizeCommand.class)
			.withChannel(AccountingServiceChannels.accountingServiceChannel)
			.withReply(Success.class).build();
}