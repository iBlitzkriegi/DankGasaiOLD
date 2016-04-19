package Main.Memes;

import Main.Settings;
import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.entities.message.MessageBuilder;
import de.btobastian.javacord.listener.message.MessageCreateListener;

public class OhWhale implements MessageCreateListener{
    public void onMessageCreate(DiscordAPI discordAPI, Message message) {
        if(message.getContent().startsWith(Settings.getCommandStart())){
            String[] args = message.getContent().split(" ");
            args[0] = args[0].replaceFirst(Settings.getCommandStart(), "");
            if(args[0].equalsIgnoreCase("ohwhale")){
                message.delete();
                MessageBuilder builder = new MessageBuilder();
                builder.append(Settings.getMsgStart() + "Oh whale, " + message.getAuthor().getMentionTag() + "!");
                message.reply(builder.build());
                message.replyFile(NewMemes.imageCache.get("ohwhale"));


            }
        }
    }
}
