package Persistance.sql;

import Persistance.dao.DurationDAO;

/**
 * The type Sql duration dao.
 */
public class SQLDurationDAO implements DurationDAO {
    private final SQLConnector sqlConnector;

    /**
     * Constructor del SQLDurationDAO, le pasamos el conector para hacer la conexion a la base de datos
     *
     * @param sqlConnector le tenemos que pasar un sqlConnector para poder operar con la base de datos
     */
    public SQLDurationDAO(SQLConnector sqlConnector) {
        this.sqlConnector = sqlConnector;
    }

}
