/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.kebsarc.cit.pizzahouse;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author kebsarc
 */
class Sides extends AbstractListModel<String> {

    List<String> sides = new ArrayList<>();

    @Override
    public int getSize() {
        return sides.size();
    }

    @Override
    public String getElementAt(int i) {
        return sides.get(i);
    }

    void add(String name) {
        if (sides.add(name)) {
            fireContentsChanged(this, sides.size(), sides.size());
        } else {
            throw new RuntimeException("failed to add sides " + name);
        }
    }

}
