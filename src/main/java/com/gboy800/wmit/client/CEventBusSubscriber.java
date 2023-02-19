package com.gboy800.wmit.client;

import com.gboy800.wmit.WhatMusicIsThis;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WhatMusicIsThis.MODID, value = Dist.CLIENT)
public class CEventBusSubscriber {

    @SubscribeEvent
    public static void onMusicChange(PlaySoundEvent event) {
        if (event.getSound().getSource() == SoundSource.MUSIC) {
            Minecraft.getInstance().getToasts().addToast(new MusicToast(event.getSound()));
        }
    }
}
