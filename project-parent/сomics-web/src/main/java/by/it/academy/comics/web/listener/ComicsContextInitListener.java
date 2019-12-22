package by.it.academy.comics.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import by.it.academy.comics.db.connection.ElDataSource;
import by.it.academy.comics .db.migration.DbMigration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ResourceBundle;

@WebListener()
public class ComicsContextInitListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(ComicsContextInitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Context initialized");
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("mysql_hikari");
            ElDataSource.configure(bundle);
            DataSource dataSource = ElDataSource.getDataSource();
            DbMigration.migrate(dataSource);
        } catch (Exception e) {
            logger.error("error", e);
            throw new RuntimeException("Datasource initialisation error", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Context destroyed");
    }
}