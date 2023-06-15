package task6.Builder;

public class Director {
    private CBuilder worker;
    public BCProduct construct(){
        worker.BuildPart();
        return worker.getResult();
    };
}
