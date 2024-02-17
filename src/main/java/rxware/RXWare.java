package rxware;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.datafixer.fix.HangingEntityFix;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.*;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraft.util.registry.Registry.*;

public class RXWare implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LogManager.getLogger("rxware");
	public static final TestItem rotor = new TestItem(new FabricItemSettings().group(ItemGroup.MISC));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(ITEM, new Identifier("rxware", "dorito"), rotor);
		LOGGER.info("Wankel power!");

		ServerEntityEvents.ENTITY_LOAD.register(this::onEntityLoad);
	}

	private void onEntityLoad(Entity entity, ServerWorld serverWorld) {
		// Destroys all item frame entities when player loads into world
		CommandManager commands = serverWorld.getServer().getCommandManager();
		if (entity instanceof PlayerEntity player){
			commands.execute(player.getCommandSource(), "kill @e[type=item_frame]");
		}
	}




}
class TestItem extends Item {

	public TestItem(Settings settings) {
		super(settings);
		RXWare.LOGGER.info(("IT IS WORKING DUMBASS!"));
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		// Does something when right-clicking a block with dorito item
		RXWare.LOGGER.info("Did thing with item!");
		RXWare.LOGGER.info(context);

		return ActionResult.SUCCESS;
	}
	@Override
	public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
		// Does something when right-clicking an entity with dorito item
		RXWare.LOGGER.info("Entity: " + entity.getEntityName());

		return ActionResult.SUCCESS;
	}

}
