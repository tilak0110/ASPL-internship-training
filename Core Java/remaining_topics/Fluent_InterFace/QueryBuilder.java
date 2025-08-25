package remaining_topics.Fluent_InterFace;

//Domain-Specific Language (DSL) Style fluent API: Builds SQL queries in a way that reads like English.
public class QueryBuilder {
    private String table;
    private String whereClause;
    private String orderBy;

    public static QueryBuilder from(String table) {
        QueryBuilder qb = new QueryBuilder();
        qb.table = table;
        return qb;
    }

    public QueryBuilder where(String clause) {
        this.whereClause = clause;
        return this;
    }

    public QueryBuilder orderBy(String column) {
        this.orderBy = column;
        return this;
    }

    public String build() {
        return "SELECT * FROM " + table +
                (whereClause != null ? " WHERE " + whereClause : "") +
                (orderBy != null ? " ORDER BY " + orderBy : "");
    }

    public static void main(String[] args) {
        String sql = QueryBuilder.from("users")
                .where("active=1")
                .orderBy("name")
                .build();
        System.out.println(sql);
    }
}



/*
* 1. from Method — Static Factory:
*       - Static method instead of a constructor for readability,
*       - Creates a new QueryBuilder object and sets the table name
*       - Returns the object so you can chain calls.
* 2. where Method:
*       - Adds a WHERE condition to the query.
*       - eturns this (same object) to keep chaining
* 3. orderBy Method:
*       - Adds an ORDER BY clause.
*       - Again returns this for chaining.
* 4. build Method — Terminal Step
*       - Combines the stored pieces into a final SQL query string.
*       - This is the terminal operation — no more chaining after this.
*
* Use case: Fluent query building, configuration pipelines(HTTP requests, JSON building).
 */