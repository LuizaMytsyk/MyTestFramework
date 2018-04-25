package BasicStaffs;

public class CommentsFasade {

    public ManagersList managers(){

        return new ManagersList();

    }

    public PagesList pages (){

        return new PagesList();


    }
}
