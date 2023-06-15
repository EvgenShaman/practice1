package task7.Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
    List <Component> sons = new ArrayList<Component>();
    @Override
    public void operation() {
        System.out.println("Я не дерево, я Энт!");
    }
    public void add(Component a){
        sons.add(a);
    }
    public void remove(Component a){
        sons.remove(a);
    }
    public Component getChild(int a){
        return sons.get(a);
    }
}
