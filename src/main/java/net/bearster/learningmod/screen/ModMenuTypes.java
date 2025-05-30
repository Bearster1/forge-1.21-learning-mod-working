package net.bearster.learningmod.screen;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.screen.custom.CoalGeneratorMenu;
import net.bearster.learningmod.screen.custom.CrystallizerMenu;
import net.bearster.learningmod.screen.custom.PedestalMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, LearningMod.MOD_ID);

    public static final RegistryObject<MenuType<PedestalMenu>> PEDESTAL_MENU =
            registerMenuType("pedestal_menu", PedestalMenu::new);

    public static final RegistryObject<MenuType<CrystallizerMenu>> CRYSTALLIZER_MENU =
            registerMenuType("crystallizer_menu", CrystallizerMenu::new);

    public static final RegistryObject<MenuType<CoalGeneratorMenu>> COAL_GENERATOR_MENU =
            registerMenuType("coal_generator_menu", CoalGeneratorMenu::new);

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(String name,
                                                                                                 IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
