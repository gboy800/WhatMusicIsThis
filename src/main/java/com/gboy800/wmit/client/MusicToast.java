package com.gboy800.wmit.client;

import com.gboy800.wmit.util.SoundFileUtils;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;

import java.util.List;

public class MusicToast implements Toast {

    private SoundInstance soundInstance;
    private long duration;

    public MusicToast(SoundInstance soundInstance) {
        this.soundInstance = soundInstance.getSource() == SoundSource.MUSIC ? soundInstance : null;
    }

    @Override
    public Visibility render(PoseStack pPoseStack, ToastComponent pToastComponent, long pTimeSinceLastVisible) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, TEXTURE);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        pToastComponent.blit(pPoseStack, 0, 0, 0, 0, this.width(), this.height());
        if (soundInstance != null) {
            // TODO: Convert sound file names into music names
            String filePath = soundInstance.getSound().getLocation().getPath();
            for (int i = filePath.length() - 1; i >= 0; i--) {
                if (filePath.charAt(i) == '/') {
                    filePath = filePath.substring(i + 1, filePath.length());
                    break;
                }
            }
            List<FormattedCharSequence> list = pToastComponent.getMinecraft().font.split(FormattedText.of(SoundFileUtils.fileNametoSong(filePath)), 125);
            if (list.size() == 1) {
                pToastComponent.getMinecraft().font.draw(pPoseStack, "Now Playing", 30.0F, 7.0F, 16776960 | -16777216);
                pToastComponent.getMinecraft().font.draw(pPoseStack, list.get(0), 30.0F, 18.0F, -1);
            } else {
                int j = 1500;
                float f = 300.0F;
                int i1 = Mth.floor(Mth.clamp((float)(pTimeSinceLastVisible - 1500L) / 300.0F, 0.0F, 1.0F) * 252.0F) << 24 | 67108864;
                int l = this.height() / 2 - list.size() * 9 / 2;

                for(FormattedCharSequence formattedcharsequence : list) {
                    pToastComponent.getMinecraft().font.draw(pPoseStack, formattedcharsequence, 30.0F, (float)l, -1);
                    l += 9;
                }

            }
            pToastComponent.getMinecraft().getItemRenderer().renderAndDecorateFakeItem(new ItemStack(Items.MUSIC_DISC_5.asItem()), 8, 8);
            return pTimeSinceLastVisible >= 5000L ? Toast.Visibility.HIDE : Toast.Visibility.SHOW;
        }
        else {
            return Visibility.HIDE;
        }

    }
}
