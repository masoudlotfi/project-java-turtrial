public class Application implements Runnable {

    public Application(CrudInterface crudInterface) {
        this.crudInterface = crudInterface;
    }

    private CrudInterface crudInterface;

    @Override
    public void run() {
        crudInterface.save();
        crudInterface.delete();
    }

}
