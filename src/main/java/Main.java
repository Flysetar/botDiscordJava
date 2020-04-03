import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder((AccountType.BOT));
        String token = "Njk0MTUwMDY5NjExNjU5Mjc0.XoH1wg.dOwj-vkqHqAwfPQgOnzPiX2F804";
        builder.setToken(token);
        builder.addEventListener(new Main());
        builder.buildAsync();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        System.out.println("We received a message from" +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay()
        );

        //let's use raw so we have the content exactly as the user sent it
        if(event.getMessage().getContentRaw().equals("/60")){
            //remember to call queue()!
            //otherwise our message will never be sent
            event.getChannel().sendMessage("Pong!").queue();
        }
    }
}
