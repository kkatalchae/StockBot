package com.bot.stock;

import com.bot.stock.util.TokenUtil;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class StockBotApplication extends ListenerAdapter {

  private static JDA bot;
  private static String discordToken;

  private static TokenUtil tokenUtil = TokenUtil.getInstance();

  public static void main(String[] args) throws LoginException {

    discordToken = tokenUtil.getToken();

    // JAVA DISCORD API start
    bot = JDABuilder.createDefault(discordToken).build();

    bot.addEventListener(new StockBotApplication());

  }

  @Override
  public void onSlashCommand(@NotNull SlashCommandEvent event) {
    super.onSlashCommand(event);
  }

  @Override
  public void onMessageReceived(@NotNull MessageReceivedEvent event) {
    super.onMessageReceived(event);
  }
}