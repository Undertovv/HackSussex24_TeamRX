package rxware.mixin;

import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rxware.RXWare;



@Mixin(ItemFrameEntity.class)
public class ItemFrameInteractMixin {
    Item potentialDorito;
    @Inject(method = "setHeldItemStack(Lnet/minecraft/item/ItemStack;Z)V", at = @At("TAIL"))
    private void onSetHeldItem(ItemStack value, boolean update, CallbackInfo ci) {
        if (!Registry.ITEM.getId(RXWare.rotor).equals(Registry.ITEM.getId(value.getItem()))) {
            return;
        }
        RXWare.LOGGER.info("Added '" + value.getItem().getName() + "' entity to item frame.");
        potentialDorito = value.getItem();
    }
    @Inject(method = "setRotation(IZ)V", at = @At("TAIL"))
    private void setRotation(int value, boolean bl, CallbackInfo ci) {
        if (!Registry.ITEM.getId(RXWare.rotor).equals(Registry.ITEM.getId(potentialDorito))) {
            return;
        }
        RXWare.LOGGER.info("ITS FUCKING SPINNING!");
    }
}
