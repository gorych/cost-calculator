/*
 * This file is generated by jOOQ.
 */
package by.gsu.jooq.tables;


import by.gsu.jooq.DefaultSchema;
import by.gsu.jooq.tables.records.SqliteSequenceRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SqliteSequence extends TableImpl<SqliteSequenceRecord> {

    private static final long serialVersionUID = -1671097179;

    /**
     * The reference instance of <code>sqlite_sequence</code>
     */
    public static final SqliteSequence SQLITE_SEQUENCE = new SqliteSequence();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SqliteSequenceRecord> getRecordType() {
        return SqliteSequenceRecord.class;
    }

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<SqliteSequenceRecord, Object> NAME = createField("name", org.jooq.impl.DefaultDataType.getDefaultDataType("\"\""), this, "");

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled. Deprecation can be turned off using <deprecationOnUnknownTypes/> in your code generator configuration.
     */
    @java.lang.Deprecated
    public final TableField<SqliteSequenceRecord, Object> SEQ = createField("seq", org.jooq.impl.DefaultDataType.getDefaultDataType("\"\""), this, "");

    /**
     * Create a <code>sqlite_sequence</code> table reference
     */
    public SqliteSequence() {
        this(DSL.name("sqlite_sequence"), null);
    }

    /**
     * Create an aliased <code>sqlite_sequence</code> table reference
     */
    public SqliteSequence(String alias) {
        this(DSL.name(alias), SQLITE_SEQUENCE);
    }

    /**
     * Create an aliased <code>sqlite_sequence</code> table reference
     */
    public SqliteSequence(Name alias) {
        this(alias, SQLITE_SEQUENCE);
    }

    private SqliteSequence(Name alias, Table<SqliteSequenceRecord> aliased) {
        this(alias, aliased, null);
    }

    private SqliteSequence(Name alias, Table<SqliteSequenceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> SqliteSequence(Table<O> child, ForeignKey<O, SqliteSequenceRecord> key) {
        super(child, key, SQLITE_SEQUENCE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqliteSequence as(String alias) {
        return new SqliteSequence(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqliteSequence as(Name alias) {
        return new SqliteSequence(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public SqliteSequence rename(String name) {
        return new SqliteSequence(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public SqliteSequence rename(Name name) {
        return new SqliteSequence(name, null);
    }
}
