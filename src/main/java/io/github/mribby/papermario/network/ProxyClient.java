package io.github.mribby.papermario.network;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ProxyClient extends Proxy {
    @Override
    public int getArmorRenderIndex(String name) {
        return RenderingRegistry.addNewArmourRendererPrefix(name);
    }
}
