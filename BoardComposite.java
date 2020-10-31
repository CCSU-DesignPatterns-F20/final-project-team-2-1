import java.util.List;

public abstract class BoardComposite extends BoardComponent {
    
    private List<BoardComponent> subComponents ;

    public List<BoardComponent> getChild(){
        return subComponents;
    }

    public BoardComposite composite() {
        return this;
    }

    public void add(BoardComponent component){

    }

    public void remove(BoardComponent component){

    }
}