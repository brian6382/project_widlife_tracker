import org.sql2o.Sql2o;

public class DB {
    //use the line below if you want to run locally replacing user with db username and pass with db password
//    public static Sql2o sql2o=new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "brian", "Access");
    // The line below runs app on heroku comment the line below if you want to run your app locally these are my
    // credentials so they  will not work for you

    public static Sql2o sql2o = new Sql2o( "jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d5a4sco00hbvck", "qlvxmmgocjivur", "53a0922d06fc6be8e5f1aa6ed5188dce2e8fed73b58fe021ad4e8a9d36ab578a");
}
