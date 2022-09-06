package org.bnnetwork.awce.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(net.minecraft.server.Whitelist.class)
public class WhitelistMixin {

    @Inject(method = "toString(Lcom/mojang/authlib/GameProfile;)Ljava/lang/String;", at = @At("HEAD"), cancellable = true)
    protected void toString(com.mojang.authlib.GameProfile profile, CallbackInfoReturnable<String> cir) {
        cir.setReturnValue(profile.getName());
    }
}
