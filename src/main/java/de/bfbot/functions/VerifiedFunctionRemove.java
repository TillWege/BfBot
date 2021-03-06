package de.bfbot.functions;

import de.bfbot.Bot;
import org.javacord.api.event.message.reaction.ReactionAddEvent;
import org.javacord.api.event.message.reaction.ReactionRemoveEvent;
import org.javacord.api.listener.message.reaction.ReactionAddListener;
import org.javacord.api.listener.message.reaction.ReactionRemoveListener;

import java.util.concurrent.CompletableFuture;

public class VerifiedFunctionRemove implements ReactionRemoveListener {

    @Override
    public void onReactionRemove(ReactionRemoveEvent event) {
        Bot.logger.info("Verification remove Event received");
        event.getReaction().ifPresent(reaction ->{
            if(reaction.getEmoji().equalsEmoji("✅")){
                event.getUser().ifPresent(user -> {
                    Bot.Verified.ifPresent(user::removeRole);
                    Bot.logger.info("User: "+user+" unverified");
                });
            }
        });
    }
}

