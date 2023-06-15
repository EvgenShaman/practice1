package task6.Builder;

public class CBuilder implements Builder{
    private BCProduct part;
    @Override
    public void BuildPart() {
        part =  new BCProduct();
    }
    public BCProduct getResult(){
        return part;
    }

}
