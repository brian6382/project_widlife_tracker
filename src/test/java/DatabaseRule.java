import org.junit.rules.ExternalResource;
import org.sql2o.Sql2o;
import org.sql2o.*;
public class DatabaseRule extends ExternalResource {

    @Override
    public void before(){
        //use the line below if you want to run locally replacing user with your database username and pass with password
        DB.sql2o=new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "brian", "Access");
        // The line below runs app on heroku comment the line below if you want to run your app locally these are my
        // credentials so they  will not work for you
//        DB.sql2o=new Sql2o("jdbc:postgresql://ec2-34-228-100-83.compute-1.amazonaws.com:5432/d5a4sco00hbvck", "qlvxmmgocjivur", "53a0922d06fc6be8e5f1aa6ed5188dce2e8fed73b58fe021ad4e8a9d36ab578a");

    }

    @Override
    public void after(){
        try (Connection con = DB.sql2o.open()){

            String deleteAnimalQuery="DELETE FROM animals ";
            String deleteSightingsQuery="DELETE FROM sightings *";
            String deleteRangerQuery="DELETE FROM rangers";
            con.createQuery(deleteAnimalQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();
            con.createQuery(deleteRangerQuery).executeUpdate();
            String deleteLocationQuery="DELETE FROM locations *";
            con.createQuery(deleteLocationQuery).executeUpdate();
        }
    }

}
