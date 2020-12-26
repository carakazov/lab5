package work.DAO;

import work.model.Sedan;

import java.sql.SQLException;
import java.util.List;

public interface IDao {
    List<Sedan> getAll() throws SQLException;
    Sedan getOne(int id) throws SQLException;
    void delete(int id) throws SQLException;
    void addNew(Sedan sedan) throws SQLException;
    void update(Sedan sedan) throws SQLException;
}
