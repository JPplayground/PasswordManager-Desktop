package passwordmanager.database.SQLStatementBulderTests;

import org.junit.After;
import passwordmanager.database.DatabaseConnection;
import passwordmanager.database.DatabaseConstants;
import passwordmanager.database.SQLStatementBuilder;
import org.junit.jupiter.api.*;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;


public class TableCreationTest {

    private static Connection connection;

    @BeforeEach
    public void openConnection() throws SQLException {
        DatabaseConnection.setConnection(true);
        connection = DatabaseConnection.getConnection();
    }

    @AfterEach
    public void closeConnection() throws SQLException {
        connection.close();
    }


    @Test
    public void testEntryTableCreation() throws SQLException {

        SQLStatementBuilder sqlStatementBuilder;
        PreparedStatement createTable;

        sqlStatementBuilder = new SQLStatementBuilder();

        createTable = sqlStatementBuilder.prepareEntryTableCreationStatement();
        assertDoesNotThrow(() -> createTable.executeUpdate());

        String sql = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC' AND TABLE_NAME = ?;";
        PreparedStatement checkTable = this.connection.prepareStatement(sql);
        checkTable.setString(1, DatabaseConstants.ENTRIES_TABLE_NAME);

        ResultSet resultSet = checkTable.executeQuery();
        assertTrue(resultSet.next());

        int tableCount = resultSet.getInt(1);
        assertEquals(1, tableCount);

    }

    @Test
    public void testCommonEmailsTableCreation() throws SQLException {

        SQLStatementBuilder sqlStatementBuilder;
        PreparedStatement createTable;

        sqlStatementBuilder = new SQLStatementBuilder();

        createTable = sqlStatementBuilder.prepareCommonEmailsTableCreationStatement();
        assertDoesNotThrow(() -> createTable.executeUpdate());

        String sql = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'PUBLIC' AND TABLE_NAME = ?;";
        PreparedStatement checkTable = this.connection.prepareStatement(sql);
        checkTable.setString(1, DatabaseConstants.COMMON_EMAILS_TABLE_NAME);

        ResultSet resultSet = checkTable.executeQuery();
        assertTrue(resultSet.next());

        int tableCount = resultSet.getInt(1);
        assertEquals(1, tableCount);

    }
}