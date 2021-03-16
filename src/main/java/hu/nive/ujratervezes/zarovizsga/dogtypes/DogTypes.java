package hu.nive.ujratervezes.zarovizsga.dogtypes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DogTypes {

    private DataSource dataSource;

    public DogTypes(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getDogsByCountry(String country) {
        List<String> result = new ArrayList<>();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement("SELECT name FROM dog_types WHERE country = ?;")
        ) {
            ps.setString(1, country.toUpperCase());
            return getStrings(ps);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed", sqlException);
        }
    }

    private List<String> getStrings(PreparedStatement ps) {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String type = rs.getString("name");
                result.add(type.toLowerCase());
            }
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot query", sqlException);
        }
        return result;
    }


}
