package impl.factories;

import impl.layouts.SimpleLayout;
import impl.layouts.XmlLayout;
import interfaces.Factory;
import interfaces.Layout;

public class LayoutFactory implements Factory<Layout> {
    @Override
    public Layout produce(String input) {
        Layout layout = null;

        if(input.equals("SimpleLayout")){
            layout = new SimpleLayout();
        } else if (input.equals("XmlLayout")){
            layout = new XmlLayout();
        }

        return layout;
    }
}
