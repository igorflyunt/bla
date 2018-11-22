package com.softserve.librarymanager.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParameterizedStatement {
    private Map<Integer, String>  params = new ConcurrentHashMap<>();
    private String query;
    private PreparedStatement preparedStatement;

    private int parameterIndex = 1;

    public ParameterizedStatement(String query) throws SQLException {
        this.query = query;
        this.preparedStatement = DataSource.getDbConnection().prepareStatement(this.query);
    }

    public synchronized ParameterizedStatement setInt(String paramName, int id) {
        replaceWithQuestionMark(paramName);
        params.put(parameterIndex, String.valueOf(id));
        parameterIndex++;
        return this;
    }

    public synchronized ParameterizedStatement setString(String paramName, String value) {
        replaceWithQuestionMark(paramName);
        params.put(parameterIndex, value);
        parameterIndex++;
        return this;
    }

    public synchronized ParameterizedStatement setDate(String paramName, Date value) {
        replaceWithQuestionMark(paramName);
        params.put(parameterIndex, String.valueOf(value));
        parameterIndex++;
        return this;
    }

    public synchronized PreparedStatement getPreparedStatement() throws SQLException {
        System.out.println(query);
        this.preparedStatement = DataSource.getDbConnection().prepareStatement(query);
        setPreparedStatementParams();
        return preparedStatement;
    }

    private void setPreparedStatementParams() throws SQLException {
        for (Integer integer : params.keySet()) {
            String param = params.get(integer);
            preparedStatement.setObject(integer, param);
        }
    }

    private void replaceWithQuestionMark(String paramName) {
        StringBuilder stringBuilder = new StringBuilder(query);
        int paramPos = stringBuilder.indexOf(paramName);
        if (paramPos == -1)
            return;
        int start = stringBuilder.indexOf(paramName, paramPos);
        stringBuilder.replace(start, start + paramName.length(), "?");
        this.query = stringBuilder.toString();
    }
}
