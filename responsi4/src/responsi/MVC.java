package responsi;

public class MVC {
    public void menuutama(){
        view viewresponsi = new view();
        model modelresponsi = new model();
        controlleer Controller = new controlleer(viewresponsi, modelresponsi);
    }
}
