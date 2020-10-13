package com.bubblefish.forceheroes.extensions;

import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.text.Text;

public class StatusBarWidget {
    public class Slider extends SliderWidget {
        public Slider(int x, int y, int width, int height, Text text, double value) {
            super(x, y, width, height, text, value);
        }

        @Override
        protected void updateMessage() {

        }

        @Override
        protected void applyValue() {

        }
        // implement methods here
    }
}
