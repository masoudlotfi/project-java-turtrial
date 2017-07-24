public class SqlServer implements CrudInterface {
    private CrudInterface crudInterface;

    @Override
    public void save() {
        System.out.print("SqlServer save \n");
    }

    @Override
    public void delete() {
        System.out.print("SqlServer delete \n");
    }
}
