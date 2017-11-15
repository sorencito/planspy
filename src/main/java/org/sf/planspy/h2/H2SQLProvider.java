package org.sf.planspy.h2;

import com.p6spy.engine.common.StatementInformation;
import org.sf.planspy.SQLExtractor;
import org.sf.planspy.SQLProvider;

/**
 * Provides plans for the H2 Database, version 1.4
 */
public class H2SQLProvider implements SQLProvider {

    @Override
    public String getSQLProvidingExecPlan(StatementInformation statementInformation) {
        String uppercaseSql = SQLExtractor.getSQL(statementInformation);

        if (uppercaseSql.startsWith("SELECT")) {
            return "EXPLAIN " + uppercaseSql;
        } else {
            return null;
        }
    }
}