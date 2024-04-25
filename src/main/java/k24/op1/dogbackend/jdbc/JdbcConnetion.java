/*package k24.op1.dogbackend.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnetion {
    public static void main(String[] args) {
        // databasen tiedot
        String url = "jdbc:postgresql://localhost:jotain/omatietokanta"; //esimerkki osoite
        String user = "username";   //esimerkki käyttäjä
        String password = "password";   //esimerkki salasana

        try {
            // hakee liittymän tietokantaan osoittee ja käyttäjän perusteella 
            Connection connection = DriverManager.getConnection(url, user, password);

            // Luo statementin ja suorittaa kyselyn, lisää meijän taulun nimi
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM meijän taalu");  //korvaa mytable taulun nimellä

            // vastauksen käsittely
            while (resultSet.next()) {
                // prosessoi dataa esim id:n ja nimen perusteella
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // kokelei printtaako id:n ja nimen perusteekka
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // en tiiä pitääkö nää sulkee kun toimii mut kysykää opettajalta
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}*/

