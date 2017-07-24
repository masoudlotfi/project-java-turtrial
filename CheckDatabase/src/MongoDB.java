public class MongoDB implements CrudInterface {

    @Override
    public void save() {
        System.out.print("Mongo save \n");
    }

    @Override
    public void delete() {
        System.out.print("Mongodb delete \n");
    }
}
