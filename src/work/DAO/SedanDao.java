package work.DAO;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.stereotype.Repository;
import work.model.Sedan;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SedanDao implements IDao{
    private final String user = "root";
    private final String password = "yfgjktjy1813";
    private final DataSource dataSource = new MysqlDataSource();

    public SedanDao(){
    }

    public List<Sedan> getAll() throws SQLException {
        Connection connection = dataSource.getConnection(user, password);
        String selectString = "SELECT * FROM autos.sedans";
        PreparedStatement statement = connection.prepareStatement(selectString);
        ResultSet set = statement.executeQuery();
        List<Sedan> sedans = new ArrayList<>();
        while (set.next()){
            int id = set.getInt("id");
            String mark = set.getString("mark");
            String model = set.getString("model");
            int weigth = set.getInt("weight");
            int maxSpeed = set.getInt("maxSpeed");
            Sedan sedan = new Sedan(mark, model, weigth, maxSpeed);
            sedan.setId(id);
            sedans.add(sedan);
        }
        return sedans;
    }

    public Sedan getOne(int id) throws SQLException {
        Connection connection = dataSource.getConnection(user, password);
        String selectString = "SELECT * FROM autos.sedans WHERE id = ?";
        PreparedStatement select = connection.prepareStatement(selectString);
        select.setInt(1, id);
        ResultSet result = select.executeQuery();
        result.next();
        int autoId = result.getInt("id");
        String mark = result.getString("mark");
        String model = result.getString("model");
        int weight = result.getInt("weight");
        int maxSpeed = result.getInt("maxSpeed");
        Sedan sedan = new Sedan(mark, model, weight, maxSpeed);
        sedan.setId(autoId);
        return sedan;
    }

    public void delete(int id) throws SQLException{
        Connection connection = dataSource.getConnection(user, password);
        String deleteString = "DELETE FROM autos.sedans WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(deleteString);
        statement.setInt(1, id);
        statement.execute();
    }

    @Override
    public void addNew(Sedan sedan) throws SQLException {
        Connection connection = dataSource.getConnection(user, password);
        String inputString = "INSERT INTO autos.sedans(mark, model, weight, maxSpeed)" +
                " VALUES(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(inputString);
        statement.setString(1, sedan.getMark());
        statement.setString(2, sedan.getModel());
        statement.setInt(3, sedan.getWeight());
        statement.setInt(4, sedan.getMaxSpeed());
        statement.execute();
    }

    @Override
    public void update(Sedan sedan) throws SQLException {
        Connection connection = dataSource.getConnection(user, password);
        String inputString = "UPDATE autos.sedans SET mark = ?, model = ?, weight = ?, maxSpeed = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(inputString);
        statement.setString(1, sedan.getMark());
        statement.setString(2, sedan.getModel());
        statement.setInt(3, sedan.getWeight());
        statement.setInt(4, sedan.getMaxSpeed());
        statement.setInt(5, sedan.getId());
        statement.execute();
    }
}
