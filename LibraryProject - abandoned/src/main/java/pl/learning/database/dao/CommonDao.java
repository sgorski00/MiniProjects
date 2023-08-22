package pl.learning.database.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import pl.learning.database.dbutils.DbManager;
import pl.learning.database.models.BaseModel;

import java.sql.SQLException;
import java.util.List;

public abstract class CommonDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonDao.class);
    protected final ConnectionSource connectionSource;

    public CommonDao() {
        this.connectionSource = DbManager.getConnectionSource();
    }

    public <T extends BaseModel, I> void creatOrUpdate(BaseModel baseModel) throws SQLException {
        Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
        dao.createOrUpdate((T) baseModel);
    }

    public <T extends BaseModel, I> void refresh(BaseModel baseModel){
        try {
            Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
            dao.refresh((T) baseModel);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        } finally {
            this.closeDbConnection();
        }
    }

    public <T extends BaseModel, I> void delete(BaseModel baseModel) {
        try {
            Dao<T, I> dao = getDao((Class<T>) baseModel.getClass());
            dao.delete((T) baseModel);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        } finally {
            this.closeDbConnection();
        }
    }

    public <T extends BaseModel, I> void deleteById(Class<T> cls, Integer id) {
        try {
            Dao<T, I> dao = getDao(cls);
            dao.deleteById((I) id);
        } catch (SQLException e) {
            LOGGER.warn(e.getCause().getMessage());
        } finally {
            this.closeDbConnection();
        }
    }

    public <T extends BaseModel, I> T findById(Class<T> cls, Integer id) throws SQLException {
        Dao<T, I> dao = getDao(cls);
        return dao.queryForId((I) id);
    }

    public <T extends BaseModel, I> List<T> queryForAll(Class<T> cls) throws SQLException {
        Dao<T, I> dao = getDao(cls);
        return dao.queryForAll();
    }


    public <T extends BaseModel, I> Dao<T, I> getDao(Class<T> cls) throws SQLException {
        return DaoManager.createDao(connectionSource, cls);
    }

    public <T extends BaseModel, I> QueryBuilder<T, I> getQueryBuilder(Class<T> cls) throws SQLException {
        Dao<T, I> dao = getDao(cls);
        return dao.queryBuilder();
    }

    private void closeDbConnection() {
        try {
            this.connectionSource.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
