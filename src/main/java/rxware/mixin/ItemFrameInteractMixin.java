package rxware.mixin;

import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rxware.RXWare;

@Mixin(ItemFrameEntity.class)
public class ItemFrameInteractMixin {
    @Inject(method = "setHeldItemStack(Lnet/minecraft/item/ItemStack;Z)V", at = @At("TAIL"))
    private void onSetHeldItem(ItemStack value, boolean update, CallbackInfo ci) {
        RXWare.LOGGER.info("Added '" + value.getItem().getName() + "' entity to item frame.");
    }
}
